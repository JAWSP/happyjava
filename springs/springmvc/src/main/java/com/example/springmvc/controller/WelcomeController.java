package com.example.springmvc.controller;

import com.example.springmvc.domain.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(Model model) {

        model.addAttribute("welcomeMessage", "ㅎㅇㅎㅇ");
        //즉석으로 만드는 놈이라고, asList는 메소드임 리스트를 생성해줌
        //asList는 Arrays의 기능이라고 한다
        List<Item> items = Arrays.asList(
                new Item("apple", 1.24),
                new Item("banana", 0.77),
                new Item("banana", 0.77)
        );
        model.addAttribute("items", items);

        return "welcome";
    }
}
