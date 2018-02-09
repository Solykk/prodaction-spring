package com.juja.prodaction.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Dmitriy Lyashenko
 */
//@Component
public class BeanPostProcessorInterceptor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Class<?> clazz = o.getClass();
        System.out.println(String.format("----- [%s] ------", clazz.getSimpleName()));
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
