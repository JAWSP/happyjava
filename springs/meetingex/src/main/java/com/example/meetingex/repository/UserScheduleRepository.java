package com.example.meetingex.repository;

import com.example.meetingex.entity.Schedule;
import com.example.meetingex.entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {
    boolean existsById(Long id);
    UserSchedule findByScheduleIdAndUserId(Long scheduleId, Long userId);
    List<UserSchedule> findByScheduleId(Long id);
    void deleteByScheduleId(Long scheduleId);
}
