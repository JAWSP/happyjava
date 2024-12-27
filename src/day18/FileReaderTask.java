package day18;

import java.io.FileInputStream;

//지정된 파일에서 텍스트를 읽고 콘솔에 출력
//출력할 파일은 output.txt
public class FileReaderTask implements Runnable {
    byte[] buffer;
    FileReaderTask (byte[] buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run() {
        try(FileInputStream in = new FileInputStream("tttt")) {
            int c = 0;
            while ((c = in.read(this.buffer)) != -1) {
                if (c < 1024)
                    buffer[c] = '\0';
                System.out.println(buffer);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
