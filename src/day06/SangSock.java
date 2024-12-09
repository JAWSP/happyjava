package day06;
class Car {
    String name;
    int speed;

    public void drive() {
        System.out.println(this.name + " : 부릉부릉");
    }
}

//버스는 이제 다동차로부터 상속을 받겠다고 extends키워드를 이용한다
class Bus extends Car {

    public void drive() {
        System.out.println(this.name + " : 학생이 아닙니다");
    }

}

//상속의 상속
class TravelBus extends Bus {
    public void drive() {
        System.out.println("관광버스 광란의 뮤직-쑈쑈쑈");
    }
}

class Truck extends Car {
    public void drive() {
        System.out.println(this.name + " : 뿌아아아아아아아아앙");
    }
}
public class SangSock {
    public static void main(String[] args) {
        Car car = new Car();
        car.name = "matiz the GOLD";
        car.speed = 100;

        System.out.println(car.name + " " + car.speed);

        Bus bus = new Bus();
        bus.name = "크샤트리라 버스";
        bus.speed = 8000;

        System.out.println(bus.name + " " + bus.speed);

        bus.drive();
        //bus.getCustomer();
        //자식에만 있는 메소드는 부모가 이용 못함
        //car.getCustomer();

        Truck truck = new Truck();
        //truck.sendEsekai();
        Car c = new TravelBus();
        //얜(자식 객체를 가리키는 부모 타입) 되지만
        TravelBus tt = (TravelBus) c;
        //얜(부모 자신 객체를 가리키는 부모 타입)
        // 서로 충돌이 나서 에러가 뜸
       // TravelBus tt2 = (TravelBus) car;


        Object obj = new TravelBus();
        TravelBus ttt = (TravelBus) obj;

        Car[] cs = new Car[5];

        cs[0] = new Truck();
        cs[1] = new Bus();
        cs[2] = new TravelBus();
        cs[3] = new Bus();
        cs[4] = new Truck();

        for (Car ccc : cs) {
            ccc.drive();
        }
    }
}
