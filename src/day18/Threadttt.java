package day18;

import java.util.Scanner;
import java.util.SortedMap;

public class Threadttt {
    public static void main(String[] args) {
        System.out.println("안냥");
        Scanner k = new Scanner(System.in);
        String msg = k.next();
//수행흐름이 하나이면 단일쓰레드이고 단일 스레드라면 여기서 한무대기함
        System.out.println("네가 친건 : " + msg);
    }
}
