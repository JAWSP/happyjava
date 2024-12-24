package day17;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInput {
    //기본데이터타입으로 읽을 경우
    public static void main(String[] args) {
        try(
                DataInputStream dis = new DataInputStream(new FileInputStream("asd"));
                ) {
            if(dis.readBoolean()) {
                System.out.println("ㄹㅇ?");
            }
            byte b = dis.readByte();
            System.out.println(b);
            char c = dis.readChar();
            System.out.println(c);
            System.out.println(dis.readDouble());
            //넣은 순서대로 꺼내지 않으면 에러가 난다
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
