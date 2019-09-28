package com.mercury.TeamMercuryCradlePlatform.controllers;

import com.mercury.TeamMercuryCradlePlatform.Model.User;
import com.mercury.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {
    @RequestMapping("/")
    public String welcome() {
        return "index";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }



}