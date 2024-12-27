package day18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//사용자로부터 입력받은 데이터를 파일에 쓰는 작업을 수행
//ouput.txt라는 파일에서 계속 추가
public class FileWriterTask implements Runnable {
    byte[] buffer;
    FileWriterTask (byte[] buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try(FileOutputStream out = new FileOutputStream("output.txt")) {
            Thread.sleep(1000);
            out.write(buffer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
