//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.qzing.ddd.classic.demo.core.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class RestResponse<T> {
    @ApiModelProperty("响应结构")
    private Integer code;
    @ApiModelProperty("响应消息")
    private String message;
    @ApiModelProperty("响应数据")
    private T data;

    public RestResponse() {
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == 0 || this.code.equals(200);
    }
}
