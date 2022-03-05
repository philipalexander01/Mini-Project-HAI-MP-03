package com.haimp03.onfashion.service;

import java.util.Optional;

import com.haimp03.onfashion.entity.Product;
import com.haimp03.onfashion.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public void store(Product product){
        productRepository.save(product);
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);        
    }

    public void update(Product product) {
        productRepository.save(product);
    }
}
