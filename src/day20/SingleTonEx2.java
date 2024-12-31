package day20;
class Logger {
    //자기 자신을 가리키는 객체생성
    private static Logger instance;
    private Logger() {
        System.out.println("나는 모태모태쏠로 야야야야");
    }
    //선언 하고 나서야 초기화 하는 레이지싱글톤 입니다
    public static synchronized Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    public void log(String msg) {
        System.out.println("[로그] : " + msg);
    }

}
public class SingleTonEx2 {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("나는 스타워즈 로그원");
        Logger logger2 = Logger.getInstance();
        logger2.log("그럼 로그투는 뭔데?");

        System.out.println("그래서 저 로그끼리는 같음? + " + (logger1 == logger2));

    }
}
