package com.example.Iocex;

import com.example.Iocex.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IocexApplication {

	public static void main(String[] args) {

		SpringApplication.run(IocexApplication.class, args);
		//이렇게 실행부에서도 쓸 수 있다
		//run에서도 컴포넌트 스캔을 가지고 있고, 리턴부에 컨테스트 부분이 있음
		//따라서 이렇게 써도 됨
//		ApplicationContext context = SpringApplication.run(IocexApplication.class, args);
//		UserController controller = context.getBean(UserController.class);
	}

}
