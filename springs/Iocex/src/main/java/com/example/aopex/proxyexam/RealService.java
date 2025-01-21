package com.example.aopex.proxyexam;

public class RealService implements Service{
    @Override
    public void perform() {
        System.out.println("대충 perform 메소드 구현");
    }
}
