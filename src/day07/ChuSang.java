package day07;

abstract class Bird {
    private String name;
    private int age;

    public void eat() {
        System.out.println("쩝쩝");
    }
    public void fly() {
        System.out.println("푸드득");
    }

    abstract public void sing();
}

class Pigeon extends Bird {
    //자손 클래스는 반드시 추상메소드를 구현해야한다
    @Override
    public void sing() {
        System.out.println("9999999999");
    }
}

public class ChuSang {
    public static void main(String[] args) {
        //Bird b = new Bird();
        //추상 클래스는 구현부가 없다
        //미완성인 설계도라고
        Pigeon p = new Pigeon();


        Bird b = new Pigeon();

        //추상 클래스는 추상 메소드를 구현하지 않아도
        //자식의 메소드를 구현했기 때문에 구현 가능
        b.sing();

    }

}
