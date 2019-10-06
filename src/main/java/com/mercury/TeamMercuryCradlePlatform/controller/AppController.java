package com.mercury.TeamMercuryCradlePlatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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