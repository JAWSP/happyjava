package day04;

import java.security.PrivateKey;

class dog {
    private String name;
    private String species;
    private String sex;
    private String weight;
    private boolean hungry;
    private int age;

    public void 짓기() {
        System.out.println("name:" + "멍멍");
    }

    public void 먹기() {
        System.out.println("사료 더주셈");
        this.hungry = true;
        this.weight += 100;
    }
}


class Pen {
    private String name;
    private String color;
    private String brand;
    private int price;

    public void write_pen(String msg) {
        System.out.println(msg);
    }

    public void OpenPen(){
        //대충 뚜껑 여는 기능
    }
}

public class GackClass {
    public static void main(String[] args) {
        Pen p = new Pen();
        //new는 클래스(설계도)인 pen클래스를 실체로 만들 수있다. 만들어진 실체를 인스턴스
        //그렇게 만들어진 펜의 인스턴스 명은 p

        //p는 레퍼런스 변수이다
        //int i와 비스므리한
        p.write_pen("마 이게 펜을 쓴거다");
    }
}
