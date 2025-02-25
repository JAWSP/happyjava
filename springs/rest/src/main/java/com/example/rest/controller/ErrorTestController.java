package com.example.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ErrorTestController {
    @GetMapping("/api/e")
    public String test() {
        throw new RuntimeException("그냥 에러 내봄");
    }

    @GetMapping("/api/n")
    public  String test2(@RequestParam(name = "id", required = false)Long id) {
        if (id == null) {
            throw new RuntimeException("id없");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "암튼 에러임");
    }
}

