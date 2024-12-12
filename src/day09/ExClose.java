package day09;

import java.io.FileInputStream;
import java.io.IOException;

public class ExClose
{
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("asd");;
        } catch (Exception e) {
            System.out.println(e);
        }/*
        finally {

            try {
                //얘도 thorws가 있어서 예외처리 해줘야함
                fis.close();

            } catch (IOException e) {
                System.out.println(e);
            }


        }
        */
        //요게 try-with-resources인데 close가 자동으로 일어남
        try (FileInputStream fis2 = new FileInputStream("dsa")) {

        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
