package com.mercury.TeamMercuryCradlePlatform.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/assessment")
public class AssessmentController {

    @RequestMapping(value = "/addAssessment/{id}" , method = RequestMethod.GET)
    public ModelAndView assessment (@PathVariable Long id) {
        ModelAndView assessmentModel = new ModelAndView("assessment/addAssessment");
        assessmentModel.addObject("id", id);
        return assessmentModel;
    }
}
