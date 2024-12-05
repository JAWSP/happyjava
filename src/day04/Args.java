package day04;

public class Args {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("야 인자 넣어");
            System.exit(0); //강제종료 ()안은 종료코드
        }
        System.out.println(args.length);

        for (String str: args)
            System.out.println(str);
    }
}
