package day05;

public class JaPanGi {
    boolean coin;

    JaPanGi() {
        coin = false;
    }

    void insertCoin() {
        coin = true;
    }
    public  String getProductButton(int a) {
        if (this.coin == false)
            return ("돈내놔");
        /*
        if (a == 1)
            return "콜라";
        else if (a == 2)
            return "사이다";
        else if (a == 3)
            return "환타";
        else
            return "솔의 눈";

         */

        switch(a) {
            case 1:
                return "콜라";
            case 2:
                return "사이다";
            case 3:
                return "환타";
            default:
                return "데자와";
        }

    }

    public static void main(String[] args) {
        JaPanGi j = new JaPanGi();
        System.out.println(j.getProductButton(1));
        j.insertCoin();
        System.out.println(j.getProductButton(1));

    }
}
