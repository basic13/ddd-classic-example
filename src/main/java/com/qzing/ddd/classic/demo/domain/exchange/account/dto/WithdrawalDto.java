package com.qzing.ddd.classic.demo.domain.exchange.account.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author yangyanze
 */
@Data
public class WithdrawalDto {
    /**
     * gid
     */
    @NotNull
    @Size(max = 32)
    private String gid;
    /**
     * 金额
     */
    @NotNull
    @Min(0)
    private BigDecimal amount;

}
