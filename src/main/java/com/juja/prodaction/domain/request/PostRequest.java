package com.juja.prodaction.domain.request;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Dmitriy Lyashenko
 */
public class PostRequest {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
    }

}
