package com.haimp03.onfashion.service;

import com.haimp03.onfashion.entity.Category;
import com.haimp03.onfashion.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void store(Category category){
        categoryRepository.save(category);
    }

    public Optional<Category> findById(Long id){
        return categoryRepository.findById(id);
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);        
    }

    public void update(Category category) {
        categoryRepository.save(category);
    }
}
