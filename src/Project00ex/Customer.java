package Project00ex;
/*
그 계좌를 여러개 들고 있는 고갱님
ID, 이름 계좌들
 */

import Project00ex.Exceptions.BankOperationException;

import java.util.ArrayList;

public class Customer {
    //ID, 이름 계좌들
    int id;
    String name;
    ArrayList<Account> Accounts = new ArrayList<Account>();

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    Customer() {
        this(9999, "jane doe");
    }

    //어차피 계좌 제거는 없으니 배제한다
    public void addAccount(Account account) {
        try {
            //없을때 까지 찾고
            if (Accounts.size() > 5)
                throw new BankOperationException("계좌 꽉참");
            Accounts.add(new Account(account.accountNum, this.id, account.balance));
            System.out.println("@@@계좌 만듦@@@ \nyour Num is : " + Accounts.get(Accounts.size() - 1).accountNum
                    + " your accound ID : " + Accounts.get(Accounts.size() - 1).customerID);
        } catch (BankOperationException e) {
            //중복이면
            System.out.println(e);
        }
    }

    //계좌 찾기
    public Account findAccount(int target) {
       int i = 0;

        for (Account account : Accounts) {
            if (account.accountNum == target)
                return Accounts.get(i);
        }
        return null;

    }
}
