package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class Service {
    @PrintAnnotation
    public void method1() {
        System.out.println("aaaa");
    }

    @PrintAnnotation("@")
    public void method2() {
        System.out.println("골뱅이");
    }

    @PrintAnnotation(number = 10)
    public void method3(){
        System.out.println("숫자가 나오네");
    }

    @PrintAnnotation(value = "#", number = 20)
    public void method4(){
        System.out.println("둘다 나오게 하기");
    }
}
