package com.haimp03.onfashion.service;


import com.haimp03.onfashion.entity.User;
import com.haimp03.onfashion.repository.LoginRepository;
import com.haimp03.onfashion.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private LoginRepository loginRepo;

    public void addUser(User user){
        userRepo.save(user);
    }

    public Iterable<User> findAll(){
        return userRepo.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }

    public void updateUser(User user){
        userRepo.save(user);
    }

    public void updateUserWithoutPassword(User user){
        String username = user.getUsername();
        String fullname = user.getFullname();
        Long user_id = user.getUser_id();
        userRepo.updateUserWithoutPassword(fullname, username, user_id);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }

    public User login(String username, String password){
        return loginRepo.findByUsernameAndPassword(username, password);
    }
    
    
}
