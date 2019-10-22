package com.qzing.ddd.classic.demo.core.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryProvider implements BeanFactoryAware {

    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanFactoryProvider.beanFactory = beanFactory;
    }

    public static DefaultListableBeanFactory getBeanFactory() {
        return (DefaultListableBeanFactory) beanFactory;
    }

    public static <T> T getBean(Class<T> tClass) {
        if (beanFactory == null) {
            return null;
        }
        return beanFactory.getBean(tClass);
    }

    public static Object getBean(String name) {
        return beanFactory.getBean(name);
    }

}
