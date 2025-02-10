package Stream;

import org.springframework.data.relational.core.sql.In;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class StreamEx03 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //all은 전원 true, any는 하나라도 true, none는 전원 false해야지 true가 된다
        System.out.println(numbers.stream().allMatch(n -> n >=2));//f
        System.out.println(numbers.stream().anyMatch(n -> n>= 2));//t
        System.out.println(numbers.stream().noneMatch(n->n>=2));//f

        int[] intArr = {2, 4, 5, 7, 33, 55, 77};

        //count는 세는거
        long count = Arrays.stream(intArr).count();
        System.out.println(count);
        //max는 최대값, orElse는 없다면 0반환, orElse는 Optional메서드고, stream이 아님
        System.out.println(Arrays.stream(intArr).boxed().max(Integer::compareTo).orElse(0));
        //average는 평균값
        //여기서 Integer로 넣었을 경우 mapToInt(Integer::intValue)를 통하여 int로 바꿔야 한다
        //왜냐면 Integer는 객체이기 때문
        System.out.println(Arrays.stream(intArr).average());
        //sum은 합
        System.out.println(Arrays.stream(intArr).sum());

        //1 + 2 + 3 + 4 + 5
        int res = numbers.stream().reduce(0, (a, b) -> a+ b);
        System.out.println(res);
    }
}
