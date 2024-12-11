package day08;

import day08.TV;

public class TVUser {
    public static void main(String[] args) {

        //TVInterface tv = new TV();
        //대충 쓰다가 바꾸고 싶으면 아래로만 바꿈 됨
        TVInterface tv = new IPTV();

        tv.channelUp();
        TVInterface.doVoid();// static는 클래스 영역에서 실행
        tv.showBattery();

    }
}
