package com.qzing.ddd.classic.demo.domain.exchange.account.model;

import com.qzing.ddd.classic.demo.core.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author yangyanze
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "account")
public class Account extends BaseModel {
    /**
     * 用户姓名
     */
    @Column(length = 50)
    private String name;
    /**
     * 余额
     */
    @Column(scale = 2, precision = 65)
    private BigDecimal balance;

    /**
     * 身份证号
     */
    @Column(length = 18)
    private String idcard;
    /**
     * 银行卡号
     */
    @Column(length = 50)
    private String cardno;
}
