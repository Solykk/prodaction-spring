package com.juja.prodaction.controller;

import com.juja.prodaction.dao.FriendRepository;
import com.juja.prodaction.dao.UserRepository;
import com.juja.prodaction.domain.entity.Friend;
import com.juja.prodaction.domain.entity.Post;
import com.juja.prodaction.domain.entity.User;
import com.juja.prodaction.domain.request.PostRequest;
import com.juja.prodaction.domain.request.UserCreateRequest;
import com.juja.prodaction.service.SimpleCrudRepository;
import com.juja.prodaction.service.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dmitriy Lyashenko
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private SimpleCrudRepository<User, Long> service;
    private Validator<UserCreateRequest> validator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRepository friendRepository;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.readAll());
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequest request){
        validator.validate(request);
        return ResponseEntity.ok(service.create(request.convert()));
    }

    @PostMapping(value = "/{id}/{name}")
    public ResponseEntity<?> addFriend(@PathVariable Long id, @PathVariable String name){
        User user = userRepository.findOne(id);
        Friend friend = friendRepository.findByName(name);

        user.getFriends().add(friend);

        return ResponseEntity.ok(service.update(user));
    }

    @PostMapping(value = "/{id}/post")
    public ResponseEntity<?> makePost(@PathVariable Long id, @RequestBody PostRequest postRequest){
        User user = userRepository.findOne(id);
        user.getPosts().add(new Post(postRequest.getMessage()));

        return ResponseEntity.ok(service.update(user));
    }

    @Autowired
    public void setService(SimpleCrudRepository<User, Long> service) {
        this.service = service;
    }

    @Autowired
    public void setValidator(Validator<UserCreateRequest> validator) {
        this.validator = validator;
    }
}
