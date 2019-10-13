package com.hello.RestApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/Fuckyou")
    public String index() {
        return "Hello";
    }
}
