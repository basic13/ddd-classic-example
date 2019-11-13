package com.qzing.ddd.classic.demo.core.controller.automapping;

import com.google.common.base.CaseFormat;
import com.qzing.ddd.classic.demo.core.config.BeanFactoryProvider;
import com.qzing.ddd.classic.demo.core.controller.AppController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangyanze
 */
@RestController
@Slf4j
public class AutoControllerMapping {

    private static String camelToHyphen(String in) {
        return CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_HYPHEN).convert(in);
    }


    static {
        Map<String, RequestMethod> methodPrefix = new HashMap<>();
        methodPrefix.put("get", RequestMethod.GET);
        methodPrefix.put("post", RequestMethod.POST);
        methodPrefix.put("put", RequestMethod.PUT);
        methodPrefix.put("patch", RequestMethod.PATCH);
        methodPrefix.put("delete", RequestMethod.DELETE);

        RequestMappingHandlerMapping requestMappingHandlerMapping = BeanFactoryProvider.getBean(RequestMappingHandlerMapping.class);
        assert requestMappingHandlerMapping != null;

        for (Class<?> autoController : AutoControllerMetadataManager.AUTOCONTROLLER_TYPES) {
            Object controller = BeanFactoryProvider.getBean(autoController);
            assert controller != null;
            AppController appService = autoController.getAnnotation(AppController.class);
            String pre1 = appService.app();
            String pre2 = appService.value();
            StringBuilder prefix = new StringBuilder();
            prefix.append("/");
            if (StringUtils.isNotBlank(pre1)) {
                prefix.append(pre1);
            }
            if (StringUtils.isNotBlank(pre2)) {
                if (prefix.length() > 1) {
                    prefix.append("/");
                }
                prefix.append(pre2);
            }

            if (prefix.length() == 1) {
                prefix.append(camelToHyphen(autoController.getSimpleName().replace(AppController.ENDFIX, "")));
            }


            Method[] ms = autoController.getMethods();
            for (Method action : ms) {
                int mf = action.getModifiers();
                if (action.getDeclaringClass().equals(autoController) && Modifier.isPublic(mf) && !Modifier.isStatic(mf)) {
                    RequestMapping mapping = action.getAnnotation(RequestMapping.class);
                    RequestMappingInfo requestMappingInfo;
                    if (mapping != null) {
                        String[] paths = new String[mapping.value().length + mapping.path().length];
                        int i = 0;
                        String url = prefix.toString();
                        if (url.endsWith("/")) {
                            url = url.substring(0, url.length() - 1);
                        }
                        boolean conflict = false;
                        boolean cover = false;

                        for (String s : mapping.value()) {
                            if (s.charAt(0) != '/') {
                                paths[i] = url + "/" + s;
                            } else {
                                paths[i] = url + s;
                            }

                            if (AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.containsKey(paths[i])) {
                                conflict = true;
                                AutoControllerMetadataManager.AutoControllerMetadata meta = AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.get(paths[i]);
                                cover = appService.priority() > meta.priority;
                                if (cover) {
                                    AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.remove(paths[i]);
                                    requestMappingHandlerMapping.unregisterMapping(meta.requestMappingInfo);
                                    log.info("[Priority {}] Replaced URL path [{}] onto method [{}]", appService.priority(), paths[i], action.toString());
                                } else {
                                    log.info("[Priority {}] Ignored URL path [{}] onto method [{}]", appService.priority(), paths[i], action.toString());
                                }
                            } else {
                                log.info("[Priority {}] Mapped URL path [{}] onto method [{}]", appService.priority(), paths[i], action.toString());
                            }

                            i++;
                        }
                        for (String s : mapping.path()) {
                            if (s.charAt(0) != '/') {
                                paths[i] = url + "/" + s;
                            } else {
                                paths[i] = url + s;
                            }
                            if (AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.containsKey(paths[i])) {
                                conflict = true;
                                AutoControllerMetadataManager.AutoControllerMetadata meta = AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.get(paths[i]);
                                cover = appService.priority() > meta.priority;
                                if (cover) {
                                    AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.remove(paths[i]);
                                    requestMappingHandlerMapping.unregisterMapping(meta.requestMappingInfo);
                                    log.info("[Priority {}] Replaced URL path [{}] onto method [{}]", appService.priority(), paths[i], action.toString());
                                } else {
                                    log.info("[Priority {}] Ignored URL path [{}] onto method [{}]", appService.priority(), paths[i], action.toString());
                                }
                            } else {
                                log.info("[Priority {}] Mapped URL path [{}] onto method [{}]", appService.priority(), paths[i], action.toString());
                            }

                            i++;
                        }
                        if (conflict && !cover) {
                            continue;
                        }

                        requestMappingInfo = RequestMappingInfo
                                .paths(paths)
                                .params(mapping.params())
                                .consumes(mapping.consumes())
                                .produces(mapping.produces())
                                .methods(mapping.method())
                                .headers(mapping.headers())
                                .build();

                        for (String path : paths) {
                            AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.put(path,
                                    new AutoControllerMetadataManager.AutoControllerMetadata(requestMappingInfo, appService.priority()));
                        }
                    } else {
                        RequestMethod method = null;
                        StringBuilder url = new StringBuilder();
                        url.append(prefix);
                        String methodName = action.getName();
                        if (appService.restful()) {
                            for (Map.Entry<String, RequestMethod> entry : methodPrefix.entrySet()) {
                                if (methodName.startsWith(entry.getKey())) {
                                    method = entry.getValue();
                                    methodName = methodName.substring(entry.getKey().length());
                                    break;
                                }
                            }
                        }

                        url.append("/").append(methodName);

                        String urlStr = url.toString();


                        boolean conflict = false;
                        boolean cover = false;

                        if (AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.containsKey(urlStr)) {
                            conflict = true;
                            AutoControllerMetadataManager.AutoControllerMetadata meta = AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.get(urlStr);
                            cover = appService.priority() > meta.priority;
                            if (cover) {
                                requestMappingHandlerMapping.unregisterMapping(meta.requestMappingInfo);
                                AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.remove(urlStr);
                                log.info("[Priority {}] Replaced URL path [{}] onto method [{}]", appService.priority(), urlStr, action.toString());
                            } else {
                                log.info("[Priority {}] Ignored URL path [{}] onto method [{}]", appService.priority(), urlStr, action.toString());
                            }
                        } else {
                            log.info("[Priority {}] Mapped URL path [{}] onto method [{}]", appService.priority(), urlStr, action.toString());
                        }

                        if (conflict && !cover) {
                            continue;
                        }

                        RequestMappingInfo.Builder builder = RequestMappingInfo
                                .paths(urlStr)
                                .consumes(MediaType.ALL_VALUE)
                                .produces(MediaType.APPLICATION_JSON_VALUE);
                        if (method != null) {
                            builder.methods(method);
                        }
                        requestMappingInfo = builder.build();
                        AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS.put(urlStr,
                                new AutoControllerMetadataManager.AutoControllerMetadata(requestMappingInfo, appService.priority()));
                    }


                    requestMappingHandlerMapping.registerMapping(requestMappingInfo, controller, action);
                }
            }
        }

        AutoControllerMetadataManager.AUTOCONTROLLER_ACTIONS = null;
        AutoControllerMetadataManager.AUTOCONTROLLER_TYPES = null;
    }
}
