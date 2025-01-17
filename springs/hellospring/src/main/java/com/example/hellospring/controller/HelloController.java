package com.example.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

//얠 추가해줌
@RestController
public class HelloController {
    //나 이거 익스프레스에서 봤어요
    @GetMapping("/hello")
    public String hi() {
        File file = new File("giga.webp");
        return "<h1>hey 박삣삐</h1>" +
                "<img src=\"/giga.webp\">";
    }

    @GetMapping("/giga")
    public String chad() {
        return "무슨 PUSSY같은 고민이야?";
    }

    @GetMapping("/")
    public String index() {
        return "<h1>이것</h1>"+
                "<p>인덱스 페이지</p>";
    }
}
