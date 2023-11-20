package com.demo.m1nuano.website.controller;

import com.demo.m1nuano.website.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private UserRepo userRepo;

    @Autowired
    public void setUserRepository(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/index")
    public String toHomepage() {
        return "index";
    }

    @RequestMapping("/users")
    public String showAllUsers(Model model, Pageable pageable) {
        model.addAttribute("users", userRepo.findAll(pageable));
        return "user";
    }

    @GetMapping("/login")
    public String toLoginPage() {
        return "login";
    }
}