package com.qzing.ddd.classic.demo.domain.exchange.account.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author yangyanze
 */
@Data
public class DeleteAccountDto {
    /**
     * gid
     */
    @NotNull
    @Size(max = 35)
    private String gid;
}
