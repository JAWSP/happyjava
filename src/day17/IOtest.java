package day17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class IOtest {
    public static void main(String[] args) throws Exception {
        //키보드로 부터 한줄씩 입력 받아서 콘솔에 출력하고 싶을떄
        //키보드를 가리키는얘는 -> System.in(표준입력)
        //  얘는 inputsteram 입력스트림이 추상화된 놈
        // 한줄씩 입력 받기 위해서 입력을 저장해두는 버퍼가 필요함
        // BufferedReader
        // 생성자에 Reader를 받게 됨, 근데 바로 넣으면 아다리가 안맞음
        //  따라서 InputStreamReader를 이용하여 젠더느낌으로 넣어서 맞게 한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("입력 ㄱㄱ");

        // 그리고 한줄씩 입력받기 위하여
        // BufferedReader의 readLine()
        // 그리고 입력을 받을 떄 까지 한무대기
        String str = br.readLine(); //예외처리 해야함

        //입력 받은 얘를 출력
        System.out.println(str);

        //파일로 부터 한 줄씩 입력받고 싶을때
        //파일부분은 FileInputStream이다

        //파일을 읽고 싶다
        FileInputStream fls = new FileInputStream("ttt");
        //BufferedReader는 Reader만 받아들일 수 있으므로, FileInputStream이 직접 못들어감
        //그래서 이 사이를 아다리맞게
        //그리고 버퍼를 이용해 한줄씩 읽고 싶다
        //하지만 Buffered reader는 reader만 가능해서
        // Input를 reader클래스로 끼워맞춰주는 InputStreamReader가 필요함
        InputStreamReader isr = new InputStreamReader(fls);
        BufferedReader br2 = new BufferedReader(isr);
        //읽은 것을 출력
        System.out.println(br2.readLine());


    }
}
