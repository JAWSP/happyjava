package day18;

public class RthMain {
    public static void main(String[] args) {
        RunableThread runableThread = new RunableThread();

        //runnable쓰레드는 혼자서 동작은 못하고 Thread를 해야 한다
        Thread thread = new Thread(runableThread);
        thread.start();
        MyThread my = new MyThread();
        my.start();


        for (int i = 0; i <10; i++) {
            System.out.println(i + "main에서 일하는 중임");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("main 종료");
    }
}
