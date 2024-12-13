package Project00ex;

import Project00ex.Exceptions.AccountNotFoundException;
import Project00ex.Exceptions.BankOperationException;
import Project00ex.Exceptions.InvalidTransactionException;

import java.util.Scanner;

public class Main {
    //고객등록
    public static void one(Bank bank) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("이름을 입력하시오");
        String input = keyboard.nextLine();
        //이름 중복인가 찾기
        if (bank.findCustomer(input) == null)
            bank.addCustomer(input);
        else
            System.out.println("이름이 중복인데요");
    }
    //계좌생성
    public static void two(Bank bank) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("이름을 입력하시오");
        String name = keyboard.nextLine();
        //고갱님을 찾는다
        Customer target = bank.findCustomer(name);

        try {
            if (target == null)
                throw new AccountNotFoundException("이름이 없는데요");

            System.out.println("원하시는 계좌 번호를 입력하시오");
            int input = keyboard.nextInt();
            System.out.println("입금하실 금액을 입력하시오");
            int balance = keyboard.nextInt();

            Account tmp = new Account(input, target.id, balance);
            //이거 좀 더 이쁘게 가능할 것 같은데...
            target.addAccount(tmp);

        } catch (AccountNotFoundException e) {
            System.out.println(e);
        }
    }
    //입금
    public static void three(Bank bank) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("이름을 입력하시오");
        String name = keyboard.nextLine();
        //고갱님을 찾는다
        Customer target = bank.findCustomer(name);

        try {
            if (target == null)
                throw new AccountNotFoundException("이름이 없는데요");

            System.out.println("계좌 id를 입력해주세요");
            int accountNum = keyboard.nextInt();
            Account a = target.findAccount(accountNum);

            if (a == null)
                throw new BankOperationException("계좌를 못찾았는뎁쇼");

            System.out.println("입금하실 금액을 입력하시오");
            int balance = keyboard.nextInt();
            a.pushMoney(balance);


                //이거 좀 더 이쁘게 가능할 것 같은데...
        } catch (AccountNotFoundException e) {
            System.out.println(e);
        } catch (BankOperationException e) {
            System.out.println("ERROR");
            System.out.println(e);
        }

    }
    //출금
    public static void four(Bank bank) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("이름을 입력하시오");
        String name = keyboard.nextLine();
        //고갱님을 찾는다
        Customer target = bank.findCustomer(name);

        try {
            if (target == null)
                throw new AccountNotFoundException("이름이 없는데요");

            System.out.println("계좌 id를 입력해주세요");
            int accountNum = keyboard.nextInt();
            Account a = target.findAccount(accountNum);

            if (a == null)
                throw new BankOperationException("계좌를 못찾았는뎁쇼");

            System.out.println("출금하실 금액을 입력하시오");
            int balance = keyboard.nextInt();
            a.popMoney(balance);

            //이거 좀 더 이쁘게 가능할 것 같은데...
        } catch (AccountNotFoundException e) {
            System.out.println(e);
        } catch (BankOperationException e) {
            System.out.println("ERROR");
            System.out.println(e);
        } catch (InvalidTransactionException e) {
            System.out.println(e);
        }

    }
    //잔액조회
    public static void five(Bank bank) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("이름을 입력하시오");
        String name = keyboard.nextLine();
        //고갱님을 찾는다
        Customer target = bank.findCustomer(name);

        try {
            if (target == null)
                throw new AccountNotFoundException("이름이 없는데요");

            System.out.println("계좌 id를 입력해주세요");
            int accountNum = keyboard.nextInt();
            Account a = target.findAccount(accountNum);

            if (a == null)
                throw new BankOperationException("계좌를 못찾았는뎁쇼");
            System.out.println("너님의 남은 돈은 : " + a.showMeTheMoney() + "이다");


            //이거 좀 더 이쁘게 가능할 것 같은데...
        } catch (AccountNotFoundException e) {
            System.out.println(e);
        } catch (BankOperationException e) {
            System.out.println("ERROR");
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("⠄⠀⠀⠀⠀⢀⣤⣶⣾⣿⣷⣶⣶⣤⣀⠀⣀⣴⣶⣿⣿⣶⣦⣄⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⢀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀\n" +
                "⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⡀⠀⠀\n" +
                "⠀⣠⣿⣿⣿⠟⠉⠁⠈⠉⠉⠉⠙⠛⢻⣿⣿⣿⣿⣿⣿⠛⠛⠛⠛⠛⠋⠑⠀⠀\n" +
                "⢸⣿⣿⣿⣿⣷⠶⠾⠷⠶⠶⠶⠒⠒⠛⢿⣿⣿⣿⣿⣿⠦⢠⠖⠲⠶⢶⣿⣶⡄\n" +
                "⣼⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⢰⠖⠀⠀⠀   ⣿⣿⣿⡟⠙⠸⡏⠀⠀⠰⠀⣈⣿⠇\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣶⣶⣴⣶⡿⣀⣤⣤⣾⣿⣿⣿⣿⣤⣤⣿⣶⣶⣿⣿⠿⠋⠀\n" +
                "⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀\n" +
                "⣿⣿⣿⣿⣿⡏⣴⣶⣶⣬⠻⣿⣿⣧⣾⣿⣿⣿⣿⣿⣿⣿⠿⠿⢿⣿⣿⣆⠀⠀\n" +
                "⠻⣿⣿⣿⣿⠃⠘⢿⣿⣿⣷⠘⠿⣿⣯⣽⣾⣿⠿⠋⣉⣤⣴⣶⡆⢹⣿⣿⡆⠀\n" +
                "⣀⠽⣿⣿⣿⣷⡆⢸⣿⣿⣿⡇⢀⣀⠀⠀⠈⣀⣴⣾⣿⣿⠿⠛⠁⣈⣉⠛⠁⠀\n" +
                "⣻⣿⣿⣿⣿⡿⠁⣼⣿⣿⣿⠁⣈⣀⣤⣾⣿⣿⠿⠟⠉⣀⣤⣶⣿⠿⠛⠀⠀⠀\n" +
                "⣿⣿⣿⣿⠏⠁⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣶⣶⡄⢹⡿⠟⠋⠁⠀⠀⠀⠀⠀\n" +
                "⣿⣿⣿⣿⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡃⠸⣀⣀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⣿⣿⣿⣿⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣷⡄⠀⠀⠀⠀⠀\n" +
                "부자가 되고 싶은 나는 나에게로...   ⠀⠀⠀⠀⠀\n");
        //대충 이 부분을 루프 블럭으로 묶음
        //그리고 숫자 입력 받아서 그에 따른 뭔가를 행함
        while (true) {
            System.out.println("======== 사자 은행 시스템 ========");
            System.out.println("1. 고객 등록");
            System.out.println("2. 계좌 생성");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 잔액 조회");
            System.out.println("6. 종료");
            int input;
            
            try {
                input = keyboard.nextInt();
            }
            catch (Exception e) {
                System.out.println(e);
                System.out.println("입력오류: 다시입력하셈");
                keyboard.nextLine(); //버퍼 비우기
                continue;
            }

            switch (input) {
                case 1:
                    System.out.println("1");
                    one(bank);
                    break;
                case 2:
                    System.out.println("2");
                    two(bank);
                    break;
                case 3:
                    System.out.println("3");
                    three(bank);
                    break;
                case 4:
                    System.out.println("4");
                    four(bank);
                    break;
                case 5:
                    System.out.println("5");
                    five(bank);
                    break;
                case 6:
                    System.out.println("bye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("1~6 사이의 숫자를 입력하셈");
            }
            keyboard.nextLine();
        }

        //여기까지
    }

}
