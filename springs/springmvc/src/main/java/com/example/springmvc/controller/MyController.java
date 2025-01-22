package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//나야 컨트롤러
@Controller
public class MyController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    //https://www.google.com/search?q=qqqqqqqqqqqqqqqq&oq=qqqqqqqqqqqqqqqq&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDM2OTRqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8

}
