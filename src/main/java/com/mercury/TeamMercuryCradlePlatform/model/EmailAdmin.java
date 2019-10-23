package com.mercury.TeamMercuryCradlePlatform.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Properties;

@Component
public class EmailAdmin {
    private String emailHost = "smtp.gmail.com";
    private int port = 587;
    private String username = "teammercury9@gmail.com";
    private String password = "cradle0112";


    public void sendEmail(String email, String subject, String text) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        createMailSender(javaMailSender);

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");

        SimpleMailMessage simpleMailMessage = createMailMessage(email, subject, text);
        javaMailSender.send(simpleMailMessage);
    }

    private SimpleMailMessage createMailMessage(String email, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(username);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        return simpleMailMessage;
    }

    private void createMailSender(JavaMailSenderImpl javaMailSender) {
        javaMailSender.setHost(emailHost);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
    }

    public void sendRegistrationEmail(String password, User newUser) {
        String subject = "New Cradle account created";
        String text = "Hello, " + newUser.getFirstName() + " thank you for joining our organization" +
                ". Here is ur account id and password\n" + "ID: " + newUser.getUserId() + "\npassword: " + password;
        sendEmail(newUser.getEmail(), subject, text);
    }

    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
