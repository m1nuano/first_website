package com.demo.m1nuano.website.service;

import com.demo.m1nuano.website.model.User;
import com.demo.m1nuano.website.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService() {
    }

    @Autowired
    public void setUserRepository(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findByUsername(String username) {
        if (userRepo.findById(username).isPresent()) {
            return userRepo.findById(username).get();
        }
        return null;
    }
}