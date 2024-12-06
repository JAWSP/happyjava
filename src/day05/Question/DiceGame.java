package day05.Question;

public class DiceGame {
    Player[] players;
    Dice dice;

    DiceGame(int i) {
        if (i < 2 || i > 4) {
            System.out.println("plz 2~4");
            System.exit(1);
        }
        else {
            players = new Player[i];
            dice = new Dice();
        }
    }
    public void play() {

        int i = 0;
        int score[] = new int[players.length];
        do {
            System.out.println("Round " + (i + 1) + ": ");
            for (int j = 0; j < players.length; j++) {
                score[j] = dice.roll();
                players[j].addScore(score[j]);
                System.out.println(players[j].name + " rolls " + score[j]);

            }
            i++;
        }while (i < 5);
    }

    public void getWinner() {
        System.out.println("Final Scores:");
        int winner[] = {0, 0};
        for (int i = 0; i < players.length - 1; i++) {
            System.out.print(players[i].name + ": " + players[i].score + ", ");
            if (winner[0] < players[i].score) {
                winner[0] = players[i].score;
                winner[1] = i;
            }
        }
        System.out.println(players[players.length - 1].name + ": " + players[players.length - 1].score);
        if (winner[0] < players[players.length - 1].score) {
            winner[0] = players[players.length - 1].score;
            winner[1] = players.length - 1;
        }
        System.out.println("Winner: " + players[winner[1]].name + "!" );




    }

    public static void main(String[] args) {
        DiceGame game = new DiceGame(4);
        game.players[0] = new Player("AAA");
        game.players[1] = new Player("BBB");
        game.players[2] = new Player("CCC");
        game.players[3] = new Player("DDD");

        game.play();
        game.getWinner();
    }
}
