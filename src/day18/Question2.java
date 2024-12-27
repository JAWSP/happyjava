package day18;

public class Question2 {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        //String buffer = new String();
        Thread fw = new Thread(new FileWriterTask(buffer));
        Thread fr = new Thread(new FileReaderTask(buffer));

        fr.start();
        fw.start();

    }
}
