package com.mercury.TeamMercuryCradlePlatform.controller;

import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.ReadingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    private PatientRepository patientRepository;
    private ReadingRepository readingRepository;

    StatisticsController(PatientRepository patientRepository, ReadingRepository readingRepository){
        this.patientRepository = patientRepository;
        this.readingRepository = readingRepository;
    }

    // Create a new reading
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView readingPage(){
        return new ModelAndView("/statistics/patient").addObject(this.readingRepository.findAll());
    }

}
