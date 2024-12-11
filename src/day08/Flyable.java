package day08;

//인터페이스는 기능들의 집합

public interface Flyable {
    int A = 10; //final static이 생략됨

    public void fly(); //인터페이스는 추상메소드만 가짐
}

class butterfly implements Flyable{
    public void suckHoney() {
        System.out.println("쪽쪽");
    }
    @Override
    public void fly() {
        System.out.println("나비가 난다요");
    }
    //대충 필드나 메소드 등이 구현되어 있음
}