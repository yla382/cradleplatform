package com.mercury.TeamMercuryCradlePlatform;

import com.mercury.TeamMercuryCradlePlatform.Model.Patient;
import com.mercury.TeamMercuryCradlePlatform.Model.Reading;
import com.mercury.TeamMercuryCradlePlatform.Model.User;
import com.mercury.TeamMercuryCradlePlatform.Repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.Repository.ReadingRepository;
import com.mercury.TeamMercuryCradlePlatform.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class DataInit implements CommandLineRunner {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private PatientRepository patientRepository;
    private ReadingRepository readingRepository;

    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder, PatientRepository patientRepository, ReadingRepository readingRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
        this.readingRepository = readingRepository;
    }

    @Override
    public void run(String... args) {
        User admin = new User("1234", "John", "Lee", "test@test.com", "ADMIN");
        User vhc = new User("1234", "Yoon", "Lee", "test2@test.com","VHT,ADMIN,HEALTHWORKER");
        User healthWorker = new User("1234", "Megan","Fox", "test3@test.com", "ADMIN,HEALTHWORKER");

        List<User> users = Arrays.asList(admin, vhc, healthWorker);
        userRepository.saveAll(users);

        Patient patient1 = new Patient("A", "B", 20);
        Patient patient2 = new Patient("C", "D", 21);
        Patient patient3 = new Patient("E", "F", 22);

        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3));

    }
}
