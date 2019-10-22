package com.qzing.ddd.classic.demo.core.service;

import com.qzing.ddd.classic.demo.core.model.BaseModel;
import io.ebean.DB;

/**
 * @author yangyanze
 */
public class EntityService<T extends BaseModel> {
    public T save(T t) {
        DB.save(t);
        return t;
    }
}
