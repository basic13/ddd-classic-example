package com.qzing.ddd.classic.demo.domain.exchange.trans.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * 转账业务
 *
 * @author yangyanze
 */
@Data
public class TransDto {

    @Size(max = 32)
    private String sourceGid;

    @Size(max = 50)
    private String targetCard;

    @Column(length = 50)
    private String targetName;

    @DecimalMin("0.01")
    private BigDecimal amount;
}
