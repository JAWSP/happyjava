package com.example.rest.controller;

import com.example.rest.domain.ExUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleController {

    @GetMapping("example")
    public ResponseEntity<String> getExample() {
        return ResponseEntity.status(HttpStatus.OK).header("Custom-Header", "asd").body("ㅎㅇㅎㅇ");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ExUser> getUserById(@PathVariable("id")Long id) {

//        if (user == null)
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        else
//            return ResponseEntity.ok(user);
        return null;
    }
}
