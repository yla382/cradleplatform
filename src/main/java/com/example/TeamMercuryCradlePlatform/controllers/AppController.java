package com.example.TeamMercuryCradlePlatform.controllers;

import com.example.TeamMercuryCradlePlatform.Model.User;
import com.example.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {
    private UserRepository userRepository;

    public AppController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/admin/index")
    public List<User> users() {
        return (List<User>) this.userRepository.findAll();
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }
}