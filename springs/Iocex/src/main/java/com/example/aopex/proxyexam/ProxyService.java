package com.example.aopex.proxyexam;

//프록시내부는 대충 이렇게 되어 있을것
public class ProxyService implements Service{
    private RealService realService;

    @Override
    public void perform() {
        if(realService == null)
            realService = new RealService();

        System.out.println("프록시에서 추가로 실행");

        realService.perform();

        //여기서 aop로 구현한 놈들이 실행이 된다
        System.out.println("aop가 구현한 코드라던지.. 추가로 수행해야 하는 작업을 수행하는 코드");
    }
}
