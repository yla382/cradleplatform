package com.example.TeamMercuryCradlePlatform.controllers;

import com.example.TeamMercuryCradlePlatform.Model.Reading;
import com.example.TeamMercuryCradlePlatform.Model.ReadingAnalysis;
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
public class ReadingController {

    @RequestMapping(value = "/reading", method = RequestMethod.GET)
    public ModelAndView readingPage(){
        return new ModelAndView("/reading");
    }


    @RequestMapping(value = "/submitReading", method = RequestMethod.POST)
    public @ResponseBody ModelAndView readingAnalysisPage(Reading reading) {

        reading.dateTimeTaken = ZonedDateTime.now();
        System.out.println("reading" + reading.toString());
        ModelAndView modelAndView = new ModelAndView("/addReading");
        modelAndView.addAllObjects(createReadingModelMap(reading));
        return modelAndView;
    }

//    @RequestMapping(value = "/submitReading", method = RequestMethod.POST)
//    public ModelAndView submitReading(@RequestParam(value = "patientId")String patientId,
//                                      @RequestParam(value = "patientName") String patientName,
//                                      @RequestParam(value = "ageYears") Integer ageYears,
//                                      @RequestParam(value = "symptoms") List<String> symptoms,
//                                      @RequestParam(value = "otherSymptoms") String otherSymptoms,
//                                      @RequestParam(value = "gestationalAgeUnit") String gestationalAgeUnit,
//                                      @RequestParam(value = "gestationalAgeValue", defaultValue = "0") String gestationalAgeValue,
//                                      @RequestParam(value = "bpSystolic") Integer bpSystolic,
//                                      @RequestParam(value = "bpDiastolic") Integer bpDiastolic,
//                                      @RequestParam(value = "heartRateBPM") Integer heartRateBPM)
//    {
//
//        Reading reading = Reading.makeNewReading(ZonedDateTime.now());
//        reading.patientId = patientId;
//        reading.patientName = patientName;
//        reading.ageYears = ageYears;
//
//        if (!otherSymptoms.isEmpty()){
//            symptoms.add(otherSymptoms);
//        }
//        reading.symptoms = symptoms;
//
//        if(gestationalAgeUnit.compareTo("Weeks") == 0){
//            reading.gestationalAgeUnit = Reading.GestationalAgeUnit.GESTATIONAL_AGE_UNITS_WEEKS;
//        }
//        else if(gestationalAgeUnit.compareTo("Months") == 0){
//            reading.gestationalAgeUnit = Reading.GestationalAgeUnit.GESTATIONAL_AGE_UNITS_MONTHS;
//        }
//        else {
//            reading.gestationalAgeUnit = Reading.GestationalAgeUnit.GESTATIONAL_AGE_UNITS_NONE;
//        }
//        reading.gestationalAgeValue = gestationalAgeValue;
//
//        reading.bpSystolic =  bpSystolic;
//        reading.bpDiastolic = bpDiastolic;
//        reading.heartRateBPM = heartRateBPM;
//
//        return setUpAddReadingModel(reading);
//    }
//
//    private ModelAndView setUpAddReadingModel(Reading reading){
//
//        ModelAndView model = new ModelAndView("/addReading");
//        model.addAllObjects(createReadingModelMap(reading));
//        return model;
//    }

    private Map<String, String> createReadingModelMap(Reading reading){
        ReadingAnalysis readingAnalysis = ReadingAnalysis.analyze(reading);
        Map<String, String> modelMap = new HashMap<>();

        modelMap.put("personalInfo", reading.patientName + ", " + reading.ageYears + "y" + " @ " + reading.getGestationWeekDaysString());
        modelMap.put("patientId", reading.patientId);
        modelMap.put("symptoms", reading.getSymptomsString());
        modelMap.put("timeTaken", reading.getGestationTimeInAmPm());
        modelMap.put("analysis", readingAnalysis.getAnalysisText());
        modelMap.put("bp", reading.bpSystolic + "/" + reading.bpDiastolic);
        modelMap.put("hr", reading.heartRateBPM + "");
        modelMap.put("briefText", readingAnalysis.getBriefText());
        modelMap.put("referralRecommended", readingAnalysis.isReferralToHealthCentreRecommended()? "true":"false");
        modelMap.put("isFollowUp", reading.isFlaggedForFollowup()? "true":"false");
        modelMap.put("trafficLight", getTrafficLightImg(readingAnalysis));
        modelMap.put("arrowDirection", getArrowDirection(readingAnalysis));

        System.out.println("arrowDirection: " + getArrowDirection(readingAnalysis) + " light: " + getTrafficLightImg(readingAnalysis));

        return modelMap;
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
