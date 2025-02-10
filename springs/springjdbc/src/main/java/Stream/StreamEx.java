package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        List<String> mylist = Arrays.asList("a", "b", "c", "d", "asd");

        //스 트 림
        List<String> result = mylist.stream()
                        .filter(s->s.startsWith("a"))
                        .collect(Collectors.toList());
        System.out.println(result);

        //혹은 그냥 하나만 쓰고 싶다면
        mylist.stream().forEach(System.out::println);
        //스트림 객체를 만들 수 있음

        Stream<String> myListStream = mylist.stream();
        myListStream.forEach(System.out::println);
        //근데 스트림은 1회용임
//        myListStream.forEach(System.out::println);
        int[] iarr = {1,2,3,4,5,6,7,87,9,0};

       Arrays.stream(iarr).
               filter(i->i%2==0).
               forEach(System.out::println);


    }
}
