package day17;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Ex {
    public static void main(String[] args) throws Exception {
        //url또한 IO가능(추상화 가능)
        URL url = new URL("https://snskeyboard.com/dotart/");
        //url의 내용을 1줄씩 봅시다
        //1줄은 역시 BufferReader의 readLine();
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        for (int i = 0; i < 5; i++) {
            System.out.println(br.readLine());
        }
        //다 읽고 싶다면
        /*
        String line = null;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
         */
    }
}
