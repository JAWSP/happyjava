package com.example.springdatajpa.springdatajpa;

import com.example.springdatajpa.springdatajpa.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    //얘는 @slf4j없으면 이렇게 ㅓㅈㅇ의해야 한다
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    //implements로 했을 경우에는 Bean이 아닌 Autowired로 주입한다
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        //userRepository.findAll().forEach(user->log.info(user.getName()));
        userRepository.findUserByName("asd").forEach(user -> log.info(user.getName()));
        userRepository.findUsersDynamically(null, null).forEach(user -> log.info(user.getEmail()));
    }
}
