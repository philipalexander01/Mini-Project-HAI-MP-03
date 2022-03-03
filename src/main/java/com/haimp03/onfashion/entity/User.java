package com.haimp03.onfashion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(length = 100, nullable = false)
    private String fullname;

    @Column(length = 100, nullable = false, unique = true)
    private String username;
   
    @Column(length = 100, nullable = false)
    private String password;
}
