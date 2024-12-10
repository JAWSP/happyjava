package day07;

public class Triangle extends Shape{
    double height;
    double len;

    Triangle() {
        super();
        this.len = 5;
        this.height = 7;
        System.out.println("triangle hi");
    }

    Triangle (String color, double height, double len) {
        super(color);
        this.height = height;
        this.len = len;
    }

    @Override
    public double getArray() {
        return height * len / 2;
    }

    public static void main(String[] args) {
        Shape s = new Triangle();

        System.out.println(s.getArray());
    }
}
