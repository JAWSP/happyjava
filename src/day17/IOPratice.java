package day17;

import java.io.*;

public class IOPratice {
    public static void main(String[] args) throws Exception {
        //키보드로부터 5줄 입력 받아서 콘솔에 출력하고 싶다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            System.out.println(str);
        }
        br.close();

         */

        //파일에 출력 하고 싶다면?

        FileInputStream fis = new FileInputStream("ttt");
        br = new BufferedReader(new InputStreamReader(fis));
        for (int i = 0; i < 5; i++) {
            String msg = br.readLine();
            System.out.println(msg);
        }
        fis.close();
        //파일을 입력 하고 싶다면?
        try {
            FileWriter fw = new FileWriter("ttt");
            //얜 입력 받고 나서 개행을 시켜주는 놈이라고 한다 ->그러니까 채신-클래스
            PrintWriter pw = new PrintWriter(fw);
            //PrintWriter pw = new PrintWriter("ttt"); ->아싸리 이렇게 해도 됨
            //그리고 입력 받기 위한 클래스도 필요함
            br = new BufferedReader(new InputStreamReader(System.in));
            for (int i = 0; i < 5; i++) {
                String msg = br.readLine();
                System.out.println(msg); //
                pw.println(msg);
                //fw.write(msg); 얜 개행이 안됨
            }
            fw.close();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

        }

        //fw.close(); //얜 닫아야지 입력이 완료됨


    }
}
