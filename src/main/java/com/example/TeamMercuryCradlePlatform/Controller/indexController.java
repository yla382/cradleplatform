package com.example.TeamMercuryCradlePlatform.Controller;

import com.example.TeamMercuryCradlePlatform.Model.User;
import com.example.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class indexController {
    private UserRepository userRepository;

    public indexController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("test")
    public List<User> users() {
        return (List<User>) this.userRepository.findAll();
    }
}
