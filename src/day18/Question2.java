package day18;

import java.util.HashMap;

public class Question2 {
    public static void main(String[] args) {

        //왜 map로 했냐
        //byte[]는 참조형 배열(변수)라서 딴데에 가도 값이 유지되는데
        //int는 그냥 기본형 데이터타입이라서 딴데에 가도 딴데에선 점마가 가리키는 위치가 뭔지 모르기 때문에 그런다
        //->포인터를 배우고도 그걸 몰랐니 주호야
       //String buffer = new String();
        HashMap<byte[], Integer> resources = new HashMap<byte[], Integer>();

       //byte[] buffer = new byte[1024];
       //int c = 0;

        Thread fw = new Thread(new FileWriterTask(resources));
        Thread fr = new Thread(new FileReaderTask(resources));

        fr.start();
        fw.start();

    }
}