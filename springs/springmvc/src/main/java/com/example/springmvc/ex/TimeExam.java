package com.example.springmvc.ex;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class TimeExam {
    public static void main(String[] args) {
        //날짜
        System.out.println(LocalDate.now());
        //날짜 + 시간
        System.out.println(LocalDateTime.now());

        LocalDate date = LocalDate.of(2025, 1, 1);
        //날짜가 바뀜
        System.out.println(date);
        //100일 추가
        System.out.println(date.plusDays(100));

        //위치에 대한 시간 얻기
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);


        //모든 존을 다 가져온다
        Set<String> allZone = ZoneId.getAvailableZoneIds();
        for (String zoneid : allZone) {
            System.out.println(zoneid);
        }
        //특정 존에 대한 시간을 받아온다
        System.out.println(ZonedDateTime.now(ZoneId.of("Egypt")));
    }
}
