package day08;

import java.io.File;

interface Printer {
    void print(String message);
}

class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}

interface Movable {
    void move(int x, int y);
}

interface Drawable {
    void draw();
}

class GameObject implements Movable, Drawable {

    int x = 0;
    int y = 0;
    @Override
    public void draw() {
        System.out.println("객체가 (" + x + ","+y+")에 그려졌습니다");
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

interface  Calculator {
    int add(int a, int b);
    int subtract(int a, int b);
}

class  BasicCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
}

class AdvancedCalculator extends BasicCalculator{
    public int multiply(int a, int b) {
        return a * b;
    }
}

interface Attackable {
    void attack();
}

class SwordAttack implements Attackable {
    @Override
    public void attack() {
        System.out.println("허공난무~");
    }
}

class BowAttack implements Attackable {

    @Override
    public void attack() {
        System.out.println("마 이게 활이여");
    }
}

class Charactoer {
    Attackable attackStragey;

    public void setAttackStragey (Attackable strategy) {
        this.attackStragey = strategy;
    }
    public void performAttack() {
        attackStragey.attack();
    }
}

interface Readable {
    String readContent();
}

interface Writable {
    void writeContent(String content);
}

//interface는 implement할 수 없나보네
interface ReadWritable extends Readable, Writable {
}

class FileHandler implements ReadWritable {

    @Override
    public String readContent() {
        return "파일에서 내용을 읽습니다";
    }

    @Override
    public void writeContent(String content) {
        System.out.println("파일에 내용을 썼습니다.");
    }
}

public class Question {
    public static void main(String[] args) {
        Printer p = new ConsolePrinter();
        p.print("1");
        GameObject g = new GameObject();
        g.move(22, 213);
        g.draw();
        Calculator ad = new AdvancedCalculator();
        AdvancedCalculator adc = new AdvancedCalculator();

        System.out.println(ad.subtract(10,5 ));
        System.out.println(adc.multiply(10, 5));

        //System.out.println(ad.multiply(10, 5)); implement가 아닌 증손자꺼는 못하나보네
        //넣는건 되는데, 거기서 있던 얘는 못보나보네

        Charactoer ch = new Charactoer();
        Attackable sword = new SwordAttack();
        Attackable bow = new BowAttack();
        ch.setAttackStragey(sword);
        ch.performAttack();
        ch.setAttackStragey(bow);
        ch.performAttack();

        ReadWritable rw = new FileHandler();

        rw.writeContent("asassasa");
        rw.readContent();


    }

}
