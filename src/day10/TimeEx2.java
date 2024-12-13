package day10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class TimeEx2 {
    public static void main(String[] args) {
        //걸린 시간은 Duration으로 나온다
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 9);
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toHours());

        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate nowDate = LocalDate.now();
        Period period = Period.between(startDate, nowDate);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}
