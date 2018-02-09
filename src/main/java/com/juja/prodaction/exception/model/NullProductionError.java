package com.juja.prodaction.exception.model;

/**
 * @author Dmitriy Lyashenko
 */
public class NullProductionError {

    private String message;
    private String status;
    private String advice;

    public NullProductionError() {
    }

    public NullProductionError(String message, String status, String advice) {
        this.message = message;
        this.status = status;
        this.advice = advice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
