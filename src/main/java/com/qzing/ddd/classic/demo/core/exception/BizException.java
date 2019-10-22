package com.qzing.ddd.classic.demo.core.exception;

/**
 * @author yangyanze
 */
public class BizException extends RuntimeException {
    public BizException(String message) {
        super(message);
    }
}
