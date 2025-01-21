package com.example.aopex.exam;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//Aspect는 횡단관심과 결합규칙이 같이 있는거(advice + pointcut)
//그리고 이 부분은 어노테이션을 추가해준다(모듈 필요)
@Aspect
@Component //또한 스프링에서 사용될 객체이니 넣어줌
public class SimpleAspect {

    @Pointcut("execution(* hello())")
    public void pchi() {}

    //advice가 실행될 시점
    //()안은 포인트컷
    //Before는 어드바이스가 언제 실행될꺼냐
    @Before("execution(* com.example.aopex.exam.SimpleService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before advice " + joinPoint.getSignature().getName());
    }
    //근데 저거 쓰기 귀찮잖아
    @Pointcut(("execution(* com.example.aopex.exam.SimpleService.*(..))"))
    public void pc() {}

    //만약 특정 부분에만 쓰고 싶다면 이렇게까지 줄일 수 있음
    @Pointcut("execution(* asd(..))")
    public void pca() {}

    //얘는 지정된 메소드 실행 후
    @After("pca()")
    public void after() {
        System.out.println("after advice");
    }
    //포인트컷과 리턴값을 지정이 가능
    //요 시점은 리턴부, After보다 이전 Before보다 이후
    @AfterReturning(pointcut = "pc()",returning = "result")
    //인자1은 함수의 정보를 담은 객체, 인자2는 리턴값으로 받은 객체
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("AFTER " + joinPoint.getSignature().getName()+ " return value + " + result);
    }

    @AfterThrowing(value = "pc()", throwing = "ex")
    public void aferThrowing(Throwable ex) {
        System.out.println("에러처리맨");
    }

    //메서드가 실행하기 전중후
    //before보다 전에 실행되고, after보다 후에 실행이 끝남
    @Around("pc()")
    public String around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("AROUND : 메소드가 실행하기 전에 할 일이 있었는데...");

        //실제 타겟의 메서드를 호출 -> 요기 시점으로 윗부분과 아랫 부분의 시점이 달라진다
        String value = (String) pjp.proceed();
        System.out.println("AROUND : 메소드가 실행 되고 나서 할 일이 아직 있었는데...");

        value += " 하하 나 around가 결과값에 뭔갈 붙였다";
        return value;
    }
}
