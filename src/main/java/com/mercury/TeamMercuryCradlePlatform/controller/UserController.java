package com.mercury.TeamMercuryCradlePlatform.controller;
import com.mercury.TeamMercuryCradlePlatform.model.User;
import com.mercury.TeamMercuryCradlePlatform.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/login")
    public User login(@RequestParam("email") String email, @RequestParam("password") String password){

        System.out.println("Email: " + email + "\tPassword: " + password);
        if(email == null || email.isEmpty()){
            throw new IllegalArgumentException();
        }

        if(!userRepository.existsByEmail(email)){
            throw new NoSuchElementException();
        }

        User user = userRepository.findByEmail(email);
        if(bCryptPasswordEncoder.matches(password, user.getPassword())){
            System.out.println("accepted login");
            return user;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public User addNewUser(@RequestBody User newUser) {

        // Check it:
//        if (newUser.getEmail() == null || newUser.getEmail().isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        if (newUser.getFirstName() == null || newUser.getFirstName().isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        if (newUser.getLastName() == null || newUser.getLastName().isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        if (newUser.getPassword() == null || newUser.getPassword().isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//
//        if (newUser.getPhoneNumber() == null || newUser.getPhoneNumber().isEmpty()) {
//            throw new IllegalArgumentException();
//        }

        if (userRepository.existsByEmail(newUser.getEmail())) {
            System.out.println("User already exists error");
            throw new IllegalArgumentException();
        }

        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

        // Add it to repository, returning what is actually created in DB
        System.out.println("adding user:\n" + newUser.toString());
        return userRepository.save(newUser);
    }


    // ---------------------------------------
    //    Retrieve user by email
    // ---------------------------------------
    @GetMapping("/byEmail")
    public User userByEmail(
            @RequestHeader(value = "apiKey", defaultValue = "") String apiKey,
            @RequestParam("email") String email
    ) {

        return null;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public void illegalExceptionHandler(){}


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public void noSuchElementException(){}
}