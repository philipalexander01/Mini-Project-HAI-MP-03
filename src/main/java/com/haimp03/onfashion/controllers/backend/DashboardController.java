package com.haimp03.onfashion.controllers.backend;

import java.util.Optional;

import com.haimp03.onfashion.entity.Product;
import com.haimp03.onfashion.entity.Transaction;
import com.haimp03.onfashion.rest_api.RestWeather;
import com.haimp03.onfashion.service.ProductService;
import com.haimp03.onfashion.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;


    @Autowired
    private RestWeather restWeather;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("weatherData", restWeather.getCurrentWeather());
        model.addAttribute("totalTodayTransaction", dashboardService.getTotalTodayTransaction()!= null?dashboardService.getTotalTodayTransaction():0);
        model.addAttribute("totalThisMonthTransaction", dashboardService.getTotalThisMonthTransaction()!=null?dashboardService.getTotalThisMonthTransaction():0);
        model.addAttribute("totalCategory", dashboardService.getTotalCategory());
        model.addAttribute("totalProduct", dashboardService.getTotalProduct());
        return "backend/pages/dashboard/index";
    }
   

}
