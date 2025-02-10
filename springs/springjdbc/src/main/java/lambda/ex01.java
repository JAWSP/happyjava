package lambda;

public class ex01 {
    //기존 함수
    public int test(Integer integer) {
        return integer + 10;
    }


    public static void main(String[] args) {

        System.out.println("q");
        //이전에는 이렇게 익명 객체를 만들었다면
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("야호");
            }
        };
        new Thread(runnable).start();


        //이걸 간단히 한줄로 끝낼 수 있다
        Runnable runnable2 = () -> System.out.println("hi");

        new Thread(runnable2).start();
    }


}
