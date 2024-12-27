package day18;

//스레드는 Thread를 상속받는다
public class MyThread extends Thread {
    String name;

    public MyThread () {
        this.name = "asd";
    }

    public MyThread(String name) {this.name = name;}

    @Override
    public void run() {
        //이 쓰레드가 할 일을 구현함
        //이 쓰레드의 main이라고 생각하면 편함
        System.out.println("스레드 시작 되었다");

        for (int i  =0; i < 10; i++) {
            System.out.println(i + " " + name + " : 번 안녕이라고 말했어요");
            try {
                //()는 ms다, sleep도 예외처리를 해야
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("스레드 끝났다");
    }
}
