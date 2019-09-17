package com.cradleplatform.mercury.CradlePlatform;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/Login")
    public String notready() {
        return "Deployment on the way";
    }
}
