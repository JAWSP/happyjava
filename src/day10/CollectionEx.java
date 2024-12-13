package day10;

import java.util.ArrayList;

public class CollectionEx {
    public static void main(String[] args) {
        //얘는 가변길이임
        //뒤에 추가되면 뒤에 노드가 추가된다는 느낌으로 늘어난다고 한다
        ArrayList<String> strList = new ArrayList<>();
        System.out.println(strList.size()); //0

        strList.add("a");
        strList.add("b");
        strList.add("c");

        System.out.println(strList.size()); //3

        ArrayList<String> strList2 = new ArrayList<>(10);
        //할당량을 늘어도 사이즈는 0
        //근데 capacity는 안되나보네 -> 할당/해제도 알아서 해주는데 굳이 할 필요가 있나 이건가
        System.out.println(strList2.size()); //0

        System.out.println(strList.get(2));

        //하나씩 보고싶다면
        for (int i = 0; i <strList.size(); i++)
            System.out.println(strList.get(i));
        //다른 방법, forEach를 이용
        for(String str: strList)
            System.out.println(str);

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(1); //여기서 1만 봤을땐 기본타입 으로 보이겠지만
        // ->여기에 오토박싱이 숨어있다고 한다
        //1만 들어가는게 아니라 저기서 new Integer객체로 만들어서 1로 들어간다고 한다
        //왜냐면 원래는 저기에 Integer로 변환된 1이 들어가는게 정배라고 한다
        //  Integer i = 10; ->대충 이렇게 오토박싱이 되는 느낌이라고
        //이렇게 자동으로 돌려주는게 오토박싱인듯

       // integerArrayList.add(Integer.valueOf(1)); ->옛날엔 이렇게가 정배라고함
        integerArrayList.add(2);
        integerArrayList.add(3);
        //0번 인덱스를 삭제하고 싶을때
        System.out.println(integerArrayList.remove(0));//1
        System.out.println(integerArrayList);
        //값이 3인 인덱스를 삭제하고 싶을때
        System.out.println(integerArrayList.remove(Integer.valueOf(3)));//true
        System.out.println(integerArrayList);
        //특정 값이 있는지 찾고 싶을떄
        System.out.println(integerArrayList.contains(5)); //false
        //rm -rf
        integerArrayList.clear();
        System.out.println(integerArrayList); //없



    }
}
