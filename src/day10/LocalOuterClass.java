package day10;

public class LocalOuterClass {
    private int outerField = 10;

    public void outerMethod() {
        //클래스 메소드 내의 클래스 정의 <-이를 로컬내부클래스
        class InnerClass {

            public void innerMethod() {
                System.out.println("outerField : " + outerField);
            }
        }
        InnerClass inner = new InnerClass();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outerMethod();
    }
}
