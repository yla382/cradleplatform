package com.example.TeamMercuryCradlePlatform.controllers;

import com.example.TeamMercuryCradlePlatform.Model.User;
import com.example.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
@SessionAttributes("user")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    public List<User> users() {
        return (List<User>) this.userRepository.findAll();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public @ResponseBody ModelAndView registrationPage() {
        return new ModelAndView("admin/registration");
    }

    @RequestMapping(value = "/submitRegistration", method = RequestMethod.POST)
    public @ResponseBody ModelAndView submitRegistration(@RequestParam String firstName, @RequestParam String lastName,
                                                         @RequestParam String password, @RequestParam String roles) {
        User user = new User(bCryptPasswordEncoder.encode(password), firstName, lastName, roles);
        userRepository.save(user);
        System.out.println(user.getFirstName());
        ModelAndView modelAndView = new ModelAndView("admin/registration");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
