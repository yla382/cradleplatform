package com.example.TeamMercuryCradlePlatform.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "user")               //Role = ADMIN, HEALTH WORKER, VHC
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    protected User() {

    }

    public User(User user) {
        this.userId = user.userId;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.roles = user.roles;
    }

    public User(String password, String firstName, String lastName, String roles) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    //@Column(name = "email")
    //@NotEmpty(message = "Email must be provided")
    //private String email = null;

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

//    public String getEmail() {
//        return email;
//    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return roles;
    }

    public void setRole(String role) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        } else {
            return new ArrayList<>();
        }
    }
}

