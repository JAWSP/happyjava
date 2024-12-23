package day16;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        //얘도 toString을 오버라이딩함
        System.out.println(set);
        //만약에 새로 들어오면
        set.add("a");
        //그대로 된다
        System.out.println(set);

        //contains메소드를 통하여 있는지 없는지 확인
        //그걸로 중복
        System.out.println(set.contains("a"));

        Set<Pen> penSet = new HashSet<>();
        penSet.add(new Pen("white"));
        penSet.add(new Pen("black"));
        penSet.add(new Pen("purple"));
        //순서가 없어서 넣는 순서가 아닌 다르게 나온다
        System.out.println(penSet);
        //근데 쌩으로 중복으로 넣으면 중복으로 넣어짐
        //왜냐면 값을 비교하는 equals로 비교해야 하는데
        //그게 없으니 주소값을 보고 비교했었고, 서로 다른 객체이니  주소값이 다르고
        //그렇게 다르다고 판단해서 값을 넣게 됨
        //근데 자료구조앞에 hash라고 붙으면 hashCode를 이용하여 비교하는게 좋다

        penSet.add(new Pen("white"));
        System.out.println(penSet);

    }

}
