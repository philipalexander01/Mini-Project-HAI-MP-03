package com.haimp03.onfashion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(length = 20, nullable = false, unique = true)
    private String code;

    @Column(length = 150, nullable = false)
    private String name;

    private double price;

    @Column(nullable = false)
    private String photo;

    @Column(length = 255, nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
