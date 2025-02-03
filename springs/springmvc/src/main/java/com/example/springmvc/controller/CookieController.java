package com.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {

    @GetMapping("/visit")
    public String showVisit(
            //여긴 매개변수 영역임
            //쿠키를 어노테이션으로 생성, 이름은 lastVisit, 디폴드벨류는 없다면 디폴트값, String자료형의 lastvisit
            //쿠키는 요청 객체에 저장되어서 저 부분도 같이 넣어진다
            @CookieValue(name = "lastVisit", defaultValue = "empty")String lastVisit,
            HttpServletResponse response, Model model
    ) {
        //쿠키를 생성하고 등록은 서버가 해준다
        //대충 만약 로그인에 관련된 부분이다라고 한다면 로그인 체크를 하고
        //사용자가 맞다면 쿠키를 생성
        //lastVisit라는 이름의 쿠키가 생성, 2번째 value는 쿠키에 저장할 값
        Cookie cookie = new Cookie("lastVisit", "asd");
        //설정 넣기
        //유효한 범위를 넣는다, /는 어플리케이션 전체를 넣는다, /는 생략시 디폴트값
        //cookie.setDomain("/");
        //얜 인증기간, 초단위임, 3년까지 가능하다고
        cookie.setMaxAge(60*60);

        //반드시 응답에 포함시켜야 한다
        //그래야지 이후에도 쓰지
        response.addCookie(cookie);

        //쿠키를 모델에 넣어
            model.addAttribute("lastVisit", lastVisit);
            return "visit";
    }
}
