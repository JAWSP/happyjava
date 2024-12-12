package day09;

public class BankMain {
    public static void main(String[] args) {
        AccountEx tongJang = new AccountEx();

        tongJang.balance = 100;

        try {
            tongJang.popMoney(500);
        } catch (BankException e) {
            System.out.println(e.getMessage());
        }
    }
}
