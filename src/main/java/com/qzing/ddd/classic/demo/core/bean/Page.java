package com.qzing.ddd.classic.demo.core.bean;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yangyanze
 */
@Data
public class Page {
    @NotNull
    @Min(value = 0)
    private Integer page;
    @NotNull
    @Min(value = 1)
    private Integer size;

    public Integer getFirstRow() {
        return (page - 1) * size;
    }
}
