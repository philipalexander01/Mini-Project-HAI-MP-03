package com.haimp03.onfashion.repository;

import com.haimp03.onfashion.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    
}
