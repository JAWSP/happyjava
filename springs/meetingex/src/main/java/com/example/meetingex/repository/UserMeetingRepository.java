package com.example.meetingex.repository;

import com.example.meetingex.entity.UserMeeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMeetingRepository extends JpaRepository<UserMeeting, Long> {
}
