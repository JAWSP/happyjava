package day06;

public class Pen {
    private String name;
    private String color;
    private int price;

    public  Pen() {}
    public  Pen(String name) {
        this.name = name;
    }
    public  Pen(String name, String color, int price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getCsolor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
