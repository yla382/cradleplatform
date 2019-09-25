package com.example.TeamMercuryCradlePlatform.controllers;

import com.example.TeamMercuryCradlePlatform.Model.User;
import com.example.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    public List<User> users() {
        return (List<User>) this.userRepository.findAll();
    }

    @GetMapping("/registration")
    public String register(){
        return "admin/registration";
    }

    @GetMapping("/{id}/profile")
    public String getUserInfo(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findByUserId(id);
        model.addAttribute("UserId", id);
        model.addAttribute("FirstName", user.getFirstName());
        model.addAttribute("LastName", user.getLastName());
        model.addAttribute("Role", user.getRole());
        return "profile";
    }
}
