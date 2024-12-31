package day20;

/*

//대충 이메일 보내는 클래스
class EmailService {
    public void SendEmail(String msg) {
        System.out.println("Email :" + msg);
    }
}

//여기에 SNS를 추가하고 싶다면
class SNSService {
    public void sendSNS(String msg) {
        System.out.println("SNS :" +msg);
    }
}


class MessageSender {
    //여기서 계속 추가가 됨
    //OCP에도 위반되고 있음
    private final EmailService emailService;
    private final SNSService snsService;
    public MessageSender() {
        this.emailService = new EmailService();
        this.snsService = new SNSService();
    }
    public void send(String msg) {
        emailService.SendEmail(msg);
        snsService.sendSNS(msg);
    }
}
//이 상황은 결합도가 높은 상태에 있음
*/
interface MessageService {
    public void sendMessage(String msg);
}
class MessageSender {
    private final MessageService messageService;

    public MessageSender(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send(String msg) {
        messageService.sendMessage(msg);
    }
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String msg) {
        System.out.println("Email :" + msg);
    }
}

class SNSService implements MessageService {

    @Override
    public void sendMessage(String msg) {
        System.out.println("SNS :" +msg);
    }
}

class KakaoService implements MessageService {

    @Override
    public void sendMessage(String msg) {
        System.out.println("KAKAO : " + msg);
    }
}
//추가할때 이렇게 뚝딱 넣어주기만 해도 됨


public class DIPex {
    public static void main(String[] args) {
        /*
        MessageSender sender = new MessageSender();
        sender.send("dkssid");

         */

        MessageSender email = new MessageSender(new EmailService());
        MessageSender sns = new MessageSender(new SNSService());
        email.send("qwed");
        sns.send("qwwqq");

        MessageSender k = new MessageSender(new KakaoService());
        k.send("qqqq");


    }

}
