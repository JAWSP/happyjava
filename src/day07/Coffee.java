package day07;

public class Coffee extends Beverage{

    @Override
    public void brew() {
        System.out.println("brewinggggg");
    }

    @Override
    public void addCondiments() {
        System.out.println("대충 커피에 얼음 넣는중");
        System.out.println("이탈리아사람들은 오열합니다");
    }
}
