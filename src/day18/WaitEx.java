package day18;

//wait는 동기화된 블럭 혹은 메서드 내에서만 사용이 가능하다고 한다
public class WaitEx {
    //lock는 그저 동기화랑 notify하기 위한 객체인가봄
    // ->따라서 그냥 아무거나 걸어도 된다고 한다
    //integer해도 되네
    private static final Object lock = new Object();
    private static final Integer i = new Integer(21);
    private static int itemAvaliable = 0;
    //물건을 만드는 사람
    static class Producer extends Thread {

        @Override
        public void run() {
            //요 블럭을 선언하면 이 블럭 안은 동기화되어서 한 스레드만 이용 가능하다고 한다
            synchronized (i) {
                System.out.println("뭔갈 만드는 중");
                itemAvaliable = 5;
                i.notifyAll(); //생산이 끝났다고 알려줌->wait되어 있는 스레드를 꺠움
                System.out.println("오픈 준비 끝");
            }

        }
    }

    //물건을 사는 사람, 물건을 만들기 전에 사면 안됨
    static class Customer extends Thread {

        @Override
        public void run() {
            System.out.println("나 소비자 등장");
            synchronized (i) {
              //  while (itemAvaliable <= 0) {
                    System.out.println("존버 또 존버....");
                    try {
                        //아직 물건이 준비가 되어지지 않아서 wait로 가서 waiting pool로 가게 된다
                        i.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
               // }
                System.out.println("오픈런의 시간이다! 고기와 고기를 대령하라!");
                if (itemAvaliable <= 0)
                    System.out.println("오픈런 실패다 크아아아아악");
                else
                    itemAvaliable -= 1;
            }
        }

    }

    public static void main(String[] args) {
        Producer p = new Producer();
        Customer c = new Customer();
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        Customer c4 = new Customer();
        Customer c5 = new Customer();
        Customer c6 = new Customer();

        c.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } //물건이 만들어 지기 전에 사는걸 방지
        //->어차피 wait로 막아지는데 굳이 이게 필요할까..?
        //->어 필요해 만들어 지기 전에 사는걸 방지함과 동시에
        // 같은 경쟁자들끼리 같은 조건에서 살 수 있도록 해준다고


        p.start();
    }
}
