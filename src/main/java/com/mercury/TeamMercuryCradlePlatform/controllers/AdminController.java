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

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAllUsers(){
        return new ModelAndView("/admin/users").addObject("users", this.userRepository.findAll());
    }

    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public ModelAndView getAllUsers(User user, @RequestParam(value = "roles", defaultValue = "") String roles){

        user.setRole(roles);
        this.userRepository.save(user);
        return new ModelAndView("/admin/users").addObject("users", this.userRepository.findAll());

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ModelAndView getUserWithId(@PathVariable int id){

        User user = this.userRepository.findByUserId(id);
        return new ModelAndView("/admin/editUser").addObject("postUser", user);
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.POST)
    public ModelAndView deleteUserWithId(@PathVariable int id){
        this.userRepository.delete(this.userRepository.findByUserId(id));
        return new ModelAndView("/admin/users").addObject("users", this.userRepository.findAll());
    }

}
