package com.example.TeamMercuryCradlePlatform;

import com.example.TeamMercuryCradlePlatform.Model.User;
import com.example.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserdataInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserdataInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        User admin = new User("1234", "John", "Lee", "ADMIN");
        User vhc = new User("1234", "Yoon", "Lee", "VHC");
        User healthWorker = new User("1234", "Megan", "Fox", "HEALTHWORKER");

        List<User> users = Arrays.asList(admin, vhc, healthWorker);
        userRepository.saveAll(users);
    }
}
