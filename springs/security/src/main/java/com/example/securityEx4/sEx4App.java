package com.example.securityEx4;

import com.example.securityEx4.domain.Role;
import com.example.securityEx4.repository.RoleRepository;
import com.example.securityEx4.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class sEx4App {
    public static void main(String[] args) {
        SpringApplication.run(sEx4App.class);
    }

    @Bean
    public CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository) {
        return  args -> {
            if (roleRepository.count() == 0) {
                Role userRole = new Role();
                userRole.setName("USER");

                Role adminRole = new Role();
                adminRole.setName("ADMIN");

                //즉석에서 리스트로 만든다
                roleRepository.saveAll(List.of(userRole, adminRole));
                log.info("대충 초기 권한 생성");
            }
        };
    }
}
