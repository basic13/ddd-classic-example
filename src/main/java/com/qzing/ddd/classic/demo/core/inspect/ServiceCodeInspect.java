package com.qzing.ddd.classic.demo.core.inspect;

import com.google.common.collect.Sets;
import com.qzing.ddd.classic.demo.core.config.BeanFactoryProvider;
import com.qzing.ddd.classic.demo.core.exception.BizException;
import com.qzing.ddd.classic.demo.core.service.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.core.env.Environment;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yangyanze
 */
@Slf4j
public class ServiceCodeInspect {
    private static final String BASE_PKG;

    static {
        Environment env = BeanFactoryProvider.getBean(Environment.class);
        assert env != null;
        BASE_PKG = env.getProperty("application.basepackage");
    }

    private static Class<AggService> aggService = AggService.class;
    private static Class<AppService> appService = AppService.class;
    private static Class<PublicService> publicService = PublicService.class;
    private static Class<DomainService> domainService = DomainService.class;
    private static Class<EntityService> entityService = EntityService.class;


    private static Map<Class<?>, Set<Class<?>>> ALLOW_LIST = new HashMap<>();

    static {
        ALLOW_LIST.put(appService, Sets.newHashSet(publicService, domainService, aggService, appService));
        ALLOW_LIST.put(publicService, Sets.newHashSet(publicService));
        ALLOW_LIST.put(domainService, Sets.newHashSet(aggService, domainService));
        ALLOW_LIST.put(aggService, Sets.newHashSet(entityService, aggService));
        ALLOW_LIST.put(entityService, Sets.newHashSet(entityService));
    }


    protected static List<Object> buildStack(JoinPoint joinPoint) {
        return doBuildStack(inCheckList(joinPoint.getSignature().getDeclaringType()) ? joinPoint : null);
    }

    protected static List<Object> buildStack() {
        return doBuildStack(null);
    }

    private static List<Object> doBuildStack(Object pre) {
        LinkedList<Object> data = new LinkedList<>();
        if (pre != null) {
            data.push(pre);
        }

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            String cName = stackTraceElement.getClassName();
            if (cName.startsWith(BASE_PKG) && !"<generated>".equals(stackTraceElement.getFileName()) && inCheckList(toClass(stackTraceElement.getClassName()))) {
                data.push(stackTraceElement);
            }
        }
        return data;
    }


    protected static String getSimpleName(String orignal) {
        orignal = orignal.replace(BASE_PKG, "");
        if (orignal.startsWith(".")) {
            orignal = orignal.substring(1);
        }
        return orignal;
    }

    public static void check() {
        check(buildStack());
    }

    public static void check(JoinPoint jp) {
        check(buildStack(jp));
    }

    public static void check(List<Object> stack) {
        Object last = null;
        for (Object now : stack) {
            if (last != null) {

                Class<?> next;
                if (now instanceof StackTraceElement) {
                    StackTraceElement lastSte = (StackTraceElement) now;
                    next = toClass(lastSte.getClassName());
                } else if (now instanceof JoinPoint) {
                    JoinPoint lastJp = (JoinPoint) now;
                    next = lastJp.getSignature().getDeclaringType();
                } else {
                    next = toClass((String) now);
                }

                Class<?> pre;
                String preSign;
                int preLine;
                if (last instanceof StackTraceElement) {
                    StackTraceElement lastSte = (StackTraceElement) last;
                    pre = toClass(lastSte.getClassName());
                    preSign = lastSte.getMethodName();
                    preLine = lastSte.getLineNumber();
                } else if (last instanceof JoinPoint) {
                    JoinPoint lastJp = (JoinPoint) last;
                    pre = lastJp.getSignature().getDeclaringType();
                    preSign = lastJp.getSignature().getName();
                    preLine = 1;
                } else {
                    pre = toClass((String) last);
                    preSign = "";
                    preLine = 1;
                }

                checkLegal(pre, next, preSign, preLine);
            }
            last = now;
        }
    }

    private static Map<Class<?>, List<Class<?>>> legal = new ConcurrentHashMap<>();
    private static Map<Class<?>, List<Class<?>>> illegal = new ConcurrentHashMap<>();
    private static Map<Class<?>, Map<Class<?>, String>> illegalText = new ConcurrentHashMap<>();
    private static Map<String, Class<?>> classCache = new ConcurrentHashMap<>();

    public static Class<?> toClass(String clazz) {
        if (!classCache.containsKey(clazz)) {
            try {
                classCache.put(clazz, Class.forName(clazz));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classCache.get(clazz);
    }

    public static boolean inCheckList(Class<?> in) {
        for (Map.Entry<Class<?>, Set<Class<?>>> entry : ALLOW_LIST.entrySet()) {
            if (entry.getKey().isAssignableFrom(in)) {
                return true;
            }
        }
        return false;
    }


    public static void checkLegal(Class<?> pref, Class<?> next, String preSign, int preLine) {
        if (legal.containsKey(pref) && legal.get(pref).contains(next)) {
            return;
        }
        if (illegal.containsKey(pref) && illegal.get(pref).contains(next)) {
            log.warn(illegalText.get(pref).get(next));
            throw new BizException("代码规范检查不通过！");
        }

        for (Map.Entry<Class<?>, Set<Class<?>>> entry : ALLOW_LIST.entrySet()) {
            if (entry.getKey().isAssignableFrom(pref)) {
                for (Class<?> allAllowed : entry.getValue()) {
                    if (allAllowed.isAssignableFrom(next)) {
                        legal.putIfAbsent(pref, new CopyOnWriteArrayList<>());
                        legal.get(pref).add(next);
                        return;
                    }
                }
            }
        }
        illegal.putIfAbsent(pref, new CopyOnWriteArrayList<>());
        illegal.get(pref).add(next);
        illegalText.putIfAbsent(pref, new ConcurrentHashMap<>());
        illegalText.get(pref).put(next,
                "\n============== BEGIN =============" +
                        "\n代码检验不通过，如下代码不能直接调用：" +
                        "\n调用者：" + pref.getName() + "." + preSign + "(" + pref.getSimpleName() + ".java:" + preLine + ")" +
                        "\n被调用：" + next.getName() + ".(" + next.getSimpleName() + ".java:1)" +
                        "\n==============  END  =============");
        log.warn(illegalText.get(pref).get(next));
        throw new BizException("代码规范检查不通过！");
    }


}
