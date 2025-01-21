package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//요건 어느 타이밍에 요 이노테이션을 쓸거냐
//RUNTIME는 실행시
@Retention(RetentionPolicy.RUNTIME)
//타겟은 특정 범위 내에서만 쓰겠다는것
@Target(ElementType.METHOD)
//기본 선언 양식은 이렇게 되있음
public @interface Count100 {
    String value() default "*";
    int number() default  5;
}
