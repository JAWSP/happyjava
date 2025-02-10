package lambda;

public class FinalVariableEx {
    public static void main(String[] args) {
        //대충 이런 지역 변수가 있다 치자
        int x = 10;

        Runnable r = () -> {
            //그 지역변수를 이용하는 람다식 있음
            System.out.println("x : " + x);
        };

        //람다에 쓰이는 지역변수는 final이여야 해서 이렇게 다시 재정의가 안됨
        //즉 이 x는 사실상 final
        //x = 20;

        r.run();
    }
}
