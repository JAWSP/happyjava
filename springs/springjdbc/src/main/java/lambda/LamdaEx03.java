package lambda;

@FunctionalInterface
interface InterfaceSth {
    public void func(int x, int y);
}

public class LamdaEx03 {

    public static void main(String[] args) {
        SthInterface f1;
        f1 = new SthInterface() {
            @Override
            public void method1(int x) {
                int result = x * x;
                System.out.println(result);
            }
        };

        f1.method1(2);

        f1 = (x ) -> {
            for (int i = 0; i < x; i++) {
                int result = x * i;
                System.out.println(result);
            }
        };

        f1.method1(2);

        InterfaceSth f2;
        f2 = new InterfaceSth() {
            @Override
            public void func(int x, int y) {
                System.out.println(x + y);
            }
        };

        f2.func(2, 3);

        f2 = (x, y) -> {
            System.out.println(x - y);
        };
        f2.func(5, 2);


    }
}
