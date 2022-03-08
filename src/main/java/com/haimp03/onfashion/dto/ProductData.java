package com.haimp03.onfashion.dto;

import com.haimp03.onfashion.entity.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductData {
    public Long product_id;

    @NotEmpty(message = "Product Code Cannot Be Empty")
    public String code;

    @NotEmpty(message = "Product Name Cannot Be Empty")
    public String name;
    
    @Min(value = 0, message = "Fill the price")
    @NotNull(message = "Product Price Cannot be Empty")
    public double price;

    // @NotEmpty(message = "Product Photo Cannot Be Empty")
    public String photo;

    @Min(value = 0, message = "Min Stock is 0")
    @NotNull(message = "Product Stock Cannot be Empty")
    public Integer stock;

    @NotEmpty(message = "Product Description Cannot Be Empty")
    public String description;

    @NotNull(message = "Select Product Category")
    public Category category;

  



    public Long getProduct_id() {
        return product_id;
    }


    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getPhoto() {
        return photo;
    }


    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public Integer getStock() {
        return stock;
    }


    public void setStock(Integer stock) {
        this.stock = stock;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }
    

}
