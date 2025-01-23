package com.example.springmvc.controller;

import com.example.springmvc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@RequestMapping("ad")
@Controller
public class AdminController {
    @GetMapping("admin")
    public String admin(Model model) {
        List<User> users = Arrays.asList(
                new User("John Doe", true),
                new User("Jane Doe", true),
                new User("Trump", true),
                new User("asd", false)
        );
        model.addAttribute("users", users);
        return "admin";
    }
}
