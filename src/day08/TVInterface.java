package day08;

import java.security.PublicKey;

public interface TVInterface {

    public void togglePower();

    public void volumeUp();

    public void volumeDown();

    public void channelUp();

    public void channelDown();

    public void setChannel(int channel);

    //오버라이드하라고 만든 메서드
    //기존에 만든 것에다가 추가하고 싶을때 쓰인다
    public default void showBattery() {
        System.out.println("사랑의 밧데리가 다댔나봐여");
    }
    public static void doVoid() {
        System.out.println("ssss");
    }
}
