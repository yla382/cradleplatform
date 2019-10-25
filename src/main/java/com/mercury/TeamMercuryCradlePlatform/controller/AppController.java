package com.mercury.TeamMercuryCradlePlatform.controller;

import com.mercury.TeamMercuryCradlePlatform.model.User;
import com.mercury.TeamMercuryCradlePlatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @PreAuthorize("#id == authentication.getPrincipal().getUserId()")
    @GetMapping("/profile/{id}")
    public String getUserInfo(@PathVariable("id") Integer id, Model model) {

        User user = userRepository.findByUserId(id);
        model.addAttribute("UserId", id);
        model.addAttribute("FirstName", user.getFirstName());
        model.addAttribute("LastName", user.getLastName());
        model.addAttribute("Role", user.getRole());
        return "profile";
    }
}
