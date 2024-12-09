package day06;

class BankAccount {
    private int balance;

    BankAccount() {
        this.balance = 100;
    }

    BankAccount(int balance) {
        this.balance = balance;
    }
    public int showBalance() {
        return this.balance;
    }
}

class SavingsAccount extends BankAccount {
    private int interestRate;

    SavingsAccount() {
       this.interestRate = 300;
    }
    @Override
    public int showBalance() {
        return this.interestRate;
    }
}

class  CheckingAccount extends BankAccount {
    private  int overdraftLimit;

    CheckingAccount() {
        this.overdraftLimit = 500;
    }
    @Override
    public int showBalance() {
        return this.overdraftLimit;
    }
}

public class Question {

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount();
        CheckingAccount ca = new CheckingAccount();

        System.out.println(sa.showBalance());
        System.out.println(ca.showBalance());
    }
}
