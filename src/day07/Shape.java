package day07;

abstract public class Shape {
    protected String color;

    public Shape () {
        this.color = "black";
        System.out.println("Shape hi");
    }
    public Shape (String color) {
        this.color = color;
    }
    //어느 도형이든 면적을 계산하는 기능은 반드시 필요함
    public abstract double getArray();
}
