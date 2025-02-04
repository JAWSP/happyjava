package com.example.springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/session")
@SessionAttributes("visitCount")
public class SessionController {

    @ModelAttribute("visitCount")
    public Integer initVisitCount() {
        System.out.println("init");
        return 0;
    }

    //요청 객체가 아닌 스프링에 접근
    @GetMapping("/visit")
    public String visit(@ModelAttribute("visitCount") Integer visitCount, Model model) {
        visitCount++;
        model.addAttribute("visitCount", visitCount);
        return "sessionvisit";
    }

    //세션을 지우고 싶다면?
    @GetMapping("/resetvisit")
    public String resetVisit(SessionStatus status) {
        //요걸로 초기화가 된다고 한다, @SessionAttributes("visitCount") -> 요걸 통하여 등록한 값만 삭제
        //만약에 저걸 안쓴다면 session.invalidate()를 이용하여 세션 자체를 삭제하거나
        //session.removeAttribute("visitCount")를 이용하여 지운다
        //그러니까 @SessionAttributes("visitCount")를 안썼을때 경우라는거
        status.setComplete();


        return "redirect:/session/visit";
    }

    //요청 객체로 접근
//    public String visit(HttpSession session, Model model) {
//        //HttpSession는 HttpServletRequest의 getSession() 메서드로 얻어올 수 있는데
//        //getSession() 는 세션이 이미 있다면 있는걸 리턴, 없으면 만들어서 리턴
//        //만드는 방식은 세션객체를 생성하고 sessionId를 발급받아서 그걸 쿠키로 만들고
//        //그 쿠키를 response객체에 넣는 것까지 알아서 해줌
//        Integer visitCount = (Integer)session.getAttribute("visitCount");
//        if (visitCount == null)
//            visitCount = 0;
//        visitCount++;
//
//        session.setAttribute("visitCount",visitCount);
//        model.addAttribute("visitCount", visitCount);
//        return "sessionvisit";
//    }
}
