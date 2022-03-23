package com.haimp03.onfashion.repository;

import com.haimp03.onfashion.dto.BestSellingProduct;
import com.haimp03.onfashion.entity.Transaction;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.haimp03.onfashion.dto.SalesPerDayInOneMonthData;

public interface DashboardRepository extends CrudRepository<Transaction, Long> {

    @Query(value = "SELECT SUM(total_price) as totalTodayTransaction FROM transactions WHERE created_at BETWEEN CONCAT(CURDATE(),' 00:00:00') AND CONCAT(CURDATE(),' 23:59:59.993')", nativeQuery = true)
    public Integer getTotalTodayTransaction();
    
    @Query(value = "SELECT SUM(total_price) as totalThisMonthTransaction FROM transactions WHERE created_at BETWEEN DATE_FORMAT(NOW() ,'%Y-%m-01') AND LAST_DAY(CURDATE())", nativeQuery = true)
    public Integer getTotalThisMonthTransaction();
  
    @Query(value = "SELECT COUNT(category_id) as totalCategory FROM categories", nativeQuery = true)
    public Integer getTotalCategory();
   
    @Query(value = "SELECT COUNT(product_id) as totalproduct FROM products", nativeQuery = true)
    public Integer getTotalProduct();
    
    @Query(value = "SELECT SUM(total_price) as totalSalePerDay, SUBSTRING(created_at, 9, 2) AS day FROM transactions WHERE MONTH(created_at) = MONTH(CURRENT_DATE()) AND YEAR(created_at) = YEAR(CURRENT_DATE()) GROUP BY day ORDER BY day ASC", nativeQuery = true)
    public List<SalesPerDayInOneMonthData> getCurrentMonthTransaction();
    
    @Query(value = "SELECT SUM(t.quantity) as totalSaleProduct, p.name FROM transactions as t JOIN products as p ON p.product_id = t.product_id WHERE created_at BETWEEN DATE_FORMAT(NOW() ,'%Y-%m-01') AND CONCAT(CURRENT_DATE()+interval 3 month,' 23:59:59.993') GROUP BY t.product_id ORDER BY totalSaleProduct DESC LIMIT 3", nativeQuery = true)
    public List<BestSellingProduct> getThreeBestSellingPrduct();


}
