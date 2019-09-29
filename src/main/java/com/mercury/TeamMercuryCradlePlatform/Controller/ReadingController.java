package com.mercury.TeamMercuryCradlePlatform.Controller;

import com.mercury.TeamMercuryCradlePlatform.Model.Reading;
import com.mercury.TeamMercuryCradlePlatform.Model.ReadingAnalysis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZonedDateTime;

@Controller
public class ReadingController {

    @RequestMapping(value = "/reading", method = RequestMethod.GET)
    public ModelAndView readingPage(){
        return new ModelAndView("/reading");
    }


    @RequestMapping(value = "/submitReading", method = RequestMethod.POST)
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

        ModelAndView modelAndView = new ModelAndView("/addReading");

        modelAndView.addObject("reading", reading);
        modelAndView.addObject("analysis", analysis);
        modelAndView.addObject("trafficLight", getTrafficLightImg(analysis));
        modelAndView.addObject("arrowDirection", getArrowDirection(analysis));

        return modelAndView;

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
