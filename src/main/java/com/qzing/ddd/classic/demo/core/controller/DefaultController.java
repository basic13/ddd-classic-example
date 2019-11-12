package com.qzing.ddd.classic.demo.core.controller;

import com.qzing.ddd.classic.demo.core.config.BeanFactoryProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author yangyanze
 */
@RestController
@Slf4j
public class DefaultController {

    static {
        RequestMappingHandlerMapping requestMappingHandlerMapping = BeanFactoryProvider.getBean(RequestMappingHandlerMapping.class);
//        RequestMappingHandlerMapping requestMappingHandlerMapping = webApplicationContext.getBean(RequestMappingHandlerMapping.class);
        for (Class<?> autoController : AutoControllerMetadataManager.AUTOCONTROLLER_TYPES) {

            Object obj = BeanFactoryProvider.getBean(autoController);
            assert obj != null;
            AppController appService = autoController.getAnnotation(AppController.class);
            String pre1 = appService.app();
            String pre2 = appService.value();
            StringBuilder prefix = new StringBuilder();
            prefix.append("/");
            if (StringUtils.isBlank(pre1)) {
                prefix.append(pre1);
            }
            if (StringUtils.isBlank(pre2)) {
                if (prefix.length() > 1) {
                    prefix.append("/");
                }
                prefix.append(pre2);
            }

            if (prefix.length() == 1) {
                autoController.getSimpleName();
                prefix.append(autoController.getSimpleName().replace("AppService", "").toLowerCase());
            }


            Method[] ms = autoController.getMethods();
            for (Method m : ms) {
                int mf = m.getModifiers();
                if (m.getDeclaringClass().equals(autoController) && Modifier.isPublic(mf) && !Modifier.isStatic(mf)) {
                    RequestMapping mapping = m.getAnnotation(RequestMapping.class);
                    RequestMappingInfo requestMappingInfo;
                    if (mapping != null) {
                        log.info("Request Mapping: {}", mapping);
                        String[] pathes = new String[mapping.value().length + mapping.path().length];
                        int i = 0;
                        String url = prefix.toString();
                        if (url.endsWith("/")) {
                            url = url.substring(0, url.length() - 1);
                        }
                        for (String s : mapping.value()) {
                            if (s.charAt(0) != '/') {
                                pathes[i] = url + "/" + s;
                            } else {
                                pathes[i] = url + s;
                            }
                            i++;
                        }
                        for (String s : mapping.path()) {
                            if (s.charAt(0) != '/') {
                                pathes[i] = url + "/" + s;
                            } else {
                                pathes[i] = url + s;
                            }
                            i++;
                        }
                        requestMappingInfo = RequestMappingInfo
                                .paths(pathes)
                                .params(mapping.params())
                                .consumes(mapping.consumes())
                                .produces(mapping.produces())
                                .methods(mapping.method())
                                .headers(mapping.headers())
                                .build();
                    } else {
                        StringBuilder url = new StringBuilder();
                        url.append(prefix);
                        String methodName = m.getName();
                        url.append("/").append(methodName);

                        log.info("Auto Mapping Controller: {}", url);

                        requestMappingInfo = RequestMappingInfo
                                .paths(url.toString())
                                .consumes(MediaType.ALL_VALUE)
                                .produces(MediaType.APPLICATION_JSON_VALUE)
                                .build();
                    }


                    requestMappingHandlerMapping.registerMapping(requestMappingInfo, obj, m);
                }
            }
        }
    }
}
