package com.example.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//이번엔 Restful로
@RestController
public class HiController {
    //그냥 컨트롤러면 리턴부에ㅎㅇ라는 뷰를 찾을텐데 없기 때문에 에러가 난다
    //@ResponseBody로 붙여야지 아 쟤가 뷰가 아니라 응답 바디로 리턴하는구나 하고 그렇게 나오게 된다
    //하지만 RestController는
    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        return "ㅎㅇ";
    }
}
