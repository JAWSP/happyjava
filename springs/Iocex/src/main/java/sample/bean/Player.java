package sample.bean;

import org.springframework.stereotype.Component;

import java.security.PublicKey;

//의존성 주입?
@Component
public class Player {
    private String name;
    //여기서 바로 선언하는게 2. 필드를 이용한 주입
    private Dice dice; //실행할때 주사위를 주입받을거임

    //DI 컨테이너를 통해 주입받는 방법
    //3가지(생성자, setter, 필드)
    //이는 각각 생성자, setter, 필드가 있어야 생성이 됨

    //디폴트
    public Player() {
        System.out.println("player()");
    }

    public Player(Dice dice) {
        System.out.println("player with dice");
        this.dice = dice;
    }


    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println(name + "무보정으로 굴림 " + dice.getNumber());
    }

}
