package day10;

import java.util.ArrayList;

public class GenEx {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        //list배열
        //얘는 다양한 타입을 배열로 놓을 수 있긴 한데
        //문제는 실전성이 딸려
        list.add(new Book("asd"));
        list.add(new String("wwwww"));

        int[] iarr = new int[4];
        iarr[0] = 0;

        Object[] oarr = new Object[5];
        oarr[0] = "asd";
        oarr[1] = new Book("w");

        //심지어 같은 타입이에도
        ArrayList list2 = new ArrayList();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        //접근할려면 Object타입으로 넣다보니 사용할때마다 형변환 해야함
        ((String)list2.get(0)).toUpperCase();

        //따라서 이를 타파하기 위하여 나온게 제네릭<>
        ArrayList<String> list3 = new ArrayList<>();
        //Arraylist<>와 그 list와의 차이점은 후자는 사이즈가 정해져 있지 않다는거
        //벡터랑 배열을 생각해보면 될지도?


    }

}
