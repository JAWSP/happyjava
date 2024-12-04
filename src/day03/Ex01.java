package day03;

import java.util.Random;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {

        //랜덤한 값을 출력할때
        System.out.println("랜덤임");
        Random random = new Random();
        System.out.println(random.nextInt(100));
        //얜 args를 쓰지 않고 입력 받을 수있는 놈이라고
        //근데 표준 입출력이 아닌 유틸리티에 가깝다고
        Scanner keyboard = new Scanner(System.in);
        System.out.println("'숫자' 입력");
        //만약 숫자로 입력받고 싶다면?
        //여기서 parseInt가 실행된다고 한다.
        //만약 숫자가 아닌게 입력된다? 그럼 바로 예외처리
        int input =  keyboard.nextInt();
        System.out.println("너가 입력한거 " + input);


    }
}
