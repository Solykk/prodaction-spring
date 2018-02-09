package com.juja.prodaction.exception;

/**
 * @author Dmitriy Lyashenko
 */
public class BaseProductionException extends RuntimeException {

    public final static String DECLINED_STATUS = "DECLINED";
    public final static String ERROR_STATUS = "ERROR";

    public BaseProductionException(String message, Throwable cause) {
        super(message, cause);
    }
}
