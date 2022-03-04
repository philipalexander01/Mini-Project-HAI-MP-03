package com.haimp03.onfashion.controllers;

import java.util.Optional;

import javax.validation.Valid;

import com.haimp03.onfashion.dto.CategoryData;
import com.haimp03.onfashion.entity.Category;
import com.haimp03.onfashion.service.CategoryService;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String index(Model model) {
        return "backend/pages/category/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoryData", new CategoryData());
        return "backend/pages/category/create";
    }

    @PostMapping("/store")
    public String store(@Valid CategoryData categoryData, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "backend/pages/category/create";
        } else {
            categoryService.store(modelMapper.map(categoryData, Category.class));
            redirectAttributes.addFlashAttribute("successMessage","Successfully Add New Data");
        }
        return "redirect:/admin/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("categoryData", modelMapper.map(categoryService.findById(id).get(), CategoryData.class)        );
        return "backend/pages/category/edit";
    }

    @PostMapping("/update")
    public String update(@Valid CategoryData categoryData, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "backend/pages/category/edit";
        } else {
            categoryData.setCategory_id(categoryData.category_id);
            categoryService.update(modelMapper.map(categoryData, Category.class));
        }
        redirectAttributes.addFlashAttribute("successMessage","Successfully Update Data");
        return "redirect:/admin/category";
    }

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id){
		categoryService.deleteById(id);
        return "redirect:/admin/category";
	}
}
