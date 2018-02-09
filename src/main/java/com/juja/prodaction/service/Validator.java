package com.juja.prodaction.service;

/**
 * @author Dmitriy Lyashenko
 */
public interface Validator<T> {

    void validate(T request);

}
