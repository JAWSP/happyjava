package day02;

public class Question {
    public static void q1(int c)
    {
        double result = c * 9 / 5 + 32;
        System.out.println("섭씨 " + c + " 는 화씨 " + result);
    }

    public static void q2(int c)
    {
        if (c % 2 == 0)
            System.out.println("C는 짝수네");
        else
            System.out.println("C는 홀수네");
    }
    public static void q3()
    {
        int i = 0;
        while (++i <= 9)
        {
            System.out.print(i * 2);
            System.out.print("   ");
            System.out.print(i * 3);
            System.out.print("   ");
            System.out.print(i * 4);
            System.out.print("   ");
            System.out.print(i * 5);
            System.out.print("   ");
            System.out.print(i * 6);
            System.out.print("   ");
            System.out.print(i * 7);
            System.out.print("   ");
            System.out.print(i * 8);
            System.out.print("   ");
            System.out.print(i * 9);
            System.out.print("\n");
        }
    }
    public static void q4(int c)
    {
        long value = 1;
        for (int i = 0; i < c; i++)
        {
            value *= c - i;
            System.out.println(c - i);
        }
        System.out.println("value is " + value);
    }
    public static void q5(String[] args)
    {
        int answer = Integer.parseInt(args[0]);
        int i = 1;
        while (i < args.length)
        {
            if (answer > Integer.parseInt(args[i]))
                System.out.println("더 낮습니다");
            else if (answer < Integer.parseInt(args[i]))
                System.out.println("더 높습니다");
            else {
                System.out.println("정답! 답은 " + answer + " 입니다!");
                break;
                }

            i++;
        }

    }
    public static void q6(String[] args)
    {
        int i = 0;
        int value = 0;
        do {
           value += Integer.parseInt(args[i]);
           i++;
        }
        while(i < args.length);
        System.out.println(value);
    }
    public static void q7(String[] args) {
        for(int i = 0; i < args.length; i++)
        {
            if (Integer.parseInt(args[i]) % 2 != 0)
                System.out.println(args[i] + "는 홀수");
            else
                System.out.println(args[i] + "는 짝수");
        }
    }
    public static void q8(String[] args) {
        if (args.length != 3)
            System.out.println("숫자 숫자 사칙연산 넣으시오");
        else {
            switch (args[2]) {
                case "+":
                    System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
                    break;
                case "-":
                    System.out.println(Integer.parseInt(args[0]) - Integer.parseInt(args[1]));
                    break;
                case "*":
                    System.out.println(Integer.parseInt(args[0]) * Integer.parseInt(args[1]));
                    break;
                case "/":
                    System.out.println(Integer.parseInt(args[0]) / Integer.parseInt(args[1]));
                    break;
            }
        }
    }
    public static void main(String[] args) {
        int c = 20;
        q1(c);
        q2(c);
        q3();
        q4(c);
        q5(args);
        q6(args);
        q7(args);
        q8(args);
    }
}
