package com.juja.prodaction.exception;

import com.juja.prodaction.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Dmitriy Lyashenko
 */
@RestControllerAdvice(basePackageClasses = {UserController.class})
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handelAll(Exception ex){
        LOGGER.warn(ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
