package day20.a;

import day20.b.B;

//만약 A클래스가 b패키지의 B클래스가 필요한다면?
public class A {

//    public void a(B b) {
//        b.b();
//    }

    public void a(InterA interA) {
        interA.conn();
    }
    //이렇게 a가 b에게 의존 하는 것에서 b가 a에게 의존하는 것으로 바뀜
}
