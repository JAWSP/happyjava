package day16;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        //List는 데이터담는 인터페이스고 Arraylist는 그걸 구현화시킨 클래스
        List<String> list = new ArrayList<>();

        //데이터 담기
        list.add("a");
        list.add("b");
        list.add("c");

        //만약에 데이터를 보고 싶으면 get메소드를 이용하면 된다고 한다
        for (int i = 0; i < list.size(); i++) {
            //ArrayList는 순서가 있는 자료구조라서 요 방법이 건웅하다
            System.out.print(list.get(i) + ' ');
        }
        System.out.println("\nite");

        //이터레이터 객체생성
        //이터레이터 인터페이스에 list에서 정의된 이터레이터를 생성
        Iterator<String> iter = list.iterator();

        //has가 뒤가 있냐 next가 다음 값을 나온다
        while (iter.hasNext()) {
            System.out.print(iter.next() + ' ');
            //iter.remove(); //얜 삭제인데 순서대로 삭제가 된다고?
        }
        System.out.println("\nforeach");
        //for each버전
        for(String item : list) {
            System.out.print(item + ' ');
        }

        System.out.println("\nset");

        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");
        //set는 순서가 없어서 index가 존재하지 않는다
        //그래서 접근할려면 iterator가 필요하다
        Iterator<String> setIter = set.iterator();
        while(setIter.hasNext()) {
            System.out.print(setIter.next() + ' ');
        }
        System.out.println("\n foreach");
        //혹은 forEach로 쉽게 나오게 해도 된다고 한다
        for (String item : set) {
            System.out.print(item + ' ');
        }


    }
}
