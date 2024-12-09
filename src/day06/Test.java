package day06;

class Shape {
    int x;
    int y;

    Shape (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw () {
        System.out.println("도형을 그립니다.");
    }
}

class Circle extends Shape {
    Circle() {
        super(0, 0);
    }
    @Override
    public void draw () {
        System.out.println("원을 그립니다.");
    }

}

class Rectangle extends Shape {
    Rectangle() {
        super(0, 0);
    }
    @Override
    public void draw () {
        System.out.println("사각형을 그립니다.");
    }

}

public class Test {
    public static void main(String[] args) {
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        s1.draw();
        s2.draw();
    }
}
