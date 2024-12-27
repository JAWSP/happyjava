package day18;

//공유객체
class Robot {
    public synchronized void methodA() {
        for (int i = 0; i < 5; i++) {
            System.out.println("그아아아아아아아악 "+ i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void methodB() {
        for (int i = 0; i < 5; i++) {
            System.out.println("크어어어어어억 "+ i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void methodC() {
        for (int i = 0; i < 5; i++) {
            System.out.println("꺄아아아아아아아악 "+ i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//공유 객체2
class Robot2 {
    public synchronized void methodB() {
        for (int i = 0; i < 5; i++) {
            System.out.println("B크어어어어어억 "+ i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//롸벗을 조종하는 얘
class RobotUser extends Thread {
    private String name;
    private Robot robot;
    private Robot2 r2;

    public RobotUser() {
        this.name = "john doe";
        this.robot = new Robot();
    }
    public RobotUser(String name) {
        this.name = name;
    }

    public RobotUser(String name, Robot robot, Robot2 r2) {
        this.name = name;
        this.robot = robot;
        this.r2 = r2;
    }

    //스레드 실행함수
    @Override
    public void run() {
        //Robot2 r2 = new Robot2();
        if ("A".equals(name))
            robot.methodA();
        else
            r2.methodB();
        /*
        if ("A".equals(name)) {
            robot.methodA();
        } else if ("B".equals(name)) {
            robot.methodB();
        } else {
            robot.methodC();
        }
         */
    }
}

public class SynMain {
    public static void main(String[] args) {
        //공유 객체 생성
        Robot robot = new Robot();
        Robot2 r2 = new Robot2();

        //공유 객체를 사용하는 스레드들
        RobotUser pilotA = new RobotUser("A", robot, r2);
        RobotUser pilotB = new RobotUser("B", robot, r2);
        RobotUser pilotC = new RobotUser("C", robot, r2);
        RobotUser pilotD = new RobotUser("A", robot, r2);

        pilotC.start();
        pilotA.start();
        pilotB.start();
        pilotD.start();
    }
}
