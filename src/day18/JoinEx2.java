package day18;

class TaskThread extends Thread {
    private String taskName;

    public TaskThread() {
        taskName = "john doe";
    }

    public TaskThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " 대충 작업 시작하는 내용");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(taskName + " 대충 작업 끝나는 내용");
    }
}

class Demonthread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("대충 데먼이 계속 뭔갈 하는중");

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class JoinEx2 {
    public static void main(String[] args) {
        TaskThread task1 = new TaskThread("작업1");
        TaskThread task2 = new TaskThread("작업2");

        Demonthread dm = new Demonthread();

        task1.start();
        task2.start();

        dm.setDaemon(true);
        dm.start();

        try {
            System.out.println("다 끝났니?");
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("메인 끝");
        //그럼 데먼스레드는 메인이 끝나도 실행이 되는데?
        //그럼 setDaemon()
    }
}
