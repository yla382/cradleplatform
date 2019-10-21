package com.mercury.TeamMercuryCradlePlatform;

import com.mercury.TeamMercuryCradlePlatform.model.*;
import com.mercury.TeamMercuryCradlePlatform.repository.*;
import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import com.mercury.TeamMercuryCradlePlatform.model.User;
import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.UserRepository;
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
    private ReadingRepository readingRepository;
    private ReferralRepository referralRepository;

    public DataInit(UserRepository userRepository, PasswordEncoder passwordEncoder, PatientRepository patientRepository, ReadingRepository readingRepository, ReferralRepository referralRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
        this.readingRepository = readingRepository;
        this.referralRepository = referralRepository;
    }

    @Override
    public void run(String... args) {
        User admin = new User(passwordEncoder.encode("1234"), "John", "Lee", "test@test.com", "ADMIN");
        User vht = new User(passwordEncoder.encode("1234"), "Yoon", "Lee", "test2@test.com","VHT,ADMIN,HEALTHWORKER");
        User healthWorker = new User(passwordEncoder.encode("1234"), "Megan","Fox", "test3@test.com", "ADMIN,HEALTHWORKER");

        List<User> users = Arrays.asList(admin, vht, healthWorker);
        userRepository.saveAll(users);

        Patient patient1 = new Patient("Ricky", "Owen","Uganda", "VillageA");
        Patient patient2 = new Patient("Bobby", "Frown", "Uganda", "VillageA");
        Patient patient3 = new Patient("Bob", "Gloss", "Uganda", "VillageB");

        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3));

    }
}
