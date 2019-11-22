package com.mercury.TeamMercuryCradlePlatform.controller;
import com.mercury.TeamMercuryCradlePlatform.model.Assessment;
import com.mercury.TeamMercuryCradlePlatform.model.Medication;
import com.mercury.TeamMercuryCradlePlatform.model.Referral;
import com.mercury.TeamMercuryCradlePlatform.repository.AssessmentRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.MedicationRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.ReferralRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/assessment")
public class AssessmentController {
    private final ReferralRepository referralRepository;
    private final AssessmentRepository assessmentRepository;
    private final MedicationRepository medicationRepository;

    public AssessmentController(ReferralRepository referralRepository, AssessmentRepository assessmentRepository, MedicationRepository medicationRepository) {
        this.referralRepository = referralRepository;
        this.assessmentRepository = assessmentRepository;
        this.medicationRepository = medicationRepository;
    }


    @RequestMapping(value = "/addAssessment/{id}" , method = RequestMethod.GET)
    public ModelAndView assessment (@PathVariable Long id) {
        ModelAndView assessmentModel = new ModelAndView("assessment/addAssessment");
        Referral referral = referralRepository.findByReferralId(id);
        assessmentModel.addObject("referral", referral);
        return assessmentModel;
    }

    @RequestMapping(value = "/confirmAssessment", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView confirmAssessmentPage(Assessment assessment) {
        ModelAndView modelAndView = new ModelAndView("assessment/confirmAssessment");
        return modelAndView;
    }

    @RequestMapping(value = "/assessmentSaved", method = RequestMethod.POST)
    public @ResponseBody ModelAndView saveAssessment(Assessment assessment,
                                                     @RequestParam(value = "referralId", defaultValue = "0")  Integer referralId) {
        assessmentRepository.save(assessment);
        List<Referral> referralList = this.referralRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("/referral/referralList");
        modelAndView.addObject("referralList", referralList);
        return modelAndView;
    }
}
