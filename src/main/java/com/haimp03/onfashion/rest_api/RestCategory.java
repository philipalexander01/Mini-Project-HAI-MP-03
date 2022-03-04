package com.haimp03.onfashion.rest_api;

import java.util.ArrayList;

import com.haimp03.onfashion.dto.CategoryData;
import com.haimp03.onfashion.entity.Category;
import com.haimp03.onfashion.service.CategoryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/categories")
public class RestCategory {
    @Autowired
    private CategoryService categoryService;

    @Autowired
	private ModelMapper modelMapper;

    @GetMapping
    public ArrayList<CategoryData> index(){
        ArrayList<CategoryData> categories = new ArrayList<>();
        for (Category category : categoryService.findAll()) {
            categories.add(modelMapper.map(category, CategoryData.class));
        }
        return categories;
    }


}
