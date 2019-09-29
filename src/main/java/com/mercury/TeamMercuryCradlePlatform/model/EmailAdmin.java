package com.mercury.TeamMercuryCradlePlatform.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailAdmin {
    @Value("${spring.mail.host}") //Retrieved from application.properties
    private String emailHost;

    @Value("${spring.mail.port}") //Retrieved from application.properties
    private int port;

    @Value("${spring.mail.username}") //Retrieved from application.properties
    private String username;

    @Value("${spring.mail.password}") //Retrieved from application.properties
    private String password;

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
