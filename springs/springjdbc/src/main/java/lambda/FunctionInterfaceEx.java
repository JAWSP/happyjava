package lambda;

//요걸 토대로
//@FunctionalInterface
//public interface IntBinaryOperation {
//    int apply(int a, int b);
//}

public class FunctionInterfaceEx {
    public static void main(String[] args) {
        //이전에 구현할려면 이렇게 직접 구현해야 했음
//        IntBinaryOperation add = new IntBinaryOperation() {
//            @Override
//            public int apply(int a, int b) {
//                return a + b;
//            }
//        };
        //이젠 MZ하게 람다식으로
        //한줄이면 {}를 빼고 리턴을 생략 가능
        IntBinaryOperation add = (a, b) -> a + b;
        IntBinaryOperation minus = (a, b) -> a- b;
        IntBinaryOperation multiply =(a, b) -> {return a * b;};

        System.out.println(add.apply(2, 5));
        System.out.println(minus.apply(2, 5));
        System.out.println(multiply.apply(2, 5));


    }
}
