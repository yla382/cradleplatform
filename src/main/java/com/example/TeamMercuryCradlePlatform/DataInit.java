package com.example.TeamMercuryCradlePlatform;

import com.example.TeamMercuryCradlePlatform.Model.Patient;
import com.example.TeamMercuryCradlePlatform.Model.User;
import com.example.TeamMercuryCradlePlatform.Repository.PatientRepository;
import com.example.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private PatientRepository patientRepository;

    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder, PatientRepository patientRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) {
        User admin = new User("1234", "John", "Lee", "ADMIN");
        User vhc = new User("1234", "Yoon", "Lee", "VHC");
        User healthWorker = new User("1234", "Megan", "Fox", "HEALTHWORKER");

        List<User> users = Arrays.asList(admin, vhc, healthWorker);
        userRepository.saveAll(users);

        Patient A = new Patient("A", "B");
        Patient B = new Patient("C", "D");
        Patient c = new Patient("E", "F");
    }
}
