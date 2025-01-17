package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import sample.bean.Book;
import sample.bean.MyBean;

public class MyBeanConfig {
    //스프링 공장에게 나 어떤 빈을 관리하게 할건지 알려줄 필요가 있다
    //알아서 해주는 것 같지만 우리가 알려줘야 한다

    //빈을 만들어 주는 놈
    //기본적으로 싱글톤임
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
    //얜 내용이 같아도 별개의 빈으로 취급된다고 한다
    //하지만 이 방식대로 만든 얘들은 같다고 한다
    @Bean
    public MyBean myBean2() {
        return new MyBean();
    }

    //스코프를 프로토타입으로 지정해서 원본이랑 다르다
    //이게 뭐가 틀리냐면 다른 얘들은 공장 돌아갈때 생성되지만
    //얜 직접 생성될때마다 새로운빈들이 생성된다
    @Bean
    @Scope("prototype")
    public MyBean myBean3() {
        return new MyBean();
    }

    @Bean
    public Book book() {
        return new Book();
    }
    //xml버전은 뭐냐고?
    //<bean id="myBean" class = "sample.bean.myBean" />
}
