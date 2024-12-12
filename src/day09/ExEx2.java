package day09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExEx2 {
    //예외처리엔 요런 방식도 있지만
    public static void exMethod() {
        try {
            FileInputStream fis = new FileInputStream("as");
        }
        catch (Exception  e) {
            e.printStackTrace();
        }
    }
    //throws를 시키는 방식도 있다고 한다
    //얜 부른 쪽으로 예외를 던저줌
    public static void exMethod2() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("as");
    }


    public static void main(String[] args) {

        exMethod();
        try {
            exMethod2();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
