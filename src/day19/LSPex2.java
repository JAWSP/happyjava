package day19;

//이렇게 쌩으로 상속받기에는 부모가 쓰던걸 한개도 안쓰게됨
//그래서 추상클래스나 인터페이스를 써야 한다

abstract class Vechicle {
    //차와 전기차가 가져야 하는 일반적인 속성이나 기능들을 구현

    //얘만 추상 클래스로
    abstract public void drive();
}

class Car {
    private int fuel;

    public Car(int fuel) {
        this.fuel = fuel;
    }

    public void drive() {
        //연료가 있다면 소비해서 운전
        if (fuel > 0) {
            fuel--;
            System.out.println("뿌아아앙");
            System.out.println("남은 연료 : " + fuel);
        }
        else
            System.out.println("연료가 없는뎁쇼");
    }
}

//Car를 상속받는 EletricCar
//전기차는 연료 대신에 밧데리가 소모되니까 그거 맞게 수정해보소
//LSP... 아시죠...?
//근데 그냥 상속받기 빡세지..?
class ElectricCar extends Car {
    int battery;

    public ElectricCar (int fuel) {
        //전기차는 연료를 안쓴다
        super(0);
        this.battery = fuel;
    }

    public void drive() {
        //밧데리가 있다면 소비해서 운전
        if (battery > 0) {
            battery--;
            System.out.println("위이이이잉");
            System.out.println("남은 연료 : " + battery);
        }
        else
            System.out.println("차량의 밧데리가 다됐나봐요");
    }

    public void charge(int plus) {
        this.battery += plus;
        System.out.println("밧데리 충잔됨 : " + battery);
    }
}

public class LSPex2 {
    public static void main(String[] args) {
        Car ec = new ElectricCar(2);
        ec.drive();
    }


}
