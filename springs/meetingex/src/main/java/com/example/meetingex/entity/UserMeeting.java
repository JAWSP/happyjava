package com.example.meetingex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//유저에 대해 다대일, 미팅에 대해 다대일, 이 둘은 pk이자 fk

@Entity
@Getter
@Setter
@Table(name = "user_meetings")
@NoArgsConstructor
@AllArgsConstructor
public class UserMeeting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToOne
    @JoinColumn(name ="meeting_id", nullable = false)
    private Meeting meeting;

    @Column(nullable = false)
    private boolean isCreator;


}
