package com.qzing.ddd.classic.demo.core.controller.automapping;

import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangyanze
 */
class AutoControllerMetadataManager {
    static Set<Class<?>> AUTOCONTROLLER_TYPES = new HashSet<>(100);

    static Map<String, AutoControllerMetadata> AUTOCONTROLLER_ACTIONS = new HashMap<>(400);

    static class AutoControllerMetadata {
        AutoControllerMetadata(RequestMappingInfo requestMappingInfo, int priority) {
            this.requestMappingInfo = requestMappingInfo;
            this.priority = priority;
        }

        RequestMappingInfo requestMappingInfo;
        int priority;
    }
}

