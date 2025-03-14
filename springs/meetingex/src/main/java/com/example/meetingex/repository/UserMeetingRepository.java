package com.example.meetingex.repository;

import com.example.meetingex.dto.ParticipantsDto;
import com.example.meetingex.entity.UserMeeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMeetingRepository extends JpaRepository<UserMeeting, Long> {

    //생각 안나서 일단은 하드코딩
//    @Query("SELECT m FROM UserMeeting m WHERE m.id = :id")
//    List<UserMeeting> selectUMs(@Param("id")Long id);

    //all안쓰고 그냥 find해도 여러개가 조회되네
    List<UserMeeting> findByMeetingId(Long id);

    //특정 미팅id를 기준으로 기록 지우기
    void deleteByMeetingId(Long id);

    UserMeeting findByUserIdAndMeetingId(Long UserId, Long MeetingId);

    boolean existsByUserIdAndMeetingId(Long UserId, Long MeetingId);
}
