package day04;

public class Method {
    //메서드는 하나의 기능이라고 생각하면 됨
    public static int plus(int a, int b) {
        return a + b;
    }


    //인자를 얼마나 받을지 모를때
    //values는 배열이다
    public static int plus(int... values) {
        System.out.println("와따 겁나 많네");
        int result = 0;

        for (int res : values)
            result += res;
        return result;
    }

    //사실 main도 메소드
    public static void main(String[] args) {
        int result = plus(2, 3);
        System.out.println(result);
        result = plus(4, 5);
        System.out.println(result);
        System.out.println(plus(200, 300));
        System.out.println(plus(100, 200, 300, 400));
    }
}
