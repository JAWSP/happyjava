package com.example.meetingex.entity;

import com.example.meetingex.status.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime time;
    @Column(nullable = false)
    private String loaction;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Schedule() {
        date = LocalDate.now();
        time = LocalTime.now();
    }
}


