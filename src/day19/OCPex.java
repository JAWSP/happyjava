package day19;
//수정은 제한시키고 확장(추가)를 위주로 하게끔 만들어야

interface PaymentMethod {
    void pay(int amount);
}

class CreditCard implements PaymentMethod{
    public void pay(int amount) {
        System.out.println("신용카드로 결제 합니다. : "+ amount);
    }
}

class Paypal implements PaymentMethod {
    @Override
    public void pay(int amount) {
        System.out.println("페이팔로 결제합니다. : "+ amount);
    }
}

class PaymentProcessor {
    public void process(PaymentMethod p, int amount) {
        p.pay(amount);
    }
}
/*
class PaymentProcessor{
    //만약에 새로운 결제 방법 추가되면 또 else if 만들고 또 거기에 대한 처리도 만들
    public void process(String method, int amount){
        if(method.equalsIgnoreCase("CreditCard")){
            System.out.println("신용카드로 결제 합니다. : "+ amount);
        } else if (method.equalsIgnoreCase("paypal")) {
            System.out.println("페이팔로 결제합니다. : "+ amount);
        }else{
            System.out.println("지원하지 않는 결제 방식입니다.");
        }
    }
}
 */

public class OCPex {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.process(new CreditCard(), 100);
        processor.process(new Paypal(), 4000);
        //rocessor.process("creditCard",100);
        //processor.process("paypal",4000);
    }
}
