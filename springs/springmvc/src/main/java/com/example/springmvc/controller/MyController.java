package com.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    //요런얘가 RestController
    @GetMapping("a")
    @ResponseBody
    public String aa() {
        return "aa";
    }

    //이젠 모델과 뷰를 보내겠다, 이 위는 뷰만 보냈음
    //http://localhost:8080/greeting/name=asd
    //2번째 매개변수는 없으면 false, 3번재는 디폴트값
    @GetMapping("/greeting")
    public ModelAndView greet(@RequestParam(name="name",required =false, defaultValue = "world")String name) {
        //모델명을 결정
        ModelAndView mv = new ModelAndView("greeting.html");
        //모델에 값을 넣기
        mv.addObject("name", name);

        return mv;
    }

    //얜 바로 위와 같음
    @GetMapping("/greeting2")
    public String greet2(@RequestParam(name="name",required =false, defaultValue = "world")String name, Model model) {
        model.addAttribute("name", name);
        return "greeting.html";
    }



}
