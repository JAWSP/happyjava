package com.example.meetingex.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MeetingDto {
    private String name;
    private String description;
    private int maxParticipants;
    private int currentParticipants;
}
