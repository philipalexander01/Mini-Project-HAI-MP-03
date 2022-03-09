package com.haimp03.onfashion.repository;

import com.haimp03.onfashion.dto.FrontendInterface;
import com.haimp03.onfashion.entity.Product;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
    List<Product> findTop4By();

    @Query(value = "(SELECT p.product_id, p.name AS 'product_name', p.photo, p.price, c.name AS 'category_name' FROM products AS p INNER JOIN categories AS c ON p.category_id = c.category_id WHERE p.category_id = (SELECT category_id FROM (SELECT category_id, COUNT(category_id) AS cnt FROM products GROUP BY category_id ORDER BY cnt DESC LIMIT 1) AS Coba)) UNION (SELECT p.product_id, p.name AS 'product_name', p.photo, p.price, c.name AS 'category_name' FROM products AS p INNER JOIN categories AS c ON p.category_id = c.category_id WHERE p.category_id = (SELECT category_id FROM (SELECT category_id, COUNT(category_id) AS cnt FROM products GROUP BY category_id ORDER BY cnt DESC LIMIT 1 OFFSET 1) AS Coba)) UNION (SELECT p.product_id, p.name AS 'product_name', p.photo, p.price, c.name AS 'category_name' FROM products AS p INNER JOIN categories AS c ON p.category_id = c.category_id WHERE p.category_id = (SELECT category_id FROM (SELECT category_id, COUNT(category_id) AS cnt FROM products GROUP BY category_id ORDER BY cnt DESC LIMIT 1 OFFSET 2) AS Coba))", nativeQuery = true)
    List<FrontendInterface> findTop3FrontendProducts();

    @Modifying
    @Transactional
    @Query(value = "UPDATE products set stock = :stock WHERE product_id = :product_id", nativeQuery = true)
    public void updateStockProduct(@Param("stock") Integer stock,@Param("product_id") Long productId);
 
}
