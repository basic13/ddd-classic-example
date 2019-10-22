package com.qzing.ddd.classic.demo.core.model;

import io.ebean.Model;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;
import io.ebean.annotation.WhoCreated;
import io.ebean.annotation.WhoModified;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @author yangyanze
 */
@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseModel extends Model {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 32)
    private String gid;

    @WhenCreated
    private Timestamp createAt;

    @WhoCreated
    @Column(length = 50)
    private String createBy;

    @WhenModified
    private Timestamp modifyAt;

    @WhoModified
    @Column(length = 50)
    private String modifyBy;
}
