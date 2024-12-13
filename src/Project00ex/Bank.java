package Project00ex;

import Project00ex.Exceptions.BankOperationException;

import java.util.ArrayList;

/*
고객을 등록하고 조회
1. 고객은 배열로
2. 고객을 추가하고 찾느 메서드

 */
public class Bank {
    //고객도 한도치가 있는데, 최대 한도를 정하지 않았음
    ArrayList<Customer> customers;
    static int i;

    Bank () {
        //대충 고갱님 초기화
        //얘도 간단하게 5개로 합시다
        customers = new ArrayList<Customer>();
    }
    //얘도 마찬가지로 탈퇴가 없으니
    public void addCustomer (String name) {

        try {
            //꽉찼다면?
            if (customers.size() > 5)
                throw new BankOperationException("고객 만원");
            customers.add(new Customer(i, name));
            System.out.println("your ID is : "+ i + " your NAME is : " + customers.get(i).name);
            i++;
        } catch (BankOperationException e) {
            System.out.println(e);
        }

    }
    public Customer findCustomer (String target) {
        for (Customer customer : customers) {
            if (target.equals(customers.get(i).name)) {
                return customers.get(i);
            }
        }
        return null;
    }

}
