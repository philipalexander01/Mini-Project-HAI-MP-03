package com.haimp03.onfashion.controllers.backend;

import java.util.Optional;

import javax.validation.Valid;

import com.haimp03.onfashion.dto.CategoryData;
import com.haimp03.onfashion.entity.Category;
import com.haimp03.onfashion.rest_api.RestWeather;
import com.haimp03.onfashion.service.CategoryService;
import com.haimp03.onfashion.service.TransactionService;

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
@RequestMapping("/admin/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private RestWeather restWeather;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        return "backend/pages/transaction/index";
    }
   
    @GetMapping("/update_shipping_status/{id}")
    public String updateTransactionStatus(@PathVariable("id") Long id) {
                transactionService.updateTransactionStatus(id, "Sent");
        return "redirect:/admin/transaction";
    }

    @GetMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
		transactionService.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage","Successfully Deleted Data");
        return "redirect:/admin/transaction";
	}

}
