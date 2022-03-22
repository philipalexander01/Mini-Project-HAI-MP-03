package com.haimp03.onfashion.service;

import java.util.ArrayList;
import java.util.Optional;

import com.haimp03.onfashion.dto.BestSellingProduct;
import com.haimp03.onfashion.dto.SalesPerDayInOneMonthData;

import com.haimp03.onfashion.repository.DashboardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

@Service
public class DashboardService {
    @Autowired
    private DashboardRepository dashboardRepository;

    public Integer getTotalTodayTransaction() {
        return dashboardRepository.getTotalTodayTransaction();
    }

    public Integer getTotalThisMonthTransaction() {
        return dashboardRepository.getTotalThisMonthTransaction();
    };

    public Integer getTotalCategory() {
        return dashboardRepository.getTotalCategory();
    }

    public Integer getTotalProduct() {
        return dashboardRepository.getTotalProduct();
    }

    public ArrayList<SalesPerDayInOneMonthData> getCurrentMonthTransaction(){
        return (ArrayList<SalesPerDayInOneMonthData>) dashboardRepository.getCurrentMonthTransaction();
    }

     public ArrayList<BestSellingProduct> getThreeBestSellingPrduct(){
        return (ArrayList<BestSellingProduct>) dashboardRepository.getThreeBestSellingPrduct();
     }


}
