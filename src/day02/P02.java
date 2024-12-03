package day02;

public class P02 {
    public static void main(String[] args) {
        int mm = Integer.MAX_VALUE;
        System.out.println(mm);
        char c = Character.MIN_VALUE;
        System.out.println("char max = " + Character.MAX_VALUE);
        System.out.println("char min = " + c);
        System.out.println(Float.MAX_VALUE);

        int a = 7;
        System.out.println(a %= 3);

        //옵플시험

        int op = 2147483647;

        System.out.println(op + 1);

        //형변환
        //작은 그릇에서 큰 그릇 담을때 형변환 가능
        int sm = 10;
        long ll = sm;
        float ff = sm;
        System.out.println(ll + " " + ff);

        //큰 그릇에서 작은 그릇으로 담을때 명시적으로 해야함
        //큰 타입의 값이 작은 타입의 값보다 클 수 있으니 형변환을 시켜줘야함
        long l2 = 20;
        float f2 = 20.22f;
        int ss = (int) l2;
        int sf = (int) f2;
        System.out.println(l2 + " " + f2);

        float f = 10f;

        long l = (long) f;
        //정수에 실수에 저장할때 아무리 크기가 더 큰 타입에 저장한다 해도
        //명시적으로 형변환을 해야한다
        char c2 = (char)97; //a
        System.out.println(c2);
    }
}
