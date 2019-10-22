package com.qzing.ddd.classic.demo.core.service;

import com.qzing.ddd.classic.demo.core.config.BeanFactoryProvider;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

/**
 * @author yangyanze
 */
@Component
public class AppService<M, AGS extends AggService, DMS extends DomainService, PBS extends PublicService> {
    protected AGS aggService() {
        AGS ags = BeanFactoryProvider.getBean(getAggClass());
        assert ags != null;
        return ags;
    }

    protected DMS domainService() {
        DMS dms = BeanFactoryProvider.getBean(getDomainClass());
        assert dms != null;
        return dms;
    }

    protected PBS publicService() {
        PBS pbs = BeanFactoryProvider.getBean(getPublicClass());
        assert pbs != null;
        return pbs;
    }

    @SuppressWarnings("unchecked")
    private Class<AGS> getAggClass() {
        return (Class<AGS>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @SuppressWarnings("unchecked")
    private Class<DMS> getDomainClass() {
        return (Class<DMS>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
    }

    @SuppressWarnings("unchecked")
    private Class<PBS> getPublicClass() {
        return (Class<PBS>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[3];
    }

}
