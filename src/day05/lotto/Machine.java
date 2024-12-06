package day05.lotto;

public class Machine {
    //기계에선 공이 있어야지
    private Ball[] balls;

    //나는 공을 딱 45개로 하고 싶다 ->그럼 생성자에 확실하게 하세오
    public Machine() {
        balls = new Ball[45]; //공 객체를 할당
        for (int i = 0; i < balls.length; i++)
            balls[i] = new Ball(i + 1); //공 객체안의 공번호를 할당
    }

    public void ballSwap(int x, int y) {
        Ball tmp = balls[x];

        balls[x] = balls[y];
        balls[y] = tmp;
    }
    //공 섞어야지
    //랜덤으로 숫자 뽑고, 그렇게 뽑은 번호로 인덱스 뽑기
    public void mix() {
        int i = 0;
        while (i < 100) {
            int x = (int)(Math.random() * balls.length);
            int y = (int)(Math.random() * balls.length);
            ballSwap(x, y);
            i++;
        }
    }

    //중복 방지
    //그냥 섞었으니 처음부터 순서대로 해도 되는데
    //이렇게 다시 섞어서 뽑아도 됨
    public Ball pullBall() {
        Ball ball;
        int idx;

        do {
            idx = (int)(Math.random() * balls.length);
            ball = balls[idx];

        }while (ball == null);
        balls[idx] = null; //공 뽑았으니 없어진다
        System.out.println("이번 번호는 " + ball.number + " 입니다!");

        return ball;
    }


}
