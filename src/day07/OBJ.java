package day07;

import java.util.Objects;

class T {
    int i = 1;

    @Override
    public String toString() {
        return i + ""; //이러면 얜 강제로 String이 되는거시여
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) //만약에 너 자신을 들어왔다면
            return true;
        if (!(o instanceof T t))
            //만약에 그 타입이 내 타입이 아니면/그 타입이 저 타입의 상속이 아니면
            return false;
        return i == t.i; //이후 필드값 비교
    }

}
public class OBJ {
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t);

        t.i = 10;
        T t1 = t;
        t1.i = 20;
        System.out.println(t.i);
        //기존의 t값이 변해서 20으로 된다 ->불변클래스가 아니니까
        /*
        T t2 = new T();
        t2.i = 10;
        if (t.equals(t2))
            System.out.println("같네?");
        else
            System.out.println("틀리네?");
        //같은 건줄 알았는데 다르네
        //왜냐면 주소값만 보거든

        System.out.println(t.hashCode());
        System.out.println(t.hashCode());
         */

    }


}
