package day03;

public class ttt {
    public static void main(String[] args) {
        String str = "Hi";
        int i = 10;
        char a = 'a';
        double d = 5.12;
        String hap = str + i + i;
        System.out.println(i + i); //10 + 10 = 20
        //다 합해줌
        System.out.println(hap); // Hi1010
        System.out.println("test" + 30 + 3); //test303
        System.out.println("test" + (30 + 3)); //test33

        //별을 다이나믹하게 찍고 싶다면?
        for (int x = 5; x > 0; x--)
        {
            for (int y = 0; y < x; y++) {
                System.out.print("*");
        }
            System.out.println();//이렇게만 해도 개행됨
        }
        System.out.println();
        //삼각형
        for (int y = 5; y > 0; y--)
        {
            for (int x = 0; x < y; x++) {
                System.out.print(" ");
            }
            for (int x = 0; x < 5 - y + 1; x++)
                System.out.print("**");
            System.out.println();//이렇게만 해도 개행됨
        }
    }
}
