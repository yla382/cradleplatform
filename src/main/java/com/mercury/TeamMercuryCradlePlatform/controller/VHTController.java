package com.mercury.TeamMercuryCradlePlatform.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VHTController {

    @GetMapping("/vht/allocation")
    public String migration() {
        return "vht/allocation";
    }

    @GetMapping("/vht/report")
    public String report() {
        return "vht/report";
    }

    @GetMapping("/vht/genreport")
    public String genreport() {
        return "vht/genreport";
    }
}
