package com.mercury.TeamMercuryCradlePlatform.controller;

import com.mercury.TeamMercuryCradlePlatform.model.Reading;
import com.mercury.TeamMercuryCradlePlatform.model.ReadingAnalysis;
import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.ReadingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZonedDateTime;
import java.util.*;


@Controller
@RequestMapping("/statistics")
public class StatisticsController {

    private PatientRepository patientRepository;
    private ReadingRepository readingRepository;

    StatisticsController(PatientRepository patientRepository, ReadingRepository readingRepository){
        this.patientRepository = patientRepository;
        this.readingRepository = readingRepository;
    }


    @RequestMapping(value = "/blood-pressure-graph/{id}", method = RequestMethod.GET)
    public ModelAndView bloodPressureGraph(@PathVariable Long id){
        return new ModelAndView("/statistics/bloodPressureGraph").addObject(this.readingRepository.findReadingsByPatient(patientRepository.findByPatientId(id)));
    }


    @RequestMapping(value = "/status-chart/{id}", method = RequestMethod.GET)
    public ModelAndView trafficLightPieChart(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/statistics/trafficLightPieChart");

        int numbGreen = 0, numbYellow = 0, numbRed = 0;
        List<Reading> readingList = this.readingRepository.findReadingsByPatient(this.patientRepository.findByPatientId(id));
        for(Reading reading : readingList){
            ReadingAnalysis analysis = ReadingAnalysis.analyze(reading);
            if(analysis.isGreen()){
                numbGreen++;
            }
            else if(analysis.isYellow()){
                numbYellow++;
            }
            else{
                numbRed++;
            }
        }

        modelAndView.addObject("data", Arrays.asList(numbGreen, numbYellow, numbRed));

        return modelAndView;
    }





}
