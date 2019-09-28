package com.mercury.TeamMercuryCradlePlatform.controllers;

import com.mercury.TeamMercuryCradlePlatform.Model.Patient;
import com.mercury.TeamMercuryCradlePlatform.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Service
@RequestMapping(path="/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewPatient (@RequestParam String firstName,
                          @RequestParam String lastName) {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patientRepository.save(patient);
        return "Patient Added";
    }

    @RequestMapping("/all")
    public String getAllPatients() {

        //return patientRepository.findAll();
        return "PatientTable";
    }

    @GetMapping(path="filter/{firstName}")
    public @ResponseBody
    List<Patient> findAllPatientByFirstName(@PathVariable(value="firstName") String firstName){
        return patientRepository.findAllByFirstNameLike(firstName);
    }
}