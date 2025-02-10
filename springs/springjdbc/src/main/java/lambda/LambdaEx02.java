package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaEx02 {
    public static void main(String[] args) {
        List<String> namelist = Arrays.asList("c", "b", "a");

        //이번엔 forEach
        //Consumer라는 함수형 인터페이스가 있음
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        namelist.forEach(consumer);

        System.out.println("--------------------------");

        //이번에는 익명객체로 forEach안에 넣기
        namelist.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("--------------------------");

        //이번에는 람다식으로
        namelist.forEach(name -> System.out.println(name));

        System.out.println("--------------------------");
        //그냥 이렇게 해도 됨
        namelist.forEach(System.out::println);

    }
}
