package day05.lotto;

public class Main {
    public static void main(String[] args) {
        Machine lotto = new Machine();

        lotto.mix();
        for (int i = 0; i < 6; i++)
            lotto.pullBall();

    }
}
