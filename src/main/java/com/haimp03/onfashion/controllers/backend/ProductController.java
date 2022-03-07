package com.haimp03.onfashion.controllers.backend;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

import javax.validation.Valid;

import com.haimp03.onfashion.dto.CategoryData;
import com.haimp03.onfashion.dto.ProductData;
import com.haimp03.onfashion.entity.Category;
import com.haimp03.onfashion.entity.Product;
import com.haimp03.onfashion.rest_api.RestWeather;
import com.haimp03.onfashion.service.CategoryService;
import com.haimp03.onfashion.service.ProductService;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.SQLGrammarException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.bytebuddy.utility.RandomString;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
    private static String UPLOADED_PRODUCT_PATH = "src/main/resources/static/images/products/";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RestWeather restWeather;
    
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        return "backend/pages/product/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        model.addAttribute("productData", new ProductData());
        model.addAttribute("categoryData", getCategories());
        return "backend/pages/product/create";
    }

    @PostMapping("/store")
    public String store(@Valid ProductData productData, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model,
            @RequestParam("product_photo") MultipartFile photo) {
        try {
            if (bindingResult.hasErrors()) {
                model.addAttribute("weatherData", restWeather.getCurrentWeather());
                model.addAttribute("categoryData", getCategories());
                return "backend/pages/product/create";
            } else {
                String fileName = RandomString.make(10) + "_" + photo.getOriginalFilename();
                productData.setPhoto(fileName);
                byte[] bytes = photo.getBytes();
                Path path = Paths.get(UPLOADED_PRODUCT_PATH + fileName);
                Files.write(path, bytes);
                productService.store(modelMapper.map(productData, Product.class));
                redirectAttributes.addFlashAttribute("successMessage", "Successfully Add New Data");
            }
        } catch (Exception ex) {
            if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Product Code already available");
            }
        }

        return "redirect:/admin/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        model.addAttribute("productData", modelMapper.map(productService.findById(id).get(), ProductData.class));
        model.addAttribute("categoryData", getCategories());
        return "backend/pages/product/edit";
    }

    @PostMapping("/update")
    public String update(@Valid ProductData productData, BindingResult bindingResult,
            RedirectAttributes redirectAttributes, Model model,
             @RequestParam("product_photo") MultipartFile photo
           ) {

        try {
            if (bindingResult.hasErrors()) {
                model.addAttribute("weatherData", restWeather.getCurrentWeather());
                model.addAttribute("categoryData", getCategories());
                return "backend/pages/product/edit";
            } else {
                 if(photo.getOriginalFilename().isEmpty()){
                    productData.setPhoto(productData.getPhoto());
                }else{
                    String fileName = RandomString.make(10) + "_" + photo.getOriginalFilename();
                    productData.setPhoto(fileName);
                    byte[] bytes = photo.getBytes();
                    Path path = Paths.get(UPLOADED_PRODUCT_PATH + fileName);
                    Files.write(path, bytes);
                }
                productService.update(modelMapper.map(productData, Product.class));
                redirectAttributes.addFlashAttribute("successMessage", "Successfully Update Data");
            }
        } catch (Exception ex) {
            if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Product Code already available");
            }
        }
      
        return "redirect:/admin/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Successfully Deleted Data");
        return "redirect:/admin/product";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("weatherData", restWeather.getCurrentWeather());
            model.addAttribute("productData", modelMapper.map(productService.findById(id).get(), ProductData.class));
        } catch (Exception ex) {
            if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                redirectAttributes.addFlashAttribute("errorMessage",
                        "Cannot deleted this data because product already used in transactions");
            }
        }
        return "backend/pages/product/detail";
    }

    private ArrayList<CategoryData> getCategories() {
        ArrayList<CategoryData> categories = new ArrayList<>();
        for (Category category : categoryService.findAll()) {
            categories.add(modelMapper.map(category, CategoryData.class));
        }
        return categories;
    }
}
