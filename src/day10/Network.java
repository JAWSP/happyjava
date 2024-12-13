package day10;

public class Network {
    public static int totalMessages;

    public static class MessageNetwork {
        private String content;

        public void Message(String msg) {
            this.content = msg;
            totalMessages++;
        }

        public void SendMessage() {
            System.out.println("MSG : " + this.content);
            System.out.println("Total : " + totalMessages);
        }

    }
    public static int showTotalMessages() {
        return totalMessages;
    }

    public static void main(String[] args) {
        MessageNetwork msg1 = new Network.MessageNetwork();
        MessageNetwork msg2 = new Network.MessageNetwork();

        msg1.Message("hi");
        msg1.SendMessage();
        msg2.Message("hello");
        msg2.SendMessage();

        System.out.println(Network.showTotalMessages());


    }
}
