package com.example.securityEx3;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SecurityController {
    private final HelloService helloService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    //유저의 정보를 가져온다
    //유저의 정보는 이전 시큐리티 필터에서 정의된 스레드 로컬 객체에서 가져올 수 있음
    @GetMapping("/info")
    public String info() {
        String message = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated()){
            message="로그인된 사용자가 없습니다.";
        }
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            message = "현재 로그인 한 사용자 : "+ userDetails.getUsername();
        }else {
            message = "현재 로그인 한 auth한 사용자 : "+principal.toString();
        }
        return message;
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm page";
    }
    @GetMapping("/admin/asd")
    public String adminAsd() {
        return "admin yea";
    }

    @GetMapping("/shop")
    public String shop() {
        return "shshshshshshshsh";
    }

    @GetMapping("user")
    public String user(@AuthenticationPrincipal UserDetails userDetails) {
        return "userrrr" + userDetails.getUsername();
    }

    @GetMapping("/aaa")
    public String aaa() {
        //HelloService의 userLog()를 호출하면  현재로그인한 사용자의 이름을 log.info로 출력
        String msg = helloService.userLog();

        return msg;
    }

//    @GetMapping("/success")
//    public String success(){
//        return "success";
//    }
//    @GetMapping("/fail")
//    public String fail(){
//        return "fail";
//    }
}
