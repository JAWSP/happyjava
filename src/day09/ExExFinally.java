package day09;

import java.util.SortedMap;

public class ExExFinally {
    //코드가 멸망해도 finally는 실행된다
    public static void main(String[] args) {
        int[] iarr = {1, 2, 3};
        //1. 예외가 발생했고, 그 예외를 처리 했을때
        try {
            System.out.println("try start");
            System.out.println(iarr[3]);
            System.out.println("try end");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);

        } finally {
            System.out.println("이겼다! 예외 끝!");
        }

        //2. 예외가 발생하지 않았을때
        try {
            System.out.println("try start");
            System.out.println(iarr[0]);
            System.out.println("try end");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        } finally {
            System.out.println("이겼다! 예외 끝!");
        }

        //3. 예외가 발생했는데, 그걸 처리 못함
        //하지만 finally는 반드시 시전됨
        try {
            System.out.println("try start");
            int i = iarr[2] / 0;
            System.out.println("try end");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        } finally {
            System.out.println("이겼다! 예외 끝!");
        }


        System.out.println("이겼다! 예외 진짜 끝!");
    }
}
