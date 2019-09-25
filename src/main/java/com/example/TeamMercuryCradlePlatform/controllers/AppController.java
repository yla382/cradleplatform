package com.example.TeamMercuryCradlePlatform.controllers;

import com.example.TeamMercuryCradlePlatform.Model.User;
import com.example.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @GetMapping("/{id}/profile")
    public String getUserInfo(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findByUserId(id);
        model.addAttribute("UserId", user.getUserId());
        model.addAttribute("FirstName", user.getFirstName());
        model.addAttribute("LastName", user.getLastName());
        model.addAttribute("Role", user.getRole());
        return "profile";
    }

}