//package com.example.securityEx4.controller;
//
//import com.example.securityEx4.domain.User;
//import com.example.securityEx4.domain.UserRegisterDTO;
//import com.example.securityEx4.service.exUserServiced;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@Slf4j
//@RequiredArgsConstructor
//@RequestMapping("/user")
//public class exUserController {
//    private final exUserServiced userService;
//
//    //폼전달
//    @GetMapping("/signup")
//    public String signup() {
//        return "ex4.users/signup";
//    }
//
//    //등록
//    @PostMapping("/userreg")
//    public String userreg(@ModelAttribute User user) {
//        if (userService.existUSer(user.getUsername())) {
//            log.info("이미있는뎁쇼");
//            return "ex4.users/err";
//        }
//        userService.registUser(user);
//        return "redirect:ex4/welcome";
//    }
//
//    @GetMapping("/login")
//    public String logninForm() {
//        return "ex4.users/loginform";
//    }
//
//    //얘는 시큐리티가 대신 해준다
////    @PostMapping("/login")
////    public String loginPostHandler() {
////        log.info("떳냐@@@@@@@@@@@@@@@@@@@@@@@@@@2");
////        return "ex4/welcome";
////    }
//
//
//    @PostMapping("/userreg_role")
//    public String userRegRole(@ModelAttribute UserRegisterDTO userRegisterDTO) {
//        if (userService.existUSer(userRegisterDTO.getUsername()))
//            return "ex4.users/err";
//        userService.registUser(userRegisterDTO);
//
//        return "redirect:/ex4.users/loginform";
//    }
//
//    @GetMapping("/welcome")
//    public String welcome() {
//        return "ex4/welcome";
//    }
//}
