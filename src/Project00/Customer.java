package Project00;
/*
그 계좌를 여러개 들고 있는 고갱님
ID, 이름 계좌들
 */

import java.util.SortedMap;

public class Customer {
    //ID, 이름 계좌들
    int id;
    String name;
    Account[] Accounts = new Account[5];

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }
    Customer() {
        this(9999, "jane doe");
    }

    //어차피 계좌 제거는 없으니 배제한다
    public void addAccount(Account account) {
        int i = 0;

        try {
            //없을때 까지 찾고
             while (Accounts[i] != null) {
                i++;
            }//꽉찼다면?
            if (i == 5)
                throw new BankOperationException("계좌 꽉참");
            Accounts[i] = new Account(account.accountNum, this.id, account.balance);
            System.out.println("@@@계좌 만듦@@@ \nyour Num is : " + Accounts[i].accountNum + " your accound ID : " + Accounts[i].customerID);
            //중복이면
        } catch (BankOperationException e) {
            System.out.println(e);
        }
    }

    //계좌 찾기
    public Account findAccount(int target) {
       int i = 0;
        while (Accounts[i] != null) {
            if (Accounts[i].accountNum == target)
                return Accounts[i];
            i++;
        }
        return null;

    }
}
