package day09;

public class ExEx4 {
    //두부 사는 심부름을 하고 있는데 문제가 발생하면 내가 직접 처리
    public static void buyTofuByMe (int i) {
        int buy[] = {1, 2, 3, 4};
        try {
            buy[i] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("어머 여기는 두부가 모자르네");
        }

    }
    //두부 사는 심부름을 하고 있는데 문제가 발생하면 네가 직접 처리
    public static void buyTofuByYou (int i) throws Exception{
        int buy[] = {1, 2, 3, 4};
        buy[i] = 5;
    }
    public static void main(String[] args) {
        buyTofuByMe(5);
        try {
            buyTofuByYou(5);
        } catch (Exception e) {
            System.out.println("그래? 저기 두부가 모자르다고?");
        }
    }
}
