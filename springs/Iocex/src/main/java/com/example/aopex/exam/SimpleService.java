package com.example.aopex.exam;

import org.springframework.stereotype.Component;

//등록을 해야 쓸 수 있다
@Component
public class SimpleService {

    //핵심관심(타겟)-우리가 구현할거

    public String doSomething() {
        //target
        System.out.println("나는 타겟임 ㅇㅇ 그리고 뭔갈 하는중");
        return"sth";
    }

    public void err() {
        //테스트를 위하여 일부러 에러를 만든다
        if(1==1) {
            throw new RuntimeException("그냥 해본거임 ㅎㅎ");
        }
    }
    public void hello() {
        System.out.println("hi");


    }
    public void asd() {
        System.out.println("asd");
    }
    public void qwe() {
        System.out.println("qwe");
    }

}
