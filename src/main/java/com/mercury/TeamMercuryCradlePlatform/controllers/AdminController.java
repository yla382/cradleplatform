package com.mercury.TeamMercuryCradlePlatform.controllers;

import com.mercury.TeamMercuryCradlePlatform.Model.User;
import com.mercury.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public @ResponseBody ModelAndView submitRegistration(User user, @RequestParam String roles) {
        User temp = new User(user);
        temp.setRole(roles);
        userRepository.save(temp);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", user);
        return modelAndView;
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

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAllUsers(){

        ModelAndView modelAndView = new ModelAndView("/admin/users");
        modelAndView.addObject("users", this.userRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView getAllUsers(User user, @RequestParam(value = "roles", defaultValue = "") String roles){

        user.setRole(roles);
        this.userRepository.save(user);
        ModelAndView modelAndView = new ModelAndView("/admin/users");
        modelAndView.addObject("users", this.userRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ModelAndView getUserWithId(@PathVariable int id){

        ModelAndView modelAndView = new ModelAndView("/admin/editUser");

        User user = this.userRepository.findByUserId(id);
        modelAndView.addObject("postUser", user);
        return modelAndView;
    }

}
