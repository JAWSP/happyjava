package day05.expackage.com.example.main;


import day05.expackage.com.example.util.Calculator;

public class ClaculatorTest {
    public static void main(String[] args) {
        Calculator.p();
        Calculator calculator = new Calculator();
        System.out.println(calculator.plus(10, 20));
        System.out.println(calculator.minus(20, 10));
    }

}
