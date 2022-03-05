package com.haimp03.onfashion.repository;

import com.haimp03.onfashion.entity.Category;
import com.haimp03.onfashion.entity.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
 
}
