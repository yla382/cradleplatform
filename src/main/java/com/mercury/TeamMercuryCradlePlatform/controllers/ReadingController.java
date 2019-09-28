package com.mercury.TeamMercuryCradlePlatform.controllers;

import com.mercury.TeamMercuryCradlePlatform.Model.Reading;
import com.mercury.TeamMercuryCradlePlatform.Model.ReadingAnalysis;
import com.mercury.TeamMercuryCradlePlatform.Repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.Repository.ReadingRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalField;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/reading")
public class ReadingController {

    private PatientRepository patientRepository;
    private ReadingRepository readingRepository;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView readingPage(){
        return new ModelAndView("/reading/create");
    }


    @RequestMapping(value = "/analysis", method = RequestMethod.POST)
    public @ResponseBody ModelAndView readingAnalysisPage(
            Reading reading,
            @RequestParam(value = "otherSymptoms", defaultValue = "") String otherSymptoms) {

        reading.dateTimeTaken = ZonedDateTime.now();

        if(reading.symptoms.size() == 0){
            reading.symptoms.add("No Symptoms (patient healthy)");
        }
        else{
            if(!otherSymptoms.isEmpty()){
                reading.symptoms.add(otherSymptoms);
            }
        }

        ReadingAnalysis analysis = ReadingAnalysis.analyze(reading);

        ModelAndView modelAndView = new ModelAndView("/reading/analysis");

        modelAndView.addObject("reading", reading);
        modelAndView.addObject("analysis", analysis);
        modelAndView.addObject("trafficLight", getTrafficLightImg(analysis));
        modelAndView.addObject("arrowDirection", getArrowDirection(analysis));

        return modelAndView;

    }

    @RequestMapping(value = "/analysis/save", method = RequestMethod.POST)
    public String readingAnalysisPage(Reading reading) {

        reading.dateTimeTaken = ZonedDateTime.now();
        System.out.println("reading: " + reading.dateTimeTaken);
        return "test";

    }


    private String getTrafficLightImg(ReadingAnalysis readingAnalysis){

        if(readingAnalysis.isGreen()){
            return "status_green";
        }
        else if(readingAnalysis.isYellow()){
            return "status_yellow";
        }
        else if(readingAnalysis.isRed()){
            return "status_red";
        }

        return null;
    }

    private String getArrowDirection(ReadingAnalysis readingAnalysis){

        if(readingAnalysis.isUp()){
            return "arrow_up";
        }
        if(readingAnalysis.isDown()){
            return "arrow_down";
        }

        return null;
    }

}
