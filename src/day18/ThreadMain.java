package day18;

public class ThreadMain {
    //나는야 메인스레드?
    public static void main(String[] args) {
        System.out.println("main 시작");

        //스레드 생성
        MyThread myThread = new MyThread();
        NewThread newThread = new NewThread();
        //얜 깡으로 호출, 그냥 깡 메서드가 된다고
        //myThread.run();

        //얘가 스레드로 나눠서 시작
        myThread.start();
        newThread.start();

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
