package com.qzing.ddd.classic.demo.core.service;

import com.qzing.ddd.classic.demo.core.config.BeanFactoryProvider;
import com.qzing.ddd.classic.demo.core.service.async.AsyncTask;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;

/**
 * @author yangyanze
 */
@Component
public class AppService<AGS extends AggService> {
    protected AGS aggService() {
        AGS ags = BeanFactoryProvider.getBean(getAggClass());
        assert ags != null;
        return ags;
    }

    protected <DMS> DMS domainService(Class<DMS> clazz) {
        DMS dms = BeanFactoryProvider.getBean(clazz);
        assert dms != null;
        return dms;
    }

    protected <PBS> PBS publicService(Class<PBS> clazz) {
        PBS pbs = BeanFactoryProvider.getBean(clazz);
        assert pbs != null;
        return pbs;
    }

    @SuppressWarnings("unchecked")
    private Class<AGS> getAggClass() {
        return (Class<AGS>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public static void main(String[] args) {
        String a=null;
        a.startsWith("1");
    }

    protected void exec(AsyncTask runnable) {
        Thread t = new Thread(() -> {
            try {
                runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
