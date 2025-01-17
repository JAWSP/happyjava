package com.example.Iocex.config;

import com.example.Iocex.controller.UserController;
import com.example.Iocex.domain.User;
import org.springframework.context.annotation.Bean;

//객체를 등록한다 이말이야
public class UserConfig {
    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public UserController userController() {
        return new UserController();
    }
}
