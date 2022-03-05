package com.haimp03.onfashion.rest_api;

import java.util.ArrayList;

import com.haimp03.onfashion.dto.UserData;
import com.haimp03.onfashion.entity.User;
import com.haimp03.onfashion.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/user")
public class RestUser {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<UserData> index(){
        ArrayList<UserData> users = new ArrayList<>();
        for(User user : userService.findAll()){
            users.add(modelMapper.map(user, UserData.class));
        }
        return users;
    }
}
