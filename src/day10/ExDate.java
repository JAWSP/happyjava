package day10;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ExDate {
    public static void main(String[] args) {
        //년 월 일을 받기도 함(커스텀)
        Date myBirthday = new Date(1972, 11, 21);
        System.out.println(myBirthday);

        //현재시각을 알고싶으면 디폴트생성자로 됨
        Date now = new Date();
        System.out.println(now);

        //해당 날짜보다 뒤인지 앞인지 true/false로 해주는거
        System.out.println(now.after(myBirthday));

        //Calendar는 추상클래스인데, 인스턴스화 시킬 수 있는 메소드가 있다
        Calendar calendar2 = Calendar.getInstance();
        //혹은
        Calendar calendar = new GregorianCalendar();

        //현재 날짜 출력 get()
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.DATE));
        //월은 00월 부터 시작이라고 한다
        System.out.println(calendar.get(Calendar.MONTH));

        //날짜를 세팅하고 싶다면 set()
        calendar.set(2000, 3,30);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.MONTH));

        //제일 큰 날짜를보고 싶다면 getActualMaxium()
        System.out.println(calendar.getActualMaximum(Calendar.YEAR));
        System.out.println(calendar.getActualMaximum(Calendar.MONTH));

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

    }


}
