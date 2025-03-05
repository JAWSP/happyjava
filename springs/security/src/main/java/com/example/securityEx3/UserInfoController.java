package com.example.securityEx3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//뷰를 쓸거라서 그냥 컨트롤러
@Controller
public class UserInfoController {
    @GetMapping("/userinfo")
    public String userInfo() {
        return "user-info";
    }
}
