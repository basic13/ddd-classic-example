package com.qzing.ddd.classic.demo.core.service;

import com.qzing.ddd.classic.demo.core.config.BeanFactoryProvider;
import com.qzing.ddd.classic.demo.core.inspect.ServiceCodeInspect;

/**
 * @author yangyanze
 */
public class DomainService extends ServiceCodeInspect {
    protected static <T extends AggService> T aggService(Class<T> clazz) {
        T t = BeanFactoryProvider.getBean(clazz);
        assert t != null;
        return t;
    }
}
