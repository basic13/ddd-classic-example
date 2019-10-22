package com.qzing.ddd.classic.demo.domain.exchange.trans.vo;

import com.qzing.ddd.classic.demo.domain.exchange.trans.model.TransRecord;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yangyanze
 */
@Data
public class TransRecordVo {
    /**
     * 交易流水号
     */
    private String tradeNo;
    /**
     * 转出账户ID
     */
    private String sourceGid;

    /**
     * 转出账户姓名
     */
    private String sourceName;

    /**
     * 转出账户姓名
     */
    private String sourceCard;

    /**
     * 转入账户ID
     */
    private String targetGid;


    /**
     * 转入账户姓名
     */
    private String targetName;

    /**
     * 转入账户姓名
     */
    private String targetCard;


    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 转账状态
     */
    private TransRecord.TransStaus status;

    /**
     * 转账备注
     */
    private String remark;
}
