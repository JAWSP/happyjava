package day06;

import javax.print.CancelablePrintJob;
//부모가 정의한 값을 자식이 다시 정의 가능함
class Parent {
    int i = 5;
    String message = "Parent";

    public int getI() {
        System.out.println("i is : " + i);
        return i;
    }

    public void showMessage() {
        System.out.println(this.message);
    }
}

class Child extends Parent {
    int i = 10;
    String message = "Child";

    public int getI() {
        return i;
    }

    public void print() {
        System.out.println(i);
    }

    public void showMessage() {
        System.out.println(this.message);
    }
}

public class SangSock2 {

    //메서드 타입 내에선 parent가 된다
    //그리 해서 child라 해도 결구 parent라고 취급 당했기 때문에
    //child형으로 선언된 변수는 저기에 들어가서
    //Parent p = c (Child형) 가 되어버림
    public static  void test(Parent p) {
        System.out.println(p.i);
        System.out.println(p.getI());

        ((Child)p).print();
    }
    public static void main(String[] args) {
        //2. 필드는 오버라이딩 되었을 때 타입을 따른다

        Parent p = new Parent();
        p.showMessage(); //p
       // System.out.println(p.i); //5
       // System.out.println(p.getI()); //5



        Child c = new Child();
        c.showMessage(); //c
        // System.out.println(c.i); //10 ->오버라이딩 되어서 10
        //System.out.println(c.getI()); //5 ->???


        Parent pc = new Child();
        pc.showMessage(); //c
 //       System.out.println(pc.i); //5 -> ???
  //      System.out.println(pc.getI()); //5

        System.out.println("=====================");
      //  test(p); //에러남
      //  test(c);
      //  test(pc);

        //3. 메소드는 오버라이딩되면 무조건 자식 것을 쓴다.
        //->얘가 중요한다던데

        /*
        //상속
        //1. 부모는 자식을 가리킬 수 있다
        //   하지만 자식은 부모를 가리킬 수 없다
        Parent p = null;
        p = new Child();
        Parent pp = new Parent();

        //얜 안됨
       // c = new Parent();
        //단, 명시적으로 형변환이 가능하다
        //근데 이미 가리켜진 인스턴스로는 불가능하다
        c = (Child) p;
        //c = (Child) pp;

         */
    }
}
