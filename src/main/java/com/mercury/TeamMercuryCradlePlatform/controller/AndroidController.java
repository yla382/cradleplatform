package com.mercury.TeamMercuryCradlePlatform.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import com.mercury.TeamMercuryCradlePlatform.model.Reading;
import com.mercury.TeamMercuryCradlePlatform.model.User;
import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.ReadingRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.Media;
import java.util.List;

@Controller
@RequestMapping("/android")
public class AndroidController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ReadingRepository readingRepository;
    @Autowired
    private UserRepository userRepository;

    public AndroidController(PatientRepository patientRepository, ReadingRepository readingRepository) {
        this.patientRepository = patientRepository;
        this.readingRepository = readingRepository;
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAllPatients() throws JsonProcessingException {
        List<Patient> patients = patientRepository.findAll();

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(patients);
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "reading/findByPatientID/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getReadingsByPatientId(@PathVariable Integer id) {
        Patient patient = patientRepository.findByPatientId(id);
        List<Reading> readings = readingRepository.findReadingsByPatient(patient);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            return mapper.writeValueAsString(readings);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/uploadreading", method = RequestMethod.POST)
    public ResponseEntity<Reading> createReading(@RequestBody Reading reading) {
        System.out.println(reading);
        Patient patient = patientRepository.findByFirstNameAndLastNameAndAgeYears(reading.firstName, reading.lastName, reading.ageYears);

        if(patient != null) {
            reading.setPatient(patient);
            readingRepository.save(reading);
        } else {
            reading.setPatient(new Patient(reading));
            readingRepository.save(reading);
        }

        return new ResponseEntity<>(reading, HttpStatus.OK);
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        File convertFile = new File("/Users/earlcookie/Desktop" + file.getOriginalFilename());
        boolean res = convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
    }
}

