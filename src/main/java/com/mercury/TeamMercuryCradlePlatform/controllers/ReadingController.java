package com.mercury.TeamMercuryCradlePlatform.controllers;

import com.mercury.TeamMercuryCradlePlatform.Model.Patient;
import com.mercury.TeamMercuryCradlePlatform.Model.Reading;
import com.mercury.TeamMercuryCradlePlatform.Model.ReadingAnalysis;
import com.mercury.TeamMercuryCradlePlatform.Repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.Repository.ReadingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.ZonedDateTime;


@Controller
@RequestMapping("/reading")
public class ReadingController {

    private PatientRepository patientRepository;
    private ReadingRepository readingRepository;

    ReadingController(PatientRepository patientRepository, ReadingRepository readingRepository){
        this.patientRepository = patientRepository;
        this.readingRepository = readingRepository;
    }

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
        //Patient patient = new Patient();
        Patient patient = patientRepository.findByFirstNameAndLastNameAndAgeYears(reading.firstName, reading.lastName, reading.ageYears);

        if(patient != null){
            reading.setPatient(patient);
            readingRepository.save(reading);
        }
        else{
            reading.setPatient(new Patient(reading));
            readingRepository.save(reading);
        }

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
