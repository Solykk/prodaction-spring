package com.juja.prodaction.exception.custom;

import com.juja.prodaction.exception.BaseProductionException;
import com.juja.prodaction.exception.model.NullProductionError;

/**
 * @author Dmitriy Lyashenko
 */
public class LenthCustomException extends BaseProductionException{

    private NullProductionError error;

    public LenthCustomException(NullProductionError error) {
        super(error.getMessage(), new RuntimeException());
        this.error = error;
    }

    public NullProductionError getError() {
        return error;
    }

    public void setError(NullProductionError error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "LenthCustomException{" +
                "error=" + error +
                '}';
    }

}
