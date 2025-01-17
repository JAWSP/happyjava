package sample.run;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.Book;
import sample.bean.MyBean;
import sample.config.MyBeanConfig;

public class Ex01 {
    public static void main(String[] args) {
        //직접 쓰는 경우
        MyBean bean = new MyBean();
        bean.setName("asd");

        System.out.println(bean.getName());

        //스프링 IoC container를 이용해서 사용한다
        //빈을 등록해야한다 (1, xml이용, 2. 자바config이용, 3. 에노테이션을 붙여서)

        //스프링이 제공하는 공장(컨테이너?)을 통해서 사용한다
        // 1. BeanFactory -> 단순한 일만 한다. aop같은 기능은 사용이 불가
        // 2. ApplicationContext ->요샌 요걸 쓴다고 한다
        //요게 공장인데
        //공장의 목적은 빈을 생성, 그리고 어떤 빈을 만들건지 알려줘야 한다
        System.out.println("뚝딱뚝딱");
        //ApplicationContext는 공장 인터페이스
        //Annotation거시기는 해당 설정에 따라서 저렇게 만든다는 뜻
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
        System.out.println("팩토리에 에드온을 붙여");

        //빈 객체를 생성하는 법
        //getBean는 Object타입으로 반환하기 떄문에 형변환 시켜줌
        //인자로 이름을 저대로 넣으면 저 공장이 알아서 이릉을 알아서 써준다고 한다
        MyBean b1 = (MyBean)context.getBean("myBean"); //이렇게
        System.out.println(b1);
        MyBean b2 = context.getBean("myBean", MyBean.class); //얜 다른 방법으로 빈을 생성
        System.out.println(b2);

        //id없이 타입만 가지고 해줌
        //단, 해당 @bean은 하나만 있어야 한다
        Book book = context.getBean(Book.class);
        System.out.println(book);
        if (b1 == bean)
            System.out.println("같은 인스턴스인뎁쇼");
        else
            System.out.println("다른 인스턴스인뎁쇼");
        //기본적으로 싱글톤이긴 함 왜냐면 빈은 매우 퓨어퓨어한 놈이라서


        MyBean b3 = context.getBean("myBean2", MyBean.class);
        MyBean b4 = context.getBean("myBean3", MyBean.class);
        MyBean b5 = context.getBean("myBean3", MyBean.class);
        if (b3 == b2)
            System.out.println("같은 인스턴스인뎁쇼");
        else
            System.out.println("다른 인스턴스인뎁쇼");
        if (b4 == b5)
            System.out.println("같은 인스턴스인뎁쇼");
        else
            System.out.println("다른 인스턴스인뎁쇼");
    }
}
