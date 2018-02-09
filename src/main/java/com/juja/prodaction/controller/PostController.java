package com.juja.prodaction.controller;

import com.juja.prodaction.dao.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dmitriy Lyashenko
 */
@RestController
@RequestMapping("api/posts")
public class PostController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = "")
    public ResponseEntity<?> getPosts(){
        return ResponseEntity.ok(postRepository.findAll());
    }
}
