package com.example.securityEx4.controller;

import com.example.securityEx4.domain.User;
import com.example.securityEx4.domain.UserRegisterDTO;
import com.example.securityEx4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/welcome")
    public String welcome() {
        return "ex4/welcome";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "ex4/users/signup";
    }

    @PostMapping("/userreg")
    public String userReg(@ModelAttribute User user) {
        if (userService.existUser(user.getUsername()))
            return "ex4/users/err";
        userService.registUser(user);
        return "redirect:ex4/welcome";
    }

    @GetMapping("/loginform")
    public String showLoginForm() {
        return "ex4/users/loginform";
    }

    @PostMapping("/userreg_role")
    public String userRegRole(@ModelAttribute UserRegisterDTO userRegisterDTO) {
        System.out.println(userRegisterDTO);
        log.info("떴냐@@@@@@@@@@@@@@@22");
        if (userService.existUser(userRegisterDTO.getUsername()))
            return "ex4/users/err";
        userService.registUser(userRegisterDTO);
        return "redirect:ex4/welcome";
    }

    //얘는 시큐리티가 해준다고
//    @PostMapping("/login")
//    public String login()
}
