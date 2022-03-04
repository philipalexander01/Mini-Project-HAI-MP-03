package com.haimp03.onfashion.rest_api;

import com.haimp03.onfashion.entity.User;
import com.haimp03.onfashion.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestUser {

    @Autowired
    private UserService userService;

    @GetMapping("/api/user")
    public Iterable<User> getUser(){
        return userService.findAll();
    }
    
}
