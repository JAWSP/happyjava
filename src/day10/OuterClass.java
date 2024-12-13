package day10;

public class OuterClass {

    private int outerField = 10;

    private InClass inClass;

    public void outerMethod() {
        InClass in = new InClass();
        in.innerMethod();
    }
    //class안의 class는 public붙여도 되네
    public class InClass {
        public void innerMethod() {
            //어차피 한가족이라 내부클래스가 외부 클래스에 접근 가능
            System.out.println("outerField " + outerField);
        }
    }

    public static void main(String[] args) {
        OuterClass outerclass = new OuterClass();
        outerclass.outerMethod();
    }
}
