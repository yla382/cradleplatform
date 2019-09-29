package com.mercury.TeamMercuryCradlePlatform.controller;

import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Service
@RequestMapping(path="/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @RequestMapping(value = "/patientlist", method = RequestMethod.GET)
    public ModelAndView patientlistPage() {
        List<Patient> patientlist = this.patientRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("/patient/patientlist");
        modelAndView.addObject("patientList", patientlist);
        return modelAndView;
    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.GET)
    public ModelAndView addPatientPage(){
        return new ModelAndView("/patient/addPatient");
    }


    @RequestMapping(value = "/confirmPatient", method = RequestMethod.POST)
    public @ResponseBody ModelAndView confirmPatientPage(Patient patient) {

        ModelAndView modelAndView = new ModelAndView("/patient/confirmPatient");
        modelAndView.addObject("patient", patient);
        return modelAndView;

    }

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewPatient (@RequestParam String firstName,
                          @RequestParam String lastName) {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patientRepository.save(patient);
        return "patient/patientlist";
    }

    // TODO: delete after, dont need two patient list/table pages
    @RequestMapping("/all")
    public String getAllPatients() {

        //return patientRepository.findAll();
        return "PatientTable";
    }

    @GetMapping(path="/filter")
    public @ResponseBody
    List<Patient> findAllPatientByFirstName(@RequestParam String firstName){
        return patientRepository.findAllByFirstNameLike(firstName);
    }

    @GetMapping(path="filter/{lastName}")
    public @ResponseBody
    List<Patient> findAllPatientByLastName(@PathVariable(value="lastName") String lastName){
        return patientRepository.findAllByLastNameLike(lastName);
    }
}