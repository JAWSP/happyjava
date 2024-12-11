package day08;

public class Flytest {
    public static void main(String[] args) {
        //인터페이스는 직접 인스턴스화는 안되지만
        //impletments된 클래스는 인스턴스화된다
        //근데 거기서 인터페이스에서 명시된 메소드만가능함
        //날다라는 기능만 아는 놈이 꿀을 어캐빰?
        Flyable flyable = new butterfly();
        flyable.fly();


    }
}
