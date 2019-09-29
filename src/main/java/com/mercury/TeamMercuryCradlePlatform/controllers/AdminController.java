package com.mercury.TeamMercuryCradlePlatform.controllers;

import com.mercury.TeamMercuryCradlePlatform.Model.EmailAdmin;
import com.mercury.TeamMercuryCradlePlatform.Model.User;
import com.mercury.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/admin")
@SessionAttributes("user")
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    private EmailAdmin emailAdmin;

    public AdminController(UserRepository userRepository, EmailAdmin emailAdmin) {
        this.userRepository = userRepository;
        this.emailAdmin = emailAdmin;
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
    public @ResponseBody ModelAndView submitRegistration(User user, @RequestParam String password, @RequestParam String roles) {
        User temp = new User(user);
        temp.setRole(roles);
        userRepository.save(temp);

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(this.emailAdmin.getEmailHost());
        javaMailSender.setPort(this.emailAdmin.getPort());
        javaMailSender.setUsername(this.emailAdmin.getUsername());
        javaMailSender.setPassword(this.emailAdmin.getPassword());

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");

        SimpleMailMessage  simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(this.emailAdmin.getUsername());
        simpleMailMessage.setTo(temp.getEmail());
        simpleMailMessage.setSubject("New Cradle account created");
        simpleMailMessage.setText("Hello, " + temp.getFirstName() + " thank you for joining our organization" +
                ". Here is ur account id and password\n" + "ID: " + temp.getUserId() + "\npassword: " + password);

        javaMailSender.send(simpleMailMessage);
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
