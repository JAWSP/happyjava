package day03;

public class Ex00 {
    //클래스의 가장 기본이 되는 구성요소
    //데이터(속성)을 나타내는 필드
    //속성은 객체지향에서 이리저리 바뀔 수 있기 때문에 private로 쓰임

    private int price;
    private String name;
    //메서드, getter -> private한 속성의 값을 보고 싶을때
    public Ex00(int price, String name) {
        this.price = price;
        this.name = name;
    }
    public  int getPrice() {return price;}
    public  String getName() {return name;}
    public  void setPrice(int price) {this.price = price;}
    public  void setName(String name) {this.name = name;}

    public static void main(String[] args) {
        Ex00[] ex00; //선언
        ex00 = new Ex00[3]; //클래스가 3개 들어있음, 아직안만들어짐, 틀만 만듦

        Ex00 e1 = new Ex00(1000, "dog");
        Ex00 e2 = new Ex00(5000, "cat");
        Ex00 e3 = new Ex00(7000, "thug");

        ex00[0] = e1;
        ex00[1] = e2;
        ex00[2] = e3;

        int total = 0;
        for (int i = 0; i < ex00.length; i++) {
            System.out.println(ex00[i].getName() + " " + ex00[i].getPrice());
            total += ex00[i].getPrice();
        }
        //for each
        for (Ex00 e: ex00)
            System.out.println("price : " + e.getPrice() + " name : " + e.getName());
        System.out.println(total);
    }
}
