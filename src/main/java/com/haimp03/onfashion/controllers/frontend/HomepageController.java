package com.haimp03.onfashion.controllers.frontend;

import java.util.List;

import com.haimp03.onfashion.dto.FrontendInterface;
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
        List<FrontendInterface> allProduct = productService.findFrontendProducts();
        List<FrontendInterface> productCategory1 = allProduct.subList(0, 4);
        List<FrontendInterface> productCategory2 = allProduct.subList(4, 8);
        List<FrontendInterface> productCategory3 = allProduct.subList(8, 12);
        model.addAttribute("productCategory1", productCategory1);
        model.addAttribute("productCategory2", productCategory2);
        model.addAttribute("productCategory3", productCategory3);
        return "frontend/pages/index";
    }

    @GetMapping("/product/{id}")
    public String detailProduct(@PathVariable("id") Long productId, Model model) {
        model.addAttribute("productData", productService.findById(productId).get());
        model.addAttribute("recommendedProduct", productService.find4());
        return "frontend/pages/detail";
    }

}
