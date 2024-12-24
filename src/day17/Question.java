package day17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Question {
    public static void main(String[] args) {

        try (
             //하난 파일에 쓰는놈
             //다른 하난 읽는 놈
        PrintWriter pw =new PrintWriter("phone.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br2 = new BufferedReader(new FileReader("phone.txt"));
        ) {
            for (int i = 0; i < 3; i++) {
                System.out.print("이름 : ");
                String name = br.readLine();
                System.out.print("전화번호 : ");
                String num = br.readLine();
                pw.println(name + " " + num);
            }
            System.out.println("전화번호가" + " phone " +"에 저장되었습니다.");

        } catch (Exception e) {
            System.out.println(e);
        }
        //위에서 한번에 하면 갱신이 안대요
        try(
                BufferedReader br2 = new BufferedReader(new FileReader("phone.txt"));
                ) {
            System.out.println("네가 저장한 정보");
            String output;
            while ((output = br2.readLine()) != null) {
                System.out.println(output);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
