package day07;

public abstract class Beverage {
    //final 메소드는 오버라이딩이 안된다
    public final void prepareRecipe() {
        bollWater();
        brew();
        pourInCup();
        addCondiments();
    }

    public void bollWater() {
        System.out.println("펄펄펄펄");
    }

    public void pourInCup() {
        System.out.println("쪼로로로록");
    }

    public abstract void brew();

    public abstract void addCondiments();
}
