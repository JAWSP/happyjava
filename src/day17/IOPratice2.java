package day17;

import java.io.*;

public class IOPratice2 {
    public static void main(String[] args) {
        //파일로부터 입력 받아서, 파일에 출력하는 코드


        try(//파일로부터 입력 받는 놈
                FileInputStream fis = new FileInputStream("./day17/IOtest.java");
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                //파일을 쓰는 놈
                PrintWriter pw = new PrintWriter("copied");
                ) {
            String input;
            while ((input = br.readLine()) != null) {
                System.out.println(input);
                pw.println(input);
            }
            pw.close();
            br.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        //혹은
        try (
            FileInputStream in = new FileInputStream("./day17/IOtest.java");
            FileOutputStream out = new FileOutputStream("nnn");
        ){
            //한꺼번에 1024바이트(1024글자)를 받고 싶을때
            byte[] buffer = new byte[1024];
            int c;
            //read는 끝나면 -1을 뱉는다
            //read()안에 저정도 넣으면
            while ((c = in.read(buffer)) != -1) {
               // out.write(c); //만약에 write할떄 파일이 없다면 만든다고함
                //여러개 받고싶다면 앞에 저렇게 버퍼를 받는걸로
                out.write(buffer, 0, c);
                System.out.println(buffer);
            }
        }catch (Exception e) {
            System.out.println(e);
        }

    }
}
