package com.qzing.ddd.classic.demo.domain.exchange.test.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author yangyanze
 */
@Data
public class TestDto {
    @NotNull
    private String a;
    private String b;
}
