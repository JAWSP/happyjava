package day18;



public class InterruptEx {
    static class IThread extends Thread {
        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    sleep(1000);
                    System.out.println("porcessing... 5/"+(i + 1));
                }
                //인터럽트인 경우엔ㄴ
            } catch (InterruptedException e) {
                System.out.println("스레드가 중단됨");
                return;
            }
        }
    }
    public static void main(String[] args) {
        IThread it = new IThread();
        it.start();
        try {
            Thread.sleep(2500);
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //얘가 종료시킴
        it.interrupt();

    }
}
