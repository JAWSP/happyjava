package day10;

public class StaticOuterClass {
    private int outerField = 10;
    public static int publicOuterField = 20;

    public void outerMethod() {
       // StaticInnerClass sic = new StaticInnerClass();

    }
    static class StaticInnerClass {
        public void innerMethod() {
            //static블럭 안에서 static하지 않은 얘들은 접근이 불가하다

            System.out.println(publicOuterField);
        }

        public static void staticInnerMethod() {
            System.out.println("스태틱 너프됨?");
        }
    }

    public static void main(String[] args) {
        //직접 생성 가능하고, 클래스 단위로 접근이 된다
        StaticOuterClass.StaticInnerClass inner = new StaticOuterClass.StaticInnerClass();
        inner.innerMethod();

        //이때, 외부클래스는 인스턴스화 하지 않음
        //인스턴스화 하지 않고 바로 접근할때 스태틱만 접근가능
        StaticOuterClass.StaticInnerClass.staticInnerMethod();
    }
}
