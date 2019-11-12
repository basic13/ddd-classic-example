package com.qzing.ddd.classic.demo.core.controller;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangyanze
 */
public class AutoControllerMetadataManager {
    static final Set<Class<?>> AUTOCONTROLLER_TYPES = new HashSet<>(100);

    public static void addAutoController(Class<?> autoController) {
        AUTOCONTROLLER_TYPES.add(autoController);
    }
}
