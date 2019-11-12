package com.qzing.ddd.classic.demo.core.exception;

/**
 * @author yangyanze
 */
public class ValidateException extends RuntimeException {
    private String field;
    private String hint;

    public ValidateException(String message, String field, String hint) {
        super(message);
        this.field = field;
        this.hint = hint;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
