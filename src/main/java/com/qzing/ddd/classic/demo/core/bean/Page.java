package com.qzing.ddd.classic.demo.core.bean;

import io.ebean.Model;
import io.ebean.typequery.TQRootBean;
import lombok.Data;

/**
 * @author yangyanze
 */
@Data
public class Page<M extends Model, QM extends TQRootBean<M, QM>> {
    private Integer page;
    private Integer size;


    public Result query(QM qm) {
        int count = qm.findCount();
        qm.setFirstRow((page - 1) * size);
        qm.setMaxRows(size);
        return Result.success(qm.findList(), count);
    }
}
