package com.haimp03.onfashion.dto;

import javax.validation.constraints.NotEmpty;

public class CategoryData {
    public Long category_id;

    @NotEmpty(message = "Nama Kategori tidak boleh kosong")
    public String name;
    
    @NotEmpty(message = "Deskripsi Kategori tidak boleh kosong")
    public String description;

    public CategoryData() {
    }



    public CategoryData(Long category_id, String name,
            String description) {
        this.category_id = category_id;
        this.name = name;
        this.description = description;
    }







    public Long getCategory_id() {
        return category_id;
    }


    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
}
