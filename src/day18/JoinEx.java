package day18;

import java.util.SortedMap;

class SumThread extends Thread {
    //나는 계선해주는 스레드
    @Override
    public void run() {
        //대충 계산하는 거
        try {
            //대충 계산하는데 오래걸림
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("대충 계산 끝났다는 내용");
    }
}

public class JoinEx {
    public static void main(String[] args) {
        System.out.println("대충 main이 뭔가 하는중");
        System.out.println("근데 복잡한 계산을 하일을 만남");

        SumThread s = new SumThread();
        s.start();

        System.out.println("main는 그동안 다른 일을 하는중");
        try {
            s.join();  //sumThread가 일을 끝날때까지 기다리기
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("근데 sum스레드에서 했던걸 받고싶은데?");
    }
}
