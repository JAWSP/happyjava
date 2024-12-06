package day05.Question;

public class Player {
    public String name;
    public int score;

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public void addScore(int points) {
        this.score += points;
    }
}
