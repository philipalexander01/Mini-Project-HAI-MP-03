package com.haimp03.onfashion.service;

import com.haimp03.onfashion.dto.FrontendInterface;
import com.haimp03.onfashion.entity.Product;
import com.haimp03.onfashion.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    public Iterable<Product> find4(){
        return productRepository.findTop4By();
    }

    public List<FrontendInterface> findFrontendProducts() {
        return productRepository.findTop3FrontendProducts();
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
