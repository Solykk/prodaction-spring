package com.juja.prodaction.exception;

import com.juja.prodaction.controller.UserController;
import com.juja.prodaction.exception.custom.NullCustomException;
import com.juja.prodaction.exception.model.NullProductionError;
import org.omg.PortableServer.LifespanPolicyOperations;
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

    @ExceptionHandler(NullCustomException.class)
    public ResponseEntity<NullProductionError> handelNullCustomException(NullCustomException ex){
        LOGGER.warn("NullCustomException -> [{}]", ex.getError().toString());
        return ResponseEntity.badRequest().body(ex.getError());
    }
}
