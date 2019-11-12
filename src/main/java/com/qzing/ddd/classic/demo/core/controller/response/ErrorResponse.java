//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.qzing.ddd.classic.demo.core.controller.response;

public class ErrorResponse extends RestResponse {
    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }
}
