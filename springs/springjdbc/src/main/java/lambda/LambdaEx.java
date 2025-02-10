package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class LambdaEx {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("c");
        names.add("b");
        names.add("a");

        List<String> namelist = Arrays.asList("c", "b", "a");

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(names);

        namelist.sort((o1, o2)-> o1.compareTo(o2));

        System.out.println(namelist);

        BiFunction<Integer, Integer, Integer> add = Integer::sum;
    }
}
