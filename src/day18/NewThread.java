package day18;

public class NewThread extends Thread {
    @Override
    public void run () {
        System.out.println("새로운 스레드 시작");

        for (int i = 0; i < 5; i++) {
            System.out.println(i + "마! 나도 출력할끼다!");
        }

        System.out.println("새로운 스레드 끝");
    }
}
