package day20;

//객체의 상태가 변하면 옵저버에게 자동으로 알려주는 디자인 패턴
//유튜브 구독서비스

import java.util.ArrayList;
import java.util.List;

//1. 옵저버 인터페이스(기본 골자)
interface Observer {
    void update(String message);

}

//2. 주제 인터페이스(subject)
interface Subject {
    //관찰자 등록
    void registerObserver(Observer observer);
    //관찰자 제거
    void removeObserver(Observer observer);
    //관찰자에게 알림
    void notifyObserver();
}

//3. 주제를 구현하는 클렛
class YoutubeChennel implements Subject {
    private String channelName;
    private List<Observer> observers; //구독자들의 리스트?

    public YoutubeChennel(String channelName) {
        this.channelName = channelName;
        observers = new ArrayList<>();
    }

    //구독자 추가
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    //구독자 삭제
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    //대충 구독자들에게 알림을 올려줌
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            System.out.println();
            observer.update(channelName + ": 새로운 영상이 업로드 됨");
        }
    }

    //새로운 영상이 업로드 할떄
    public void uploadVideo() {
        System.out.println("야! 업로드 했다");
        notifyObserver();
    }
}

//4. 구체적인 옵저버 클래스 구현
//이른바 구독자(우리들)
class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(this.name +"님, 알람방구 : " + message);
    }
}

public class ObserverEx {
    public static void main(String[] args) {
        //유튜브 채널 만들기
        YoutubeChennel chennel = new YoutubeChennel("asd");

        Subscriber subscriber1 = new Subscriber("a");
        Subscriber subscriber2 = new Subscriber("b");
        Subscriber subscriber3 = new Subscriber("c");
        Subscriber subscriber4 = new Subscriber("d");

        chennel.registerObserver(subscriber1);
        chennel.registerObserver(subscriber2);
        chennel.registerObserver(subscriber3);
        chennel.registerObserver(subscriber4);

        chennel.uploadVideo();
    }
}
