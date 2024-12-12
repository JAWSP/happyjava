package day09;

public class AccountEx {
    public int balance;
    //넣
    public void pushtMoney(int money) {
        this.balance += balance;
    }
    //뱉
    public void popMoney(int want) throws BankException {
        if (want > balance)
            throw new BankException("너 돈없잔아");
        this.balance -= balance;
    }
}
