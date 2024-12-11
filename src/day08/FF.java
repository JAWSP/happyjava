package day08;

public class FF {
    //상수는 선언과 동시에 정의를 해야 함
    private final String madeBy = "모나미";
    private String name;


    private FF () {
        System.out.println("FFFF");
    } //심지어 요렇게 하면 상속자가 디폴트 생성자를 못만듦

    public final void fm() {
        System.out.println("하하 나를 바꿀수 없으셈 ㅋㅋㅋㅋㅋㅋ");
    }

    public static void main(String[] args) {
        FF f = new FF();
        f.fm();

    }
}
