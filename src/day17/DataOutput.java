package day17;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutput {
    //기본데이터티입으로 파일에 쓰고 싶은 경우

    //파일에 저장하긴 한데 사람이 읽는게 아닌 시스템이 읽를 목적으로 쓴다고 한다
    //애초에 원시적 타입으로 쓴다고 한다
    public static void main(String[] args) {



        try (
                //파일에 쓰기위해서 fileOutputStream
                //원시타입으로는 DataOutputStream
                //try-resource로 선언해둠
        DataOutputStream dout = new DataOutputStream(new FileOutputStream("asd"));
        ) {

            dout.writeBoolean(true);
            dout.writeByte(Byte.MAX_VALUE);
            dout.writeChar('a');
            dout.writeDouble(3.14);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
