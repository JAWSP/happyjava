package day18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

//지정된 파일에서 텍스트를 읽고 콘솔에 출력
//출력할 파일은 output.txt
public class FileReaderTask implements Runnable {

    HashMap<byte[], Integer> resources;

    FileReaderTask (HashMap<byte[], Integer> resources) {
        this.resources = resources;
    }


    @Override
    public void run() {
        try(FileInputStream in = new FileInputStream("phone.txt")) {
            int c = 0;
            byte[] buffer = new byte[1024];
            while((c = in.read(buffer)) != -1) {
                resources.put(buffer, c);
                System.out.println(new String(buffer, 0, c));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
