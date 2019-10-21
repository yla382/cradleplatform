package com.mercury.TeamMercuryCradlePlatform.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import com.mercury.TeamMercuryCradlePlatform.model.Reading;
import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.ReadingRepository;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/android")
public class AndroidController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ReadingRepository readingRepository;

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

    @RequestMapping(value = "/uploadreading", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String createReading(@RequestBody Reading reading) {
        readingRepository.save(reading);
        return reading.toString();
    }

    @RequestMapping(value = "/getreading/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getReading(@PathVariable Integer id) throws JsonProcessingException {
        Patient p = patientRepository.findByPatientId(id);
        List<Reading> readings = readingRepository.findReadingsByPatient(p);


        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(readings);
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
            return null;
        }

    }

}
