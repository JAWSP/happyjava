package day19;
interface Saram {
    public double howMuch(int price);
}

class Student implements Saram {
    @Override
    public double howMuch(int price) {
        return price * 0.85;
    }
}

class Senior implements Saram {
    @Override
    public double howMuch(int price) {
        return price * 0.85;
    }
}

class Adult implements Saram {
    @Override
    public double howMuch(int price) {
        return price;
    }
}

class BF implements Saram {
    @Override
    public double howMuch(int price) {
        return price * 0.84;
    }
}


class DiscountCalculator {
    public double calculateDiscount(Saram ningen, int price) {
        return ningen.howMuch(price);
    }
}
/*
class DiscountCalculator{
    public double calculateDiscount(String discountType, int price){
        if("student".equalsIgnoreCase(discountType)){
            return price * 0.9;  //학생할인 10%
        } else if ("senior".equalsIgnoreCase(discountType)) {
            return price * 0.85; //15%
        }else{
            return price;
        }
    }
}
 */

public class OCPex2 {
    public static void main(String[] args) {
        Student gupShik = new Student();
        Senior noIn = new Senior();
        Adult a = new Adult();
        DiscountCalculator d = new DiscountCalculator();
        d.calculateDiscount(gupShik, 1000);
        System.out.println("학생 할인 : "+ d.calculateDiscount(gupShik, 1000));

        System.out.println("할인 없음 : "+ d.calculateDiscount(a,2000));

    }
}
