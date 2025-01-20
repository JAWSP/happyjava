package com.example.Iocex;

import com.example.Iocex.config.UserConfig;
import com.example.Iocex.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);

        UserController controller = context.getBean(UserController.class);

        controller.joinUser();
    }
}
