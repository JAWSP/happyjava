package day21;

//전략 패턴은 어떤 알고리즘이나 실행패턴을 인터페이스로 분리하고
//그에 따른 유동적인 전략들을 만들어서 구현해보면 됨
interface Strategy {
    void execute();
}

//전략A
class PlanA implements  Strategy {

    @Override
    public void execute() {
        System.out.println("대충 플랜A");
    }
}

//전략B
class PlanB implements Strategy {

    @Override
    public void execute() {
        System.out.println("대충 플랜 B");
    }
}
//삼십육계줄행랑
class Plan36 implements Strategy {

    @Override
    public void execute() {
        System.out.println("도망쳐");
    }
}

//저걸 실행하는 컬라쓰마이
class Ssumai {
    private Strategy strategy;

    public Ssumai() {

    }

    public Ssumai(Strategy s) {
        this.strategy = s;
    }

    public void think(int num) {
        System.out.println("사마의는 고심했음");
        if (num > 300)
            setStrategy(new PlanA());
        else
            setStrategy(new PlanB());
    }

    public void setStrategy(Strategy s) {
        this.strategy = s;
    }

    public void startStrategy() {
        strategy.execute();
    }
}


public class StrategyEx {
    public static void main(String[] args) {
       Ssumai ssumai = new Ssumai(new PlanA());
       ssumai.think(300);
       ssumai.startStrategy();
    }
}
