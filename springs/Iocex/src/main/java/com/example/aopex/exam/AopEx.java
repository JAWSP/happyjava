package com.example.aopex.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//테스트는 이렇게
@SpringBootApplication
public class AopEx implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(AopEx.class);
    }

    @Autowired //이렇게 외부에서 주입이 가능, CommandLineRunner필요
    private SimpleService simpleService;
    @Override // CommandLineRunner필요
    public void run(String... args) throws Exception {
        System.out.println("테스트시작");

        System.out.println(simpleService.doSomething());
        simpleService.hello();
        simpleService.asd();
        try {
            simpleService.err();
        }catch (Exception e) {
            System.out.println("catch");
        }

    }
}
