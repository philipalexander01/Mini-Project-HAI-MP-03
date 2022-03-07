package com.haimp03.onfashion.controllers.backend;

import java.util.Optional;

import javax.validation.Valid;

import com.haimp03.onfashion.dto.CategoryData;
import com.haimp03.onfashion.entity.Category;
import com.haimp03.onfashion.rest_api.RestWeather;
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
    private RestWeather restWeather;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        return "backend/pages/category/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        model.addAttribute("categoryData", new CategoryData());
        return "backend/pages/category/create";
    }

    @PostMapping("/store")
    public String store(@Valid CategoryData categoryData, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model) {
                try {
                    if (bindingResult.hasErrors()) {
                        model.addAttribute("weatherData", restWeather.getCurrentWeather());
                        return "backend/pages/category/create";
                    } else {
                        categoryService.store(modelMapper.map(categoryData, Category.class));
                        redirectAttributes.addFlashAttribute("successMessage", "Successfully Add New Data");
                    }
                } catch (Exception ex) {
                    if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                        redirectAttributes.addFlashAttribute("errorMessage", "Category Name already available");
                    }                }
       
        return "redirect:/admin/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        model.addAttribute("categoryData", modelMapper.map(categoryService.findById(id).get(), CategoryData.class));
        return "backend/pages/category/edit";
    }

    @PostMapping("/update")
    public String update(@Valid CategoryData categoryData, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                model.addAttribute("weatherData", restWeather.getCurrentWeather());
                return "backend/pages/category/edit";
            } else {
                categoryService.update(modelMapper.map(categoryData, Category.class));
            }
            redirectAttributes.addFlashAttribute("successMessage", "Successfully Update Data");
        } catch (Exception ex) {
            if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Category Name already available");
            }
        }

        return "redirect:/admin/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            categoryService.deleteById(id);
            redirectAttributes.addFlashAttribute("successMessage", "Successfully Deleted Data");
        } catch (Exception ex) {
            if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                redirectAttributes.addFlashAttribute("errorMessage",
                        "Cannot deleted this data because category already used by others product");
            }
        }
        return "redirect:/admin/category";
    }
}
