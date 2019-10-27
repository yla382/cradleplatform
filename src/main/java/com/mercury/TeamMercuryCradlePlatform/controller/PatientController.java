package com.mercury.TeamMercuryCradlePlatform.controller;

import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import com.mercury.TeamMercuryCradlePlatform.model.SupervisorPatientPair;
import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    private SupervisorRepository supervisorRepository;

    public PatientController(PatientRepository patientRepository, SupervisorRepository supervisorRepository) {
        this.patientRepository = patientRepository;
        this.supervisorRepository = supervisorRepository;
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

        PatientRepository patientRepository = this.patientRepository;
//        patientRepository.save(patient);

        modelAndView.addObject("patient", patient);

        return modelAndView;
    }

    @RequestMapping(value = "/submitPatient", method = RequestMethod.POST)
    public @ResponseBody ModelAndView submitPatient(Patient patient) {
        ModelAndView modelAndView = new ModelAndView("/patient/patientlist");
        System.out.println(patient.getFirstName());
        patientRepository.save(patient);

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        SupervisorPatientPair supervisorPatientPair = new SupervisorPatientPair(username, patient.getPatientId().toString());
        supervisorRepository.save(supervisorPatientPair);

        List<Patient> patientlist = this.patientRepository.findAll();
        modelAndView.addObject("patientList", patientlist);
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
