package day20;
//하나만 생성되어야 하는 객체
class Singleton {
    //싱글톤 만드는 법
    //자기 자신을 가리킬 있는 인스턴스를 저장
    private static Singleton singleton;
    // 외부에는 생성할 수 없는 priviate한 생성자를 선언
    private Singleton() {
        System.out.println("나는 모쏠이에요");
    }
    // 자기 자신을 리턴하는 static한 메소드를 정의
    public static Singleton getInstance() {
        if (singleton == null)
            return null;
        return singleton;
    }
}

//싱글톤은 엘 클라시코인가봐
public class SingleTonEx {
    public static void main(String[] args) {

        /*
        //같은 클래스는 여러개의 객체로 만들 수 있긴함
        //하지만 각각의 객체들은 서로 다른 객체임
        Singleton singleton = new Singleton();
        Singleton singleton1 = new Singleton();
        if (singleton1 == singleton)
            System.out.println("같네?");
        else
            System.out.println("틀리네?");
            // 틀리네?
         */
        //하지만 싱글톤으로 하면 어떻게 호출해도 같은 객체가 나옴
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        if (singleton1 == singleton)
            System.out.println("같네?");
        else
            System.out.println("틀리네?"); //같네
    }
}
