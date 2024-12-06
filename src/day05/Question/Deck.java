package day05.Question;

import day05.lotto.Ball;

public class Deck {
    Card[] cards = new Card[52];

    public Deck() {
        int indx = 0;
        String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards[indx] = new Card(i + 1, suits[j]);
                indx++;
            }
        }
    }

    public void shuffle() {
        int i = 0;
        while (i < 200) {
            int x = (int)(Math.random() * cards.length);
            int y = (int)(Math.random() * cards.length);
            Card tmp = cards[x];

            cards[x] = cards[y];
            cards[y] = tmp;
            i++;
        }
    }

    public Card draw() {
        Card card;
        int idx;

        do {
            idx = (int)(Math.random() * cards.length);
            card = cards[idx];

        }while (card == null);
        cards[idx] = null;
        //System.out.println("이번 번호는 " + card.number + " 입니다!");

        return card;
    }
}
