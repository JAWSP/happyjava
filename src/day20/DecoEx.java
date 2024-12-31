package day20;
//커피 주문할떄
//에스프레소 + 물 = 아메리카노
//에스프레소 + 우유 = 카페라뗴
//에스프레소 + 아이스티 = 아샷추
//몇몇은 이태리인들이 기뻐죽음

//모든 커피의 기본이 되는 공통 인터페이스
//이른바 컴포넌트 인터페이스
interface Coffee {
    String getDesCription(); //커피 설명
    int getCost();
}

//가장 기본적인 커피(에스프레소)구현 - 기본 컴포넌트
class Espresso implements Coffee {

    @Override
    public String getDesCription() {
        return "에스프레소";
    }

    @Override
    public int getCost() {
        return 3000;
    }
}

//저 에스프레소를 메챠쿠챠시킬 장식의 청사진을 구현
// 표준 - 데코레이터 추상
abstract class CoffeeDecorator implements Coffee {
    protected Coffee base;
    //생성자 - 기존 원본을 받아들인다
    public CoffeeDecorator(Coffee coffee) {
        this.base = coffee;
    }

    @Override
    public String getDesCription() {
        return base.getDesCription();
    }

    @Override
    public int getCost() {
        return base.getCost();
    }
}

//본격적으로 장식 클래스 구현 --커피 기능을 확장
class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDesCription() {
        return super.getDesCription() + "거기에 우유를 추가한 라떼임";
    }

    @Override
    public int getCost() {
        return super.getCost() + 500;
    }
}

class IceTea extends CoffeeDecorator {
    public IceTea(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDesCription() {
        return super.getDesCription() + "거기에 아이스티를 끼얹은";
    }

    @Override
    public int getCost() {
        return super.getCost() + 500;
    }
}


public class DecoEx {
    public static void main(String[] args) {
        //기본
        Coffee espresso = new Espresso();
        System.out.println(espresso.getDesCription() +
                " 가격 : " + espresso.getCost());
        //우유 추가
        Coffee latte = new Milk(espresso);
        System.out.println(latte.getDesCription());
        System.out.println(latte.getCost());
        //아이스티 추가
        Coffee ashachu = new IceTea(new Espresso());
        System.out.println(ashachu.getDesCription());
        System.out.println(ashachu.getCost());
        Coffee fusion = new IceTea(new Milk(new Espresso()));
        System.out.println(fusion.getDesCription());
        System.out.println(fusion.getCost());
    }
}
