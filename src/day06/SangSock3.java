package day06;
class Bird {
    //많은 필드와 메소드가 있다고 가정
    public void song() {
        System.out.println("asd");
    }
}

class Pigeon extends Bird {
    @Override
    public void song() {
        System.out.println("99999999");
    }
}

class Duck extends Bird {
    @Override
    public void song() {
        System.out.println("QUACK");
    }
}
public class SangSock3 {

    public static void main(String[] args) {
        //3. 메소드는 오버라이딩되면 무조건 자식 것을 쓴다.
        Bird b = new Bird();
        Bird b2 = new Pigeon();
        Bird b3 = new Duck();
        b.song();
        b2.song();
        b3.song();
    }
}
