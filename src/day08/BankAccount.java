package day08;

public class BankAccount {
    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public final String getAccountInfo() {
        return "계좌 번호: " + this.accountNumber + ", 잔액: " + this.balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(12214, 211122.22);

        account.deposit(1221);
        System.out.println(account.getAccountInfo());
        account.withdraw(22);
        System.out.println(account.getAccountInfo());
    }
}
