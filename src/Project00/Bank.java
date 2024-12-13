package Project00;

import Project00.Exceptions.BankOperationException;

/*
고객을 등록하고 조회
1. 고객은 배열로
2. 고객을 추가하고 찾느 메서드

 */
public class Bank {
    //고객도 한도치가 있는데, 최대 한도를 정하지 않았음
    Customer[] customers;

    Bank () {
        //대충 고갱님 초기화
        //얘도 간단하게 5개로 합시다
        customers = new Customer[5];
    }
    //얘도 마찬가지로 탈퇴가 없으니
    //
    public void addCustomer (String name) {
        int i = 0;

        try {
            //없을때 까지 찾고
            while (customers[i] != null) {
                i++;
            }
            //꽉찼다면?
            if (i == 5)
                throw new BankOperationException("계좌 꽉참");
            customers[i] = new Customer(i, name);
            System.out.println("your ID is : "+ i + " your NAME is : " + customers[i].name);
        } catch (BankOperationException e) {
            System.out.println(e);
        }

    }
    public Customer findCustomer (String target) {
        int i = 0;
        while (customers[i] != null) {
            if (target.equals(customers[i].name)) {
                return customers[i];
            }
            i++;
        }
        return null;
    }

}
