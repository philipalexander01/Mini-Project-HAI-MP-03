package com.haimp03.onfashion.repository;

import com.haimp03.onfashion.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
