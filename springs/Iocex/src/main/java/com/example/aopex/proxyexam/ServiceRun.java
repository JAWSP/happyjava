package com.example.aopex.proxyexam;

public class ServiceRun {
    public static void main(String[] args) {
        //그리고 이 부분은 Compoment가 해줌
        Service service = new ProxyService();

        service.perform();
    }
}
