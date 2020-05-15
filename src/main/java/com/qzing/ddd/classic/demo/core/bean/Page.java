package com.qzing.ddd.classic.demo.core.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author yangyanze
 */
@ApiModel("分页查询")
@Data
public class Page {
    @ApiModelProperty(value = "页码",required = true)
    @NotNull
    @Min(value = 0)
    private Integer page;

    @ApiModelProperty(value = "每页条数",required = true)
    @NotNull
    @Min(value = 1)
    private Integer size;

    public Integer getFirstRow() {
        return (page - 1) * size;
    }
}
