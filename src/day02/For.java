package day02;

import java.util.SortedMap;

public class For {
    //클래스의 구성요소
    //속성 -> 맴버?
    //행위(메서드) {실행할 구문}
    public static void main(String[] args) {
        //for(초기값; 조건; 증감) { 실행할 구문 }
        for (int i = 0; i < 10; i++)
            System.out.println("나는 경기도 안양의 김준영이다!!!!!");
        String star = "*";
        for (int i = 0; i < 5; i++) {
            System.out.println(star);
            star += "*";
        }
    }
}
