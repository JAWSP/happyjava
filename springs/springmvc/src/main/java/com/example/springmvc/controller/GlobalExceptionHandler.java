package com.example.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//에러 처리 담당
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //에러 핸들러라는 어노테이션을 붙임
    //()안은 어느 범위의 에러를 핸들링 할것인가
    @ExceptionHandler(Exception.class)
    //안의 매개변수는 발생된 에러에 대한 클래스
    public ModelAndView handleException(Exception e, Model model) {
        System.out.println("와~ 에러다~");
        model.addAttribute("errorMessage", e.getMessage());

        //그리고 리턴, ()안으 부분은 보여줄 뷰
        return new ModelAndView("error");
    }
}
