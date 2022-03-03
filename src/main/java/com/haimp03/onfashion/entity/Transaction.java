package com.haimp03.onfashion.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_id;

    @Column(length = 100, nullable = false, unique = true)
    private String code;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private double total_price;

    @Column(length = 50, nullable = false)
    private String customer_name;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String phone_number;


}
