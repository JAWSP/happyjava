package Project00;



/*
계좌
계좌번호, 고객ID, 잔액이 있음
 */
public class Account {
    int accountNum;
    int customerID;
    int balance;

    Account () {
        this.accountNum = 0;
        this.customerID = 8888;
        this.balance = 0;
    }

    Account(int accountNum, int customerID, int balance) {
        this.accountNum = accountNum;
        this.customerID = customerID;
        this.balance = balance;
        //System.out.println(customerID + " is added@");
    }
    //입금
    public void pushMoney(int money) {
        this.balance += balance;
    }
    //뱉
    public void popMoney(int want) throws InvalidTransactionException {
        if (want > balance)
            throw new InvalidTransactionException("너 돈없잔아");
        System.out.println("F L E X ?");
        this.balance -= balance;
    }

    public int showMeTheMoney() {
        return this.balance;
    }
}
