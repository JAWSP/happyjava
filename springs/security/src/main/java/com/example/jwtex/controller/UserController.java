package com.example.jwtex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("loginform")
    public String loginform() {
        return "/ex4/users/loginform";
    }
}
