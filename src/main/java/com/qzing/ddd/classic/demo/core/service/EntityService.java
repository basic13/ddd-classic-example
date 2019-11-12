package com.qzing.ddd.classic.demo.core.service;

import com.qzing.ddd.classic.demo.core.bean.Page;
import com.qzing.ddd.classic.demo.core.bean.Result;
import com.qzing.ddd.classic.demo.core.model.BaseModel;
import io.ebean.DB;
import io.ebean.typequery.TQRootBean;

import java.util.List;

/**
 * @author yangyanze
 */
public class EntityService<M extends BaseModel, QM extends TQRootBean<M, QM>> {

    private Class<M> modelClass;
    private Class<QM> modelQueryClass;

    private EntityService() {

    }

    private EntityService(Class<M> modelClass, Class<QM> modelQueryClass) {
        this.modelClass = modelClass;
        this.modelQueryClass = modelQueryClass;
    }

    public static <M extends BaseModel, QM extends TQRootBean<M, QM>> EntityService<M, QM> of(Class<M> mClass, Class<QM> qmClass) {
        return new EntityService<>(mClass, qmClass);
    }

    public QM getQuery() {
        try {
            return modelQueryClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public <DTO> List<DTO> find(Class<DTO> clazz, String sql) {
        return DB.findDto(clazz, sql).findList();
    }

    public Result pageQuery(Page page) {
        QM query = getQuery();
        query.setMaxRows(page.getSize());
        query.setFirstRow(page.getFirstRow());
        return Result.success(query.findPagedList());
    }

    public M findById(Object id) {
        return DB.find(modelClass, id);
    }

    public M save(M t) {
        DB.save(t);
        return t;
    }

    public M update(M t) {
        DB.update(t);
        return t;
    }

    public boolean delete(M t) {
        return DB.delete(t);
    }

    public int deleteAll(List<M> t) {
        return DB.deleteAll(t);
    }
}
