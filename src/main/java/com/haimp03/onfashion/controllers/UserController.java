package com.haimp03.onfashion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/user")
public class UserController {

    @GetMapping
    public String index(){
        return "backend/pages/user/index";
    }
    
}