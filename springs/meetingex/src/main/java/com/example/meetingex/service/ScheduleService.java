package com.example.meetingex.service;

import com.example.meetingex.dto.ParticipantsDto;
import com.example.meetingex.dto.ScheduleDto;
import com.example.meetingex.entity.Schedule;
import com.example.meetingex.entity.UserSchedule;
import com.example.meetingex.jwt.JwtUtil;
import com.example.meetingex.repository.MeetingRepository;
import com.example.meetingex.repository.ScheduleRepository;
import com.example.meetingex.repository.UserMeetingRepository;
import com.example.meetingex.repository.UserScheduleRepository;
import com.example.meetingex.status.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final MeetingRepository meetingRepository;
    private final UserScheduleRepository userScheduleRepository;
    private final MeetingService meetingService;
    private final JwtUtil jwtUtil;


    //일정 생성(토큰)
    @Transactional
    public String createSchedule(String token, Long meetingId, ScheduleDto scheduleDto) {
        Long userId = jwtUtil.validateToken(token);

        //유저가 뮤효하거나 속해있지 않음 나가리
        if (userId == null || !meetingService.isMember(userId, meetingId) || !meetingRepository.existsById(meetingId))
            return null;
        //자료 넣기
        Schedule schedule = new Schedule();
        schedule.setTitle(scheduleDto.getTitle());
        schedule.setTime(scheduleDto.getTime());
        schedule.setDate(scheduleDto.getDate());
        schedule.setLoaction(scheduleDto.getLocation());
        schedule.setMeeting(meetingRepository.findById(meetingId).get());

        //스케쥴 등록
        scheduleRepository.save(schedule);

        //스케쥴-유저 관계 넣기
        UserSchedule userSchedule = new UserSchedule();
        userSchedule.setSchedule(schedule);
        userSchedule.setUser(meetingService.findUserById(userId));
        userSchedule.setStatus(Status.ATTENDING);
        userScheduleRepository.save(userSchedule);

        return "ok";

    }

    //일정 조회
    @Transactional(readOnly = true)
    public List<Schedule> showSchedules(Long meetingId) {
        return scheduleRepository.findByMeetingId(meetingId);
    }

    //일정 참가(토큰)
    @Transactional
    public String joinSchedule(String token, Long meetingId, Long id) {
        Long userId = jwtUtil.validateToken(token);
        if (userId == null || !meetingService.isMember(userId, meetingId) || !scheduleRepository.existsById(id))
            return null;

        //스케쥴-유저 관계 넣기
        UserSchedule userSchedule = new UserSchedule();
        userSchedule.setSchedule(scheduleRepository.findById(id).get());
        userSchedule.setUser(meetingService.findUserById(userId));
        userSchedule.setStatus(Status.ATTENDING);
        userScheduleRepository.save(userSchedule);
        return "ok";
    }

    //일정 탈퇴(토큰)
    @Transactional
    public String exitSchedule(String token, Long meetingId, Long id) {
        //토큰이 있는지 유저가 속해있는지, 스케쥴이 있는지 확인
        Long userId = jwtUtil.validateToken(token);
        if (userId == null || !meetingService.isMember(userId, meetingId) || !scheduleRepository.existsById(id))
            return null;

        //다 있다면 그 유저를 삭제
        UserSchedule userSchedule = userScheduleRepository.findByScheduleIdAndUserId(id, userId);
        userScheduleRepository.delete(userSchedule);

        return "ok";
    }

    //일정 특정 인원 보기
    @Transactional(readOnly = true)
    public List<ParticipantsDto> showParticipants(Long meetingId, Long id) {
        if (!scheduleRepository.existsById(id))
            return null;
        return userScheduleRepository.findByScheduleId(id).stream()
                .map(m -> new ParticipantsDto(m.getUser().getId(), m.getUser().getEmail()))
                .collect(Collectors.toList());
    }
}
