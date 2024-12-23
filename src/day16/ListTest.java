package day16;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");

        String ff = fruits.get(0); //get(indx)로 직접 꺼내기
        System.out.println(ff);

        //toString오버라이딩이 적용됨
        System.out.println(fruits);
        //몇번째 인덱스에 값을 넣을꺼냐
        fruits.set(1, "pineapple");
        System.out.println(fruits);
        //얜 거 위치에 비집고 넣기
        fruits.add(2, "banana");
        System.out.println(fruits);

        //요소 삭제하기
        System.out.println(fruits.remove("pineapple"));
        System.out.println(fruits);

        fruits.removeFirst();
        System.out.println(fruits);


        //list는 중복도 가능하다
        fruits.add("banana");
        System.out.println(fruits);

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(23);
        intList.add(3);
        intList.add(231);
        intList.add(6);
        intList.add(212);

        //Arrarys마냥 컬렉션도 유틸리티 클래스가 있다고 한다
        Collections.shuffle(intList);
        System.out.println(intList);
        Collections.shuffle(intList);
        System.out.println(intList);
        //정렬도 가능
        Collections.sort(intList);
        //
        System.out.println(intList);
    }
}
