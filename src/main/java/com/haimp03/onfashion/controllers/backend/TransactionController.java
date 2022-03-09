package com.haimp03.onfashion.controllers.backend;

import java.util.Optional;

import com.haimp03.onfashion.entity.Product;
import com.haimp03.onfashion.entity.Transaction;
import com.haimp03.onfashion.rest_api.RestWeather;
import com.haimp03.onfashion.service.ProductService;
import com.haimp03.onfashion.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ProductService productService;

    @Autowired
    private RestWeather restWeather;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        return "backend/pages/transaction/index";
    }
   
    @GetMapping("/update_shipping_status/{id}")
    public String updateTransactionStatus(@PathVariable("id") Long id) {
                transactionService.updateTransactionStatus(id, "Sent");
                Optional<Transaction> transactionData = transactionService.findById(id);
                Optional<Product> productData = productService.findById(transactionData.get().getProduct().getProduct_id());
                productService.updateStockProduct((productData.get().getStock() - transactionData.get().getQuantity()), transactionData.get().getProduct().getProduct_id());
        return "redirect:/admin/transaction";
    }

    @GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
		transactionService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage","Successfully Deleted Data");
        return "redirect:/admin/transaction";
	}

}
