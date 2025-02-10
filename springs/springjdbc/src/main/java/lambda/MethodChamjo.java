package lambda;

import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodChamjo {
    public static void main(String[] args) {
        //메소드 참조 ::
        //1. 정적에서도 참조
        //BiFunction<Integer, Integer, Integer> add = (a, b) -> a+b;
        BiFunction<Integer, Integer, Integer> shortAdd = Integer::sum;
        System.out.println(shortAdd.apply(2, 5));

        //2. 인스턴스 메서드 참조
        String str = "ㅎㅇ";
        Supplier<Integer> lengthfunc = str::length;
        System.out.println(lengthfunc.get());

        //3. 임의 객체의 인스턴스 메소드 참조
        List<String> words = Arrays.asList("a", "b", "c");
        List<String> lengths = new ArrayList<>();

        Function<String, Integer> lenghF = String::length;

        //4. 생성자 참조
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> list = listSupplier.get();

    }
}
