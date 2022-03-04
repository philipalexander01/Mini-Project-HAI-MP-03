package com.haimp03.onfashion.controllers.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("admin/category")
public class CategoryController {
    
    @GetMapping(value="/")
    public String index() {
        return "backend/pages/category/index";
    }
    
}
