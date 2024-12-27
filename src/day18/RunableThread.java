package day18;

//만약에 직접 상속을 못받지만 스래드를 받고 싶다면 이렇게 하면 된다
public class RunableThread implements Runnable{

    String name;

    public RunableThread() {
        this.name = "나는 스레드다";
    }

    @Override
    public void run() {
        //여기서 해야 할 일을 구현
        System.out.println("스레드 시작 되었다");

        for (int i  =0; i < 10; i++) {
            System.out.println(i + " " + name + " : 번 안녕이라고 말했어요");
            try {
                //()는 ms다, sleep도 예외처리를 해야
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println("스레드 끝났다");
    }
}
