package com.example.TeamMercuryCradlePlatform.controllers;
import com.example.TeamMercuryCradlePlatform.Model.User;
import com.example.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VHTController {

    @GetMapping("/vht/allocation")
    public String migration() {
        return "vht/allocation";
    }

    @GetMapping("/vht/report")
    public String report() {
        return "vht/report";
    }
}
