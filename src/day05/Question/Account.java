package day05.Question;

public class Account {
    public String accountHolderName;
    public double balance;

    Account (String name) {
        this.accountHolderName = name;
        this.balance = 1000.00;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposit successful!" + "Your new balance is: $" + balance);
    }

    public void withdraw(double amount) {
        if (this.balance < amount)
            System.out.println("너 돈 없잔아");
        else{
            this.balance += amount;
            System.out.println("withdraw successful!" + "Your balance is: $" + balance);
        }
    }
    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }
}
