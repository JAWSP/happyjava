package day20;

//기존 코드나 시스템
class Power220V {
    public void connect() {
        System.out.println("220볼트 입니다");
    }
}

//target 클라이언트가 기대하는 인터페이스
interface Power110v {
    void supply();
}
//저 둘을 아다리 맞게 해주는 돼지코(어댑터 패턴)
class PowerAdapter implements Power110v {
    private Power220V power220V;
    public PowerAdapter(Power220V power220V) {
        this.power220V = power220V;
    }
    @Override
    public void supply() {
        System.out.println("찰칵(대충 어댑터로 220볼트를 110볼트로 바뀌는 소리)");
        power220V.connect();
    }
}// 원본을 훼손 하지 않고 이어지게끔

public class AdapterEx {
    public static void main(String[] args) {
        Power220V hairDryer = new Power220V();
        //110에 어댑터를 이용하여 220에 장착
        Power110v adapter = new PowerAdapter(hairDryer);
        //
        adapter.supply();
    }
}
