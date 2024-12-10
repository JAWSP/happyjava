package day07;

public class Circle extends Shape{
    int radius;

    Circle () {
        super();
        this.radius = 5;
        System.out.println("Circle hi");
    }

    Circle (String color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArray() {
        return radius * radius * 3.14;
    }

    public static void main(String[] args) {
        Circle c = new Circle();

        System.out.println(c.getArray());

    }
}
