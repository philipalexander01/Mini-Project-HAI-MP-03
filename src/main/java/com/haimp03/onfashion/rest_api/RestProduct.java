package com.haimp03.onfashion.rest_api;

import com.haimp03.onfashion.dto.ProductData;
import com.haimp03.onfashion.entity.Product;
import com.haimp03.onfashion.service.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/admin/products")
public class RestProduct {
    @Autowired
    private ProductService productService;

    @Autowired
	private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<ProductData> index(){
        ArrayList<ProductData> products = new ArrayList<>();
        for (Product product : productService.findAll()) {
            products.add(modelMapper.map(product, ProductData.class));
        }
        return products;
    }


}
