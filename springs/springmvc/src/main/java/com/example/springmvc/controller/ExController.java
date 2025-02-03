package com.example.springmvc.controller;

import com.example.springmvc.domain.Item;
import com.example.springmvc.domain.RegisterForm;
import com.example.springmvc.domain.User;
import com.example.springmvc.domain.UserForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExController {
    //그거/exam/example ->이렇게 접근됨
    @GetMapping("/example")
    public String showExample(Model model) {
        model.addAttribute("username", "jane doe");
        model.addAttribute("isAdmin", true);
        model.addAttribute("languages", new String[] {"Korean", "English"});
        model.addAttribute("items", new Item("banana", 0.77));
        return "example";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<String> items = Arrays.asList("품목", "품목1", "품목2", "품목3", "품목4", "품목5", "품목6", "품목7", "품목8", "품목9", "품목10");
        model.addAttribute("items", items);
        return "list";
    }

    @GetMapping("/datetime")
    public String datetime(Model model) {
        model.addAttribute("currentDate", LocalDate.now());
        model.addAttribute("currentDateTime", LocalDateTime.now());
        model.addAttribute("currentTime", LocalTime.now());
        model.addAttribute("currentZoneDateTime", ZonedDateTime.now());


        return "datetime";
    }

    //로그인은? 로그인폼이랑 로그인내용 2개를 요청한다
    //폼달라는거
    @GetMapping("/form")
    public String showForm(Model model) {
        //폼을 넘긴다
        model.addAttribute("userForm", new UserForm());
        return "form";
    }

    //로그인 처리
    //첫번째 인자는 @Valid는 그 기준을 확인한다는뜻
    //@ModelAttribute("userForm")는 모델에 저장된 userForm을 가져온다는 뜻
    //@RequestParam과 비스므리한 느낌이라고 생각하면 됨 요청을 자바인자로 받는다고
    //result는 대충결과값이겠지
    //바인딩은 model을 valid로 바인딩하겠다는 거고
    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("userForm")
                                 UserForm userForm, BindingResult result) {
        //통과 아니면 그대로
        if (result.hasErrors()){
            return "form";
        }
        //아니면 됨
        return "result";
    }
    @GetMapping("/registerform")
    public String getUsers(Model model) {
        model.addAttribute("registerform", new RegisterForm());

        return "registerform";
    }

    @PostMapping("/register")
    public String registUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
    if (result.hasErrors())
        return "registerform";
    return "result";
    }

    //해당 컨트롤로 내에 공통적으로 쓰이는 모델
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "ㅎㅇㅎㅇ");
    }
}
