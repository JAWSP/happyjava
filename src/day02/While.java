package day02;

public class While {
    public static void main(String[] args) {
        int count = 0;
        while (count++ < 5) {
            //저 메소드는 atoi와 같음
            if(count > 5)
                break;
            int value = Integer.parseInt(args[count - 1]);
            System.out.println(value);
        }

        int i = 0;
        while (i++ < 10)
        {
            if (i % 2 != 0)
                continue;
            //홀수는 출력 하고 싶지 않다면 저걸로 바로 다음으로 반복이 된다
            System.out.println("이번 짝수는 " + i);
        }
        //조건에 상관없이 한번 하고 싶을때
        int num = 2;
        do {

        }while (num > 10);
        {
            System.out.println("go?");
        };
    }
}
