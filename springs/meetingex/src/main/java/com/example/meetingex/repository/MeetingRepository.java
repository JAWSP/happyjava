package com.example.meetingex.repository;

import com.example.meetingex.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    boolean existsByName(String name);
}
