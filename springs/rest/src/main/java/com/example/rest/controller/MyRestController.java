package com.example.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//이걸 붙이면 너도 responseBody가 붙은 형태로 나오게 된다
//뷰 대신 데이터가 리턴이 되어진다고
//데이터가 리턴되니 각종 자바객체들이 들어올 수 있다
@RestController
public class MyRestController {
    @GetMapping(value = "/api/greeting", produces = "application/xml")
    //여기 인자는 name="message", required = true, defaultValue = "ㅎㅇㅎㅇ"
    //message로 받은놈은 반드시 있어야 하며 없다면 ㅎㅇㅎㅇ로 대신한다
    public Map<String, String>greet(@RequestParam(name="message", required = true, defaultValue = "ㅎㅇㅎㅇ")String name) {
        Map<String, String> res = new HashMap<>();
        res.put(name, "222");
        res.put("message", "asd");
        res.put("key", "@2");

        return res;
    }
}
