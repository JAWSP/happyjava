package day05.Question;

public class Game {
    public Player[] players;
    public Deck deck;

    public void start() {
        players = new Player[2];

        players[0] = new Player("A");
        players[1] = new Player("B");
        Deck deck = new Deck();

        int i = 0;
        do {
            System.out.print("Round " + (i + 1) + ": ");
            Card x = deck.draw();
            System.out.print(players[0].name + " draws " + x.number + " of " + x.suit + ", ");
            Card y = deck.draw();
            System.out.print(players[1].name + " draws " + y.number + " of " + y.suit);
            if (x.number > y.number) {
                System.out.println(" -> " + players[0].name + " wins!");
                players[0].addScore(1);
            }
            else if (x.number < y.number) {
                System.out.println(" -> " + players[1].name + " wins!");
                players[1].addScore(1);
            }
            else {
                System.out.println(" -> draw");
            }
                i++;
        }while (i < 5);
        System.out.print("Final Score: " + players[0].name + " " + players[0].score + ", ");
        System.out.print(players[1].name + " " + players[1].score);
        if (players[0].score > players[1].score)
            System.out.println(" -> " + players[0].name + " wins!");
        else if (players[0].score < players[1].score)
            System.out.println(" -> " + players[1].name + " wins!");
        else
            System.out.println(" -> draw");

    }

    public static void main(String[] args) {
        Game g = new Game();
        g.start();
    }
}
