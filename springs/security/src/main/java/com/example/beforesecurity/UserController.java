package com.example.beforesecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hi")
    public String hello() throws InterruptedException{
        log.info("요청을 받으면 스레드가 나온다고?"+Thread.currentThread().getName());
        Thread.sleep(1000);
        userService.test();
        return "ㅎㅇ"+UserContext.getUSer().getName();
    }

    @GetMapping("/test/hi")
    public String hellooo() throws InterruptedException{
        log.info("얘도 요청을 받으면 스레드가 나온다고?"+Thread.currentThread().getName());
        Thread.sleep(5000);
        return "ㅎㅇ^^7";
    }
}
