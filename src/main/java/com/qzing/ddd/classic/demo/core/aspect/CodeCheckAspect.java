package com.qzing.ddd.classic.demo.core.aspect;

import com.qzing.ddd.classic.demo.core.inspect.ServiceCodeInspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yangyanze
 */
@Aspect
@Component
@Slf4j
public class CodeCheckAspect {
    @Pointcut("execution(public * com.qzing.ddd..service..*(..))")
    public void service() {
    }

    @Pointcut("execution(public * com.qzing.ddd.classic.demo.core.service.EntityService.*(..))")
    public void entityService() {
    }

    @Before("service() || entityService()")
    public void check(JoinPoint joinPoint) {
        ServiceCodeInspect.check(joinPoint);
    }
}
