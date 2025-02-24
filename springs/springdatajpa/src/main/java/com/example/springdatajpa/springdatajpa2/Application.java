package com.example.springdatajpa.springdatajpa2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(EmployeeRepository employeeRepository) {
        return args -> {
            employeeRepository.findBySalaryGreaterThanEqual(100D).forEach(employee -> log.info(employee.getFirstName()));
//            employeeRepository.findByLastName("khoo").forEach(employee -> log.info(employee.getJob().getJobTitle()));

//            Employee test = employeeRepository.findById(100L).get();
//            log.info(test.getFirstName());
        };
    }
}
