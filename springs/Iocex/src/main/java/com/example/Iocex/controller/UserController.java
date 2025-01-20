package com.example.Iocex.controller;

import com.example.Iocex.domain.User;
import com.example.Iocex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//컴포넌트 자손
@Controller
public class UserController {
    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void joinUser() {
        //실제로 동작할때는 user정보를 사용자로부터 받는다
        //대충 유저에게 받았다는 거
        User user = new User();
        user.setName("asd");
        user.setEmail("email");
        user.setPassword("1q2w3e4r!");

        userService.joinUser(user);
    }
}
