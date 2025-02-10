package lambda;

import java.util.function.*;

public class JavaFunctionalInterfaceEx {
    public static void main(String[] args) {
        //얘는 입력을 받아서 결과를 boolean을 리턴하는 메서드를 가진 인터페이스
        // 인자 필요함, 리턴 boolean
        //조건을 테스트할때 사용(통과, 불통과)
        Predicate<Integer> isPositive = x -> x>0;
        System.out.println(isPositive.test(2));
        System.out.println(isPositive.test(0));

        //얘는 입력을 받아서 수행함
        //인자 필요함 리턴 없음
        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("끼얏호우");
        //한줄뿐이니 ::가능함(메서드 참조라고 말하는듯)
        Consumer<String> shorty = System.out::println;
        shorty.accept("오오");

        //근데 andThen이란 것도 있음
        Consumer<String> conA = s -> System.out.println(s + "aaa");
        Consumer<String> conB = s -> System.out.println(s + "bb");
        conA.accept("w");
        conB.accept("w");

        //andThen는 2개의 인터페이스를 연속으로 이어서 붙이는거
        Consumer<String> ConAB = conA.andThen(conB);
        ConAB.accept("아");




        //얜 입력을 받아서 출력함
        //인자 필요함, 리턴 필요함
        //2번째 제네릭이 리턴 타입을 명시함, 첫번째는 인자의 타입
        Function<String, Integer> lengthFunc = s -> s.length();
        System.out.println(lengthFunc.apply("123456789"));
        //물논 아까 그건 한줄로 표현가능하니 얘도 됨
        Function<String, Integer> shortFunc = String::length;
        System.out.println(shortFunc.apply("가나다라마바사"));

        //얜 입력은 없지만 값을 반환하는 인터페이스
        //인자 필요없음, 리턴 필요함
        //첫번째 인자는 반환의 타입
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());
        //얘도 한줄짜리이니
        Supplier<Double> shortRandom = Math::random;
        System.out.println(shortRandom.get());

        //이런 서플라이어도 있음
        IntSupplier intSupplier = () -> 4;


        //값을 2개 입력 받고 하나의 결과를 반환
        //인지 2개 필요함, 리턴 필요함
        //1,2제네릭은 인자, 3번째 제네릭은 리턴
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a+b;
        //이래도 됨
        BiFunction<Integer, Integer, Integer> shortAdd = Integer::sum;


    }
}
