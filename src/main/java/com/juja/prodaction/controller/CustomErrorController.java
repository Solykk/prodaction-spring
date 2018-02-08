package com.juja.prodaction.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dmitriy Lyashenko
 */
@RestController
public class CustomErrorController implements ErrorController {

    private final static String PATH = "/error";

    @GetMapping(value = PATH)
    public String error(){
        return "Something went wrong!!!";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
