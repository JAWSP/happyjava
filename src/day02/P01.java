package day02;

import java.sql.SQLOutput;

import static java.lang.Long.MAX_VALUE;

public class P01 {
    static boolean flag3;
    public static void main(String[] args) {
        int i = 0;
        int j = 2;
        boolean flag1 = false;
        boolean flag2 = i > 2 ^ j > 4;

        System.out.println("f1 is " + !flag1);
        System.out.println("f2 is " + flag2);
        System.out.println("f3 is " + flag3);
//      System.out.println(flag4);
        flag1 = j > 200 && i++ > 5;
        System.out.println("j > 200 && i++ > 5 is " + flag1);
        System.out.println(i);
        flag1 = j > 200 & i++ > 5;
        System.out.println("j > 200 && i++ > 5 is " + flag1);
        System.out.println(i);

        int mm = Integer.MAX_VALUE;
        System.out.println(mm);
        char c = Character.MIN_VALUE;
        System.out.println("char max = " + Character.MAX_VALUE);
        System.out.println("char min = " + c);
        System.out.println(Float.MAX_VALUE);

        int a = 7;
        System.out.println(a %= 3);
    }
}
