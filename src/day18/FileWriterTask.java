package day18;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//사용자로부터 입력받은 데이터를 파일에 쓰는 작업을 수행
//ouput.txt라는 파일에서 계속 추가
public class FileWriterTask implements Runnable {

    HashMap<byte[], Integer> resources;

    FileWriterTask (HashMap<byte[], Integer> resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        try (FileOutputStream out = new FileOutputStream("output.txt")) {
            Thread.sleep(500);
            Set<byte[]> s = resources.keySet();
            for (byte[] buffer : s) {
                out.write(buffer, 0, resources.get(buffer));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}





