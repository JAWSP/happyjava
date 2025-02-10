package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamEx02 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");

        //글자수가 5개 이상인 것만 필터링하고 중복 제거하고 새로운 리스트를 얻고 싶다면?
        List<String> result = new ArrayList<>();

        for(String word : words) {
            if (word.length() >= 5)
                if(!result.contains(word))
                    result.add(word);
        }
        System.out.println(result);
        //스트림을 이용한다
        List<String> streamResult = words.stream()
                .filter(s -> s.length() >= 5)
                .distinct()
                .toList();
        System.out.println(streamResult);


        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Cherry", "Date")
        );

        //flatmap는 각 요소를 스트림으로 변환하고 그 스트림들을 하나로 합친다
        List<String> flatList = nestedList.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flatList);

        //map는 스트림의 각 요소를 주여진 요소에 특정 함수를 넣어서 적용시킨다
        System.out.println(words.stream()
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList()));

        int[] intArr = {2, 4, 5, 7, 33, 55, 77};
        //각 요소에 3을 더한다
        Arrays.stream(intArr)
                .map(i -> i + 3)
                .forEach(i -> System.out.print(i + " "));

        System.out.println();
        //sort는 데이터를 정렬, 기본은 오름차순
        words.stream()
                .sorted()
                .forEach(s -> System.out.print(s + " "));

        //이건 내림차순
        Arrays.stream(intArr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(i -> System.out.print(i + " "));

        System.out.println();
        System.out.println();
        System.out.println(words);
        //forEach와 peek 는 순회하면서 뭔갈 벌임
        //근데 peek는 중간연산
        words.stream()
                .peek(s ->System.out.println("나는야 " + s))
                .peek(s -> s += "www")
                .map(s -> s += "wwe")
                .forEach(s-> System.out.print(s + ' '));


    }

}
