package com.haimp03.onfashion.controllers.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomepageController {
    
    @GetMapping
    public String homepage() {
        return "frontend/pages/index.html";
    }

    @GetMapping("/product/{id}")
    public String homepage(@PathVariable("id") Long productId) {
        return "frontend/pages/detail.html";
    }

}
