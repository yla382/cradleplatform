package com.mercury.TeamMercuryCradlePlatform.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/android")
public class AndroidController {

    @Autowired
    private PatientRepository patientRepository;

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

}
