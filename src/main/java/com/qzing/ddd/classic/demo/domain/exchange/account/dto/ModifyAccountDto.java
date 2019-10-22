package com.qzing.ddd.classic.demo.domain.exchange.account.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author yangyanze
 */
@Data
public class ModifyAccountDto {
    /**
     * gid
     */
    @NotNull
    @Size(max = 35)
    private String gid;

    /**
     * 姓名
     */
    @NotNull
    @Size(max = 50)
    private String name;

    /**
     * 身份证号
     */
    @NotNull
    @Size(max = 18)
    private String idcard;

    /**
     * 银行卡号
     */
    @NotNull
    @Size(max = 50)
    private String cardno;
}
