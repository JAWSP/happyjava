package com.example.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

@Slf4j
@SpringBootApplication
public class SpringdatajpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	//테스트는 여기에
//	@Bean
//	public CommandLineRunner run(UserRepository repository) {
//		return  args -> {
//			//만들기
//			User u = new User("hong", "w@www");
//			//저러면 영속성 등록도 시켜준다고 한다
//			repository.save(u);
//			log.info("add  " + u);

//			//찾기
//			User user = repository.findById(15L).get();
//			//지우기
//			repository.delete(user);
			//수정하기
//			User user = repository.findById(11L).get();
//			user.setName("John doe");
//			user.setEmail("wwww@wwwww");
//			repository.save(user);

//			repository.findAll().forEach(user ->log.info(user.toString()));
//			repository.findByEmail("w@www").forEach(user -> log.info(user.toString()));
//			repository.selectUser("hong").forEach(user -> log.info(user.toString()));
			//repository.selectUser("hong").forEach(user -> log.info(user.toString()));
			//repository.selectUserLike("hong").forEach(log::info);
//			repository.updateByname(6L, "wwe");
//
//			//repository.deleteByEmail("w@www");
//			repository.selectBYEmailNative("example.com").forEach(user -> log.info(user.toString()));
//			//페이징
//			Pageable pageable = PageRequest.of(0, 1);
//			repository.findByNameContaining("wwe", pageable).forEach(user -> log.info(user.toString()));

//		};
	//}

}
