package day17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectEx {
    public static void main(String[] args) {
        //객체를 파일에 저장 하고 싶을때
        //객체 직렬화를 이용한다
        //  이게 뭐냐면 복잡하게 얽힌 객체를 한줄로 쫙 푼것이라고 하던데
        // 돌아올때도 직렬화를 풀어야 한다고 한다
        Person p = new Person("p", 2);
        try (   //파일을 저장해야 하니 input
                //객체를 써야하니 output
                ObjectOutputStream oos =
                        new ObjectOutputStream(new FileOutputStream("person"));
        ) {
            oos.writeObject(p);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        //파일에서 객체를 읽고 싶다면
        try(
                ObjectInputStream in =
                        new ObjectInputStream(new FileInputStream("person"));
                ) {
            //Object타입으로 리턴이 되기 떄문에 형변환 시켜야 한다
            Person result = (Person) in.readObject();

            System.out.println(result.getAge());
            System.out.println(result.getName());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
