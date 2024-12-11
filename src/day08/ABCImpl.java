package day08;

interface IT1 {
    int i = 20;
    public void methodA();
    //메소드가 같은게 있어도 어차피 정의가 안되어서 상관없
    public void methodB();
}

interface IT2 {
    int i = 10;
    public void methodB();
}

interface IT3 {
    int i = 30;
    public void methodC();
}
//인터페이스는 다른 인터페이스들을 상속받을 수 있다
interface IT123 extends IT1, IT2, IT3 {

}
//인터페이스는 여러개 상속이 가능하다
public class ABCImpl implements IT1, IT2, IT3{
    @Override
    public void methodA() {
        System.out.println("AA");
    }

    @Override
    public void methodB() {
        System.out.println("BB");
    }

    public void methodC() {
        System.out.println("CC");
    }

    public static void main(String[] args) {
        ABCImpl test = new ABCImpl();
        //System.out.println(test.i); // ?????
        System.out.println(test instanceof IT1);
    }
}
