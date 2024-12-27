package day18;

//동기화x, 일관성보장x 각둘 스레드들은 동시에 나와야 한다

//1~100증가시키면서 출력
class IncrementCounter implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 100; i++) {
                System.out.println("increase " + i);
                Thread.sleep((int)Math.random() * 10);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//100~1감소시키면서 출력
class DecrementCounter implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 100; i >= 1; i--) {
                System.out.println("decrease " + i);
                //랜덤?
                Thread.sleep((int)Math.random() * 10);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

public class Question {
    public static void main(String[] args) {
        Thread incrementThread = new Thread(new IncrementCounter());
        Thread decrementThread = new Thread(new DecrementCounter());

        incrementThread.start();
        decrementThread.start();

    }
}
