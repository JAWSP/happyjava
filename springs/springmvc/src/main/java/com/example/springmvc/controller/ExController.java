package com.example.springmvc.controller;

import com.example.springmvc.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExController {
    //그거/exam/example ->이렇게 접근됨
    @GetMapping("/example")
    public String showExample(Model model) {
        model.addAttribute("username", "jane doe");
        model.addAttribute("isAdmin", true);
        model.addAttribute("languages", new String[] {"Korean", "English"});
        model.addAttribute("items", new Item("banana", 0.77));
        return "example";
    }
}
