package com.mercury.TeamMercuryCradlePlatform.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")               //Role = ADMIN, HEALTH WORKER, VHT
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    public User() {

    }

    public User(User user) {
        this.userId = user.userId;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.roles = user.roles;
        this.email = user.email;
        this.phoneNumber = user.phoneNumber;
    }

    public User(String password, String firstName, String lastName, String email, String roles, String phoneNumber) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "email")
    //@NotEmpty(message = "Email must be provided")
    private String email = null;

    @Column(name = "phone_number")
    private String phoneNumber = null;


    @Column(name = "password")
    //@Length(min = 6, message = "Password must be at least 6 characters")
    //@NotEmpty(message = "Password must be provided")
    private String password = null;

    @Column(name = "first_Name")
    //@NotEmpty(message = "First name must be provided")
    private String firstName = null;

    @Column(name = "last_Name")
    //@NotEmpty(message = "Last name must be provided")
    private String lastName = null;

    @Column(name = "roles")
    private String roles = null;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEncodedPassword(String password) {
        this.password = encodePassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getRole() {
        return roles;
    }

    public void setRole(String roles) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        } else {
            return new ArrayList<>();
        }
    }

    private String encodePassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean isVHT(){
        return getRoles().stream().anyMatch(str -> str.trim().equals("VHT"));
    }

    public boolean isHealthWorker(){
        return getRoles().stream().anyMatch(str -> str.trim().equals("HEALTHWORKER"));
    }

    public boolean isAdmin(){
        return getRoles().stream().anyMatch(str -> str.trim().equals("ADMIN"));
    }

    @Override
    public String toString(){
        return "Name: " + firstName + " " +  lastName + "\nEmail: " + email + "\nRoles:" + roles;
    }

}
