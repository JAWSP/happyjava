package com.example.springmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieController {

    @GetMapping("/cookiesetform")
    public String cookieSetForm() {
        //해당 요청이 오면 쿠키 이름과 쿠키 값을 받는 화면을 만든다
        return "cookiesetform";
    }

    @GetMapping("/cookieset")
    //나중에는 엔티티를 쓰긴 한데 편의상 이렇게
    public String cookieSet(@RequestParam(name = "cookieName")String cookieName,
                            @RequestParam(name= "cookieValue")String cookieValue,
                            HttpServletResponse response) {
        //쿠키 객체 생성, 얜 디폴트 생성자가 없다
        Cookie cookie = new Cookie(cookieName, cookieValue);
        //경로, 수명 설정
        cookie.setPath("/");
        //초단위임
        cookie.setMaxAge(7 * 24 * 60 * 60);

        //응답에 쿠키 추가
        response.addCookie(cookie);

        //쿠키뷰로 리다이렉트
        return "redirect:/cookieview";
    }

    @GetMapping("/cookieview")
    public String cookieView(HttpServletRequest request, Model model) {
        //쿠키는 요청헤더에 있습니다
        Cookie[] cookies = request.getCookies();
        List<String> cookieList = new ArrayList<>();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                //값을 꺼내서
                String tmp = cookie.getName() + "=" + cookie.getValue();
                System.out.println(tmp);
                //배열에 넣어준다, 쿠키를 통째로 넣어준다면 타임리프가 인식을 못함
                cookieList.add(tmp);
            }
            model.addAttribute("cookies", cookieList);
        }
        //그리고 그 쿠키를 모델에 넣음
        return "cookieview";
    }

    //쿠키 삭제
    //그리고 직접 삭제가 안됨
    //하지만 쿠키는 같은게 2개 있을 수 밖에 없음
    //그걸 응용해서 쿠키를 재생성하고 지속시간을 0으로 하면 그게 삭제가 됨
    @GetMapping("/cookiedelete")
    public String cookieDelete(@RequestParam(name = "cookieName") String cookieName,
                               HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, "a");

        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "redirect:/cookieview";
    }

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
