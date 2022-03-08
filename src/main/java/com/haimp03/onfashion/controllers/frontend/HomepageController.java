package com.haimp03.onfashion.controllers.frontend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.haimp03.onfashion.dto.FrontendInterface;
import com.haimp03.onfashion.dto.TransactionData;
import com.haimp03.onfashion.dto.UserData;
import com.haimp03.onfashion.entity.Product;
import com.haimp03.onfashion.entity.Transaction;
import com.haimp03.onfashion.entity.User;
import com.haimp03.onfashion.service.ProductService;

import com.haimp03.onfashion.service.TransactionService;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class HomepageController {

    @Autowired
    ProductService productService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    ModelMapper modelMapper;
    
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
        model.addAttribute("transactionData", new TransactionData());
        return "frontend/pages/detail";
    }

    @PostMapping("/order")
    public String orderProduct(@Valid TransactionData transactionData, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                return "frontend/pages/detail";
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
                LocalDateTime now = LocalDateTime.now();
                transactionData.setCode(RandomString.make(20) + "_" + dtf.format(now));
                transactionData.product = productService.findById(transactionData.product.getProduct_id()).get();
                transactionService.addTransaction(modelMapper.map(transactionData, Transaction.class));
            }
            redirectAttributes.addFlashAttribute("successMessage","Successfully Add New Data");
        } catch (Exception ex) {
            if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Username already available");
            }
        }
        return "redirect:/";
    }

}
