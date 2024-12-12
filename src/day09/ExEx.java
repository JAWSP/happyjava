package day09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExEx {
    public static void main(String[] args) {
        int[] iarr = {1, 2, 3};

        try {
            iarr[6] = 100; //컴파일시엔 체크안함
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("wq");
        }
        catch (FileNotFoundException e) {
            System.out.println("그거 없는뎁셔");
        }
        //얜 컴파일시에 체크함

    }
}
