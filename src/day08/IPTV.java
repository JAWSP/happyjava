package day08;

public class IPTV implements TVInterface{
    //전원,채널,소리
    private boolean power;
    private int channel;
    private int volume;

    public IPTV() {
        this.power = true;
        this.channel = 1;
        this.volume = 10;
    }
    public IPTV(boolean power, int channel, int volume) {
        System.out.println("1");
        this.power = power;
        this.channel = channel;
        this.volume = volume;
    }

    public IPTV(boolean power, int channel) {
        this(power, channel, 0);
        System.out.println("2");
    }

    public IPTV(boolean power) {
        this(power, 0, 0);
        System.out.println("3");
    }

    public void togglePower(){
        power = !power;
        if(power) {
            System.out.println("IPTV가 켜졌습니다.");
        }else{
            System.out.println("IPTV가 꺼졌습니다.");
        }
    }

    public void volumeUp(){
        if(power) {
            volume++;
            System.out.println("볼륨을 키웁니다." + volume);
        }
    }

    public void volumeDown(){
        volume--;
        System.out.println("볼륨을 줄입니다."+volume);
    }

    public void channelUp(){
        channel++;
        System.out.println("채널이 바뀌었습니다."+channel);
    }
    public void channelDown(){
        channel--;
        System.out.println("채널이 바뀌었습니다."+channel);
    }
    public void setChannel(int channel){
        this.channel = channel;
        System.out.println("채널을 돌립니다."+channel);
    }
}
