package com.example.friendapp;

import com.example.friendapp.repository.FriendRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FriendappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendappApplication.class, args);

	}

	//테스트는 이렇게...
//	@Bean
//	public CommandLineRunner run(FriendRepository repository) {
//		return args -> {
//			repository.findAll().forEach(System.out::println);
//		};
//	}

}
