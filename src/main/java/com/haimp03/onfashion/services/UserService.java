package com.haimp03.onfashion.services;


import com.haimp03.onfashion.entity.User;
import com.haimp03.onfashion.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepo;

    // public User save(User user){
    //     return userRepo.save(user);
    // }

    public Iterable<User> findAll(){
        return userRepo.findAll();
    }
    
    
}
