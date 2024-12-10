package day07;

import day05.lotto.Ball;

import java.util.Objects;

class Pen {
    String color = "red";
    @Override
    public String toString() {
        return "나는 팬입니다";
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Pen pen)) return false;

        return Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }
}

class BallPen extends Pen {
    String color = "black";
    @Override
    public String toString() {
        return "팬이에요 소통해요";
    }

}

class Cup extends Object {
    String name = "컵";
    int price = 2;

    //오버라이딩 하지 않으면 그냥 출력됨
    @Override
    public String toString() {
        return "Cup{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class EXEX {
    public static void test (Object obj) {
        if (obj instanceof  Pen)
            System.out.println("yeah");
    }

    public static void main(String[] args) {
        BallPen p = new BallPen();
        test(p);
        Pen pen = new Pen();

        Cup cup = new Cup();

        System.out.println(cup);
        System.out.println(cup.toString());

        System.out.println(p);
        System.out.println(pen);
    }
}
