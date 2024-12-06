package day05.Question;

import day05.lotto.Machine;

public class Dice {
    int sides;

    Dice() {
        sides = 6;
    }

    public int roll() {
        return ((int)(Math.random() * this.sides) + 1);
    }
}
