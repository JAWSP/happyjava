package com.example.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExController2 {
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "method test");
    }

    @GetMapping("/start")
    public String startProcess(Model model, HttpServletRequest request) {
        System.out.println("start");
        model.addAttribute("forwardTest", "asd");
        System.out.println(request.getAttribute("forwardTest"));
        return "forward:/forward";
    }

    @GetMapping("forward")
    public String forward(Model model, HttpServletRequest request) {
        System.out.println("forward start");
        //모델에선 안나와있지만
        System.out.println("test -> " + model.getAttribute("frowardTest"));
        //요청 객체에는 있다
        System.out.println(request.getAttribute("forwardTest"));
        return "forwardPage";
    }

    @GetMapping("/redirect")
    public String redirect(Model model) {
        System.out.println("redirect");
        model.addAttribute("redirect", "asd");
        return "redirect:/finalDestination";
    }

    @GetMapping("finalDestination")
    public String finalDestination(Model model, HttpServletRequest req) {
        System.out.println("test -> " + model.getAttribute("redirect"));
        System.out.println(req.getAttribute("redirect"));
        return "finalPage";
    }
}
