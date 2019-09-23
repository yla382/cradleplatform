package com.example.TeamMercuryCradlePlatform.Controller;

import com.example.TeamMercuryCradlePlatform.Model.Patient;
import com.example.TeamMercuryCradlePlatform.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
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
    public Iterable<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

    @GetMapping(path="filter/{firstName}")
    public @ResponseBody
    List<Patient> findAllPatientByFirstName(@PathVariable(value="firstName") String firstName){
        return patientRepository.findAllByFirstNameLike(firstName);
    }
}