package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//주어진 `List<Integer>`의 모든 요소가 짝수인지 확인하라.
// 람다식을 활용하여 조건 검사를 수행하고 결과를 출력하라.
public class Pratice {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        // 람다식을 사용하여 모든 요소 검사
//        Predicate<Integer> isEven = n -> n % 2 == 0;
//        boolean allEven = true;
//
//        for (Integer number : numbers) {
//            if (!isEven.test(number)) {
//                allEven = false;
//                break;
//            }
        boolean allEven = numbers.stream()
                .allMatch(n->n % 2 == 0);

        System.out.println("모든 숫자가 짝수입니까? " + allEven);

        //주어진 List<String>에서 글자 수가 5 이상인 첫 번째 단어를 찾아 출력하라.
        // for 루프와 람다식을 활용하여 조건에 맞는 요소를 찾아보세요.
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Fig");
        // 람다식을 사용하여 조건 검사
//        Predicate<String> condition = s -> s.length() >= 5;
//
//        for (String word : words) {
//            if (condition.test(word)) {
//                System.out.println("첫 번째 길이가 5 이상인 단어: " + word);
//                break; // 첫 번째 매칭되는 요소를 찾으면 중단
//            }
//        }
        words.stream()
                .filter(s -> s.length() >= 5)
                .forEach(s-> System.out.print(s.charAt(0) + " "));
        System.out.println();

        //주어진 List<String>을 문자열 길이에 따라 정렬하되,
        // 람다식을 사용하여 Collections.sort() 메서드를 활용하라.
        // 람다식을 사용하여 리스트를 길이에 따라 정렬하라
        //Collections.sort(words, (s1, s2) -> s1.length() - s2.length());

        // 결과 출력
        //System.out.println(words);
    }
}
