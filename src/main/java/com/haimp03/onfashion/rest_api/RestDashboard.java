package com.haimp03.onfashion.rest_api;

import com.haimp03.onfashion.dto.BestSellingProduct;
import com.haimp03.onfashion.dto.TransactionData;
import com.haimp03.onfashion.entity.Transaction;
import com.haimp03.onfashion.service.DashboardService;
import com.haimp03.onfashion.service.TransactionService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.haimp03.onfashion.dto.SalesPerDayInOneMonthData;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/admin/dashboard")
public class RestDashboard {

    @Autowired
    private DashboardService dashboardService;


    @GetMapping("/dateSalesPerDayInOneMonth")
    public ArrayList<String> getDateTransaction(){
        ArrayList<SalesPerDayInOneMonthData> data = dashboardService.getCurrentMonthTransaction();
        ArrayList<String> transactionDate = new ArrayList<String>();
        for(int i = 0; i<data.size(); i++){
            transactionDate.add(data.get(i).getDay());
        }
        return transactionDate;
    }

    @GetMapping("/totalSalesPerDayInOneMonth")
    public ArrayList<Integer> getCurrentMonthTransaction(){
        ArrayList<SalesPerDayInOneMonthData> data = dashboardService.getCurrentMonthTransaction();
        ArrayList<Integer> totalTransactionPerDay = new ArrayList<Integer>();
        for(int i = 0; i<data.size(); i++){
            totalTransactionPerDay.add(data.get(i).getTotalSalePerDay());
        }
        return totalTransactionPerDay;
    }


    @GetMapping("/threeBestSellingProductName")
    public ArrayList<String> getThreeBestSellingProductName(){
        ArrayList<BestSellingProduct> data = dashboardService.getThreeBestSellingPrduct();
        ArrayList<String> bestSellingProductName = new ArrayList<String>();
        for(int i = 0; i<data.size(); i++){
            bestSellingProductName.add(data.get(i).getName());
        }
        return bestSellingProductName;
    }

    @GetMapping("/threeBestSellingProductQuantity")
    public ArrayList<Integer> getThreeBestSellingProductQuantity(){
        ArrayList<BestSellingProduct> data = dashboardService.getThreeBestSellingPrduct();
        ArrayList<Integer> bestSellingProductQty = new ArrayList<Integer>();
        for(int i = 0; i<data.size(); i++){
            bestSellingProductQty.add(data.get(i).getTotalSaleProduct());
        }
        return bestSellingProductQty;
    }


}
