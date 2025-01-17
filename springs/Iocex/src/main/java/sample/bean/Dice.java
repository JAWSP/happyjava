package sample.bean;

import org.springframework.stereotype.Component;

@Component
public class Dice {
    //몇면체?
    private int face;

    public Dice() {
        System.out.println("Dice()");
    }

    public void setFace(int face) {
        this.face = face;
    }

    public Dice (int face) {
        this.face = face;
        System.out.println(this.face+"d1 dice 무보정 랫츠고");
    }

    public int getNumber() {
        return (int)(Math.random() * face) + 1;
    }
}
