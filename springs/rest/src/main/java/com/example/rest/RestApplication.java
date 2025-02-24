package com.example.rest;

import com.example.rest.domain.ExUser;
import com.example.rest.repository.ExUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class RestApplication {


	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ExUserRepository exUserRepository) {
		return args ->{
//			ExUser user = new ExUser();
//			user.setName("sad");
//			user.setEmail("2222@@2");
//			exUserRepository.save(user);
		};
	}
}
