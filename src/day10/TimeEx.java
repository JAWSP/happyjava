package day10;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

//Date대신 새로 나온 java.time
public class TimeEx {
    public static void main(String[] args) {
        //현재 날짜
        LocalDate date = LocalDate.now();
        System.out.println(date);
        //현재 시간
        LocalTime time = LocalTime.now();
        System.out.println(time);
        //현재 위치시간
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        //포멧팅해서 날짜값 출력
        //내 맘대로 날짜를 설정
        //월은 M, 분은m z는 위치
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");
        System.out.println(now.format(formatter));
        //원하는 지역의 시간을 보고싶다면?
        ZonedDateTime nowInNY = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("한편 뉴욕은... " + nowInNY);

        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(zone -> zone.startsWith("Asia"))
                .sorted()
                .forEach(System.out::println);

    }
}
