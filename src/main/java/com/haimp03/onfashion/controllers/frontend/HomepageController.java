package com.haimp03.onfashion.controllers.frontend;

import com.haimp03.onfashion.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomepageController {

    @Autowired
    ProductService productService;
    
    @GetMapping
    public String homepage(Model model) {
        model.addAttribute("products", productService.find4());
        return "frontend/pages/index";
    }

    @GetMapping("/product/{id}")
    public String detailProduct(@PathVariable("id") Long productId) {
        return "frontend/pages/detail";
    }

}
