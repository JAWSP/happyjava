package day04;

import java.util.Random;
//예시 클래스들을 만들어 봅시다
class  TV {
    boolean power;
    String brand;
    int channel;
    int volume;

    TV() {
        power = true;
        brand = "samsung";
        channel = 1;
        volume = 10;
    }

    void TurnOff () {
        this.power = false;
    }
    void TurnOn () {
        this.power = true;
    }

    void ChangeChannel(int change) {
        if (power == true)
            System.out.println("TV키시오");
        else
            this.channel = change;
    }

    void UpVolume() {
        if (power == true)
            System.out.println("TV키시오");
        else
            this.volume++;
    }

    void DownVolume() {
        if (power == true)
            System.out.println("TV키시오");
        else
            this.volume--;
    }

}
//주사위를 만들자
//20d1 무보정 대성공 렛츠고
public class Dice {
    //면
    int face;
    //눈
    int eye;
    Dice() {
        this.face = 20;
        this.eye = 20;
    }
    //행위
    public void roll() {
   //     Random random = new Random();
   //     Random.nextInt(수)
        // Math 는 0.0~1.0 사이만 알려주기 때문에 원하는 범위를 알고싶으면
        // 곱해서 0.0 ~ 원하는 수가 나옴
        //하지만 1부터 원하기 때문에 더해준다
        this.eye = (int)(Math.random() * face) + 1;
        System.out.println(this.eye);
    }

    public static void main(String[] args) {
        Dice d = new Dice();
        d.roll();
        d.face = 6;
        d.roll();
    }

}
