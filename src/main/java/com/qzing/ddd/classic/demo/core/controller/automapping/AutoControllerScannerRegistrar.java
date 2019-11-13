package com.qzing.ddd.classic.demo.core.controller.automapping;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangyanze
 */
public class AutoControllerScannerRegistrar
        implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes componentScanAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(ComponentScan.class.getName()));
        AutoControllerScanner scanner = new AutoControllerScanner();

        if (resourceLoader != null) {
            scanner.setResourceLoader(resourceLoader);
        }

        Set<String> basePackages = new HashSet<>();
        basePackages.add("com.qzing");
        basePackages.add("com.huiju");

        if (componentScanAttrs != null) {
            for (String pkg : componentScanAttrs.getStringArray("basePackages")) {
                if (StringUtils.isNotBlank(pkg)) {
                    basePackages.add(pkg);
                }
            }
        }
        scanner.registerFilters();
        scanner.doScan(basePackages.toArray(new String[0]));
    }
}
