package day09;


import java.util.Scanner;

public class UserEx {
    //사용자 정의 예외
    //점수는 100점만점이라 그 이상은 예외처리하고 싶음
    //그럼 내멋대로 예외처리를 하면 됨
    public static void inputScore(int score) throws MyException {
        if (score < 0 || score > 100) {
            /*
            기존엔 이렇게 예외처리하겠지
            System.out.println("점수가 음수거나 100점을 넘는데요");
            return;
             */
            throw new MyException("점수가 음수거나 100점을 넘는데요");
        }
        System.out.println("your score :" + score);
    }
    public static void main(String[] args) {

        //키보드로부터 입력받는 객체 생성
        Scanner keyboard = new Scanner(System.in);
        System.out.println("your score?");
        try {
            inputScore(keyboard.nextInt());//입력대기
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
