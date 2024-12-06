package day05.Question;

import java.security.PublicKey;
import java.util.Scanner;

public class ATM {
    Account[] accounts;


    public ATM(int i) {
        accounts = new Account[i];
    }
    //이름 찾기
    public int selectAccount(String name) {
        for (int i = 0; i < accounts.length; i++)
            if (name == accounts[i].accountHolderName)
                return i;
        return -1;
    }
    //시작
    public void performTransaction() {
        Scanner keyboard = new Scanner(System.in);

        String inp = keyboard.nextLine();
        int num = selectAccount(inp);
        if (num < 0)
            System.exit(0);

        while (true) {
            System.out.println("Welcome to the ATM!\n 1. Check Balance\n 2. Deposit Money\n 3. Withdraw Money\n 4. Exit");
            System.out.print("Choose an option: ");
            int input = keyboard.nextInt();
            switch (input) {
                case 1:
                    accounts[num].checkBalance();
                case 2:
                    accounts[num].deposit(100);
                case 3:
                    accounts[num].withdraw(100);
                case 4: {
                    System.exit(0);
                }

            }
        }

    }

    public static void main(String[] args) {
        ATM atm = new ATM(1);
        atm.accounts[0] = new Account("AA");

        atm.performTransaction();
    }
}
