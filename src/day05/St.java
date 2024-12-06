package day05;

public class St {
    String name;
    static int count = 0;
    //스태틱한 놈들은 인스턴스화 하지 않아도 사용 가능하다
    static public void test() {
        System.out.println("asd");
    }
    public static void main(String[] args) {
        test();

        St s1 = new St();
        St s2 = new St();
        St s3 = new St();

        s1.name = "a";
        s2.name = "ab";
        s3.name = "c";

        System.out.println(s1.name);
        System.out.println(s2.name);
        System.out.println(s3.name);

        //얘넨 값을 공유해
        s1.count = 10;
        s2.count = 20;
        s3.count = 30;

        System.out.println(s1.count); //30
        System.out.println(St.count); //30
    }
}
