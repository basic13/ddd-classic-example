package com.qzing.ddd.classic.demo.domain.exchange.trans.model;

import com.qzing.ddd.classic.demo.core.model.BaseModel;
import com.qzing.ddd.classic.demo.domain.exchange.account.model.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author yangyanze
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "trans_record")
public class TransRecord extends BaseModel {
    /**
     * 交易流水号
     */
    @Column(length = 50)
    private String tradeNo;
    /**
     * 转出账户ID
     */
    @Column(length = 32)
    private String sourceGid;


    @ManyToOne
    @JoinColumn(name = "source_gid", insertable = false, updatable = false)
    private Account sourceAccount;

    /**
     * 转入账户ID
     */
    @Column(length = 32)
    private String targetGid;


    @ManyToOne
    @JoinColumn(name = "target_gid", insertable = false, updatable = false)
    private Account targetAccount;

    /**
     * 金额
     */
    @Column(scale = 2, precision = 65)
    private BigDecimal amount;
    /**
     * 转账状态
     */
    @Column(length = 10)
    private TransStaus status;

    /**
     * 转账备注
     */
    @Column(length = 50)
    private String remark;

    public enum TransStaus {
        /**
         * 交易成功
         */
        SUCCEED,
        /**
         * 交易失败
         */
        FAILED,
    }

}
