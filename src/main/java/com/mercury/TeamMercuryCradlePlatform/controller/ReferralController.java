package com.mercury.TeamMercuryCradlePlatform.controller;

import com.mercury.TeamMercuryCradlePlatform.model.Referral;
import com.mercury.TeamMercuryCradlePlatform.repository.ReferralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Service
@RequestMapping(path="/referral")
public class ReferralController {
    @Autowired
    private ReferralRepository referralRepository;

    public ReferralController(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    @RequestMapping(value = "/addReferral", method = RequestMethod.GET)
    public ModelAndView addPatientPage(){
        return new ModelAndView("/referral/addReferral");
    }

    @RequestMapping(value = "/confirmReferral", method = RequestMethod.POST)
    public @ResponseBody ModelAndView confirmReferralPage(Referral referral) {
        ModelAndView modelAndView = new ModelAndView("/referral/confirmReferral");

        ReferralRepository referralRepository = this.referralRepository;

        modelAndView.addObject("referral", referral);

        return modelAndView;
    }


}
