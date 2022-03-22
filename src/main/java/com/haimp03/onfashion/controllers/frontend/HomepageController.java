package com.haimp03.onfashion.controllers.frontend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.haimp03.onfashion.dto.FrontendInterface;
import com.haimp03.onfashion.dto.TransactionData;
import com.haimp03.onfashion.entity.Product;
import com.haimp03.onfashion.entity.Transaction;
import com.haimp03.onfashion.service.EmailSenderService;
import com.haimp03.onfashion.service.ProductService;
import com.haimp03.onfashion.service.TransactionService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping("")
public class HomepageController {

    @Autowired
    ProductService productService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EmailSenderService mailSender;
    
    @GetMapping
    public String homepage(Model model) {
        List<FrontendInterface> allProduct = productService.findFrontendProducts();
        List<FrontendInterface> productCategory1 = new ArrayList<FrontendInterface>();
        List<FrontendInterface> productCategory2 = new ArrayList<FrontendInterface>();
        List<FrontendInterface> productCategory3 = new ArrayList<FrontendInterface>();

        Set<String> categories = new HashSet<>();
        for(int i =0; i < allProduct.size(); i++){
            categories.add(allProduct.get(i).getCategory_name());
        }
        
        ArrayList<String> listCategory = new ArrayList<String>(categories);
        if(listCategory.size() == 1){
            for(int i =0; i < allProduct.size(); i++){
                if(allProduct.get(i).getCategory_name().equals(listCategory.get(0))){
                    productCategory1.add(allProduct.get(i));
                }
            }
        }else if(listCategory.size() == 2){
            for(int i =0; i < allProduct.size(); i++){
                if(allProduct.get(i).getCategory_name().equals(listCategory.get(0))){
                    productCategory1.add(allProduct.get(i));
                }else if(allProduct.get(i).getCategory_name().equals(listCategory.get(1))){
                    productCategory2.add(allProduct.get(i));
                }
            }
        }else if(listCategory.size() == 3){
            for(int i =0; i < allProduct.size(); i++){
                if(allProduct.get(i).getCategory_name().equals(listCategory.get(0))){
                    productCategory1.add(allProduct.get(i));
                }else if(allProduct.get(i).getCategory_name().equals(listCategory.get(1))){
                    productCategory2.add(allProduct.get(i));
                }else if(allProduct.get(i).getCategory_name().equals(listCategory.get(2))){
                    productCategory3.add(allProduct.get(i));
                }
            }
        }

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
    public String orderProduct(@RequestParam("product_id") Integer productId ,@Valid TransactionData transactionData, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                return "frontend/pages/detail";
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
                LocalDateTime now = LocalDateTime.now();
                transactionData.setCode(RandomString.make(20) + "_" + dtf.format(now));
                transactionData.setStatus("Not Yet Sent");
                Product product = productService.findById(Long.valueOf(productId)).get();
                transactionData.setTotal_price(transactionData.getQuantity()* product.getPrice());
                transactionData.setProduct(product);
                transactionService.addTransaction(modelMapper.map(transactionData, Transaction.class));
                String subject = "Order Confirmation #" + transactionData.getCode();
                String emailBody = "Hello, "+ transactionData.getCustomer_name() +"! \nYour order has been successfully made. Thank you for shopping at our store!\n\nThese are the detail of your order :\n" +
                "Transaction Code : " + transactionData.getCode() + "\n" +
                "Item Name : " + transactionData.getProduct().getName() + "\n" +
                "Quantity : " +transactionData.getQuantity() + "\n" +
                "Total Price : $" + transactionData.getTotal_price() + "\n" +
                "Please make a payment for your order to this account : 7221 8273 1382 888 (BCA - Onfashion Store). \nWe will process you order further after your payment is confirmed";

                mailSender.sendEmail(transactionData.getEmail(), subject, emailBody);
            }
            redirectAttributes.addFlashAttribute("successMessage","Successfully Add New Transaction");
        } catch (Exception ex) {
            if (ex.getCause().getMessage().equalsIgnoreCase("could not execute statement")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Failed Add New Transaction");
            }
        }
        return "redirect:/";
    }

}
