package com.example.meetingex.service;


import com.example.meetingex.dto.ErrorResponseDto;
import com.example.meetingex.dto.MeetingDto;
import com.example.meetingex.dto.ParticipantsDto;
import com.example.meetingex.entity.Meeting;
import com.example.meetingex.entity.Schedule;
import com.example.meetingex.entity.User;
import com.example.meetingex.entity.UserMeeting;
import com.example.meetingex.jwt.JwtUtil;
import com.example.meetingex.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MeetingService {
    private final UserRepository userRepository;
    private final MeetingRepository meetingRepository;
    private final UserMeetingRepository userMeetingRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserScheduleRepository userScheduleRepository;
    private final JwtUtil jwtUtil;

    public User findUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public boolean isMember(Long userID, Long meetingId) {
        return userMeetingRepository.existsByUserIdAndMeetingId(userID, meetingId);
    }

    public void deleteUserScheduleByMeetingId(Long meetingId) {
        //아이디를 찾고
        List<Schedule> schedules = scheduleRepository.findByMeetingId(meetingId);
        if (schedules == null)
            return;

        for(Schedule s : schedules) {
            //그 아이디에 맞는 u-s를 자른다
            userScheduleRepository.deleteByScheduleId(s.getId());
            //그리고 스케쥴 본체도 자른다
            scheduleRepository.delete(s);
        }
    }


    // 모임 생성
    @Transactional
    public String createMeeting(MeetingDto meetingDto, String token) {

        //일단 만든놈 뽑을려고 토큰을 뽑아낸다
        Long id = jwtUtil.validateToken(token);
        if (id == null)
           return null;

        //미팅을만든다
        Meeting meeting = new Meeting();
        meeting.setName(meetingDto.getName());
        meeting.setDescription(meetingDto.getDescription());
        meeting.setMaxParticipants(meetingDto.getMaxParticipants());
        meeting.setCurrentParticipants(1);
        meetingRepository.save(meeting);

        //모임을 만들었더라면 거기에 인원도 넣어야지
        UserMeeting userMeeting = new UserMeeting();
        userMeeting.setUser(userRepository.findById(id).get());
        userMeeting.setMeeting(meeting);
        userMeeting.setCreator(true);
        userMeetingRepository.save(userMeeting);



        return "ok";
    }

    //모임 조회
    @Transactional(readOnly = true)
    public List<Meeting> findAllMeetings() {
        return meetingRepository.findAll();
    }

    //모임 수정
    //나중에 생성자만 수정 가능하도록
    @Transactional
    public String updateMeeting(MeetingDto meetingDto,String token, Long id) {
        try {
            Long userId = jwtUtil.validateToken(token);
            if (userId == null || !userMeetingRepository.findByUserIdAndMeetingId(userId, id).isCreator())
                throw new Exception("유효하지 않은 유저임");
            if (meetingRepository.existsByName(meetingDto.getName()))
                throw new Exception("중복임");
            Meeting meeting = meetingRepository.findById(id).get();
            meeting.setName(meetingDto.getName());
            meeting.setDescription(meetingDto.getDescription());
            meeting.setMaxParticipants(meetingDto.getMaxParticipants());
            meetingRepository.save(meeting);
        } catch (Exception e) {
            return null;
        }
        return "ok";
    }

    //모임 삭제, 일단 생성자는 배제시킨다
    @Transactional
    public String deleteMeeting(Long id, String token) {
        Long userId = jwtUtil.validateToken(token);
        //유저 요청이 이상하거나 권한이 없다면 나가리
        if (userId == null || !userMeetingRepository.findByUserIdAndMeetingId(userId, id).isCreator())
            return null;

        //만약 스케쥴이 있다면?
        //스케쥴에 참여한 인원을 지우고
        //스케쥴을 지우고
        deleteUserScheduleByMeetingId(id);


        //만약 참여자가 있다면?
        //참여자를 지우고
        userMeetingRepository.deleteByMeetingId(id);


        //최종적으로 미팅을 지우게 만들면 될듯?
        meetingRepository.deleteById(id);
        return "ok";
    }

    //모임 참여
    @Transactional
    public String joinMeeting(Long id, String token) {
        Long userId = jwtUtil.validateToken(token);
        if (userId == null || !meetingRepository.existsById(id))
            return null;
        System.out.println(userId);
        //중복도 방지
        if (userMeetingRepository.existsByUserIdAndMeetingId(userId, id))
            return null;

        Meeting meeting = meetingRepository.findById(id).get();
        //꽉차도 나가리
        if (meeting.getCurrentParticipants() + 1 > meeting.getMaxParticipants())
            return null;
        //이제서야 추가
        meeting.setMaxParticipants(meeting.getCurrentParticipants() + 1);

        //인원넣기
        UserMeeting userMeeting = new UserMeeting();
        userMeeting.setUser(userRepository.findById(userId).get());
        userMeeting.setMeeting(meeting);
        userMeeting.setCreator(false);
        userMeetingRepository.save(userMeeting);
        return "ok";
    }

    //참가자 조회
    @Transactional(readOnly = true)
    public List<ParticipantsDto> showParticipants(Long id) {
        if (!meetingRepository.existsById(id))
            return null;

        return userMeetingRepository.findByMeetingId(id).stream()
                .map(m -> new ParticipantsDto(m.getUser().getId(), m.getUser().getEmail()))
                .collect(Collectors.toList());

    }

    //모임 탈퇴
    @Transactional
    public String exitMeeting(String token, Long meetingId) {
        Long userId = jwtUtil.validateToken(token);
        Meeting meeting = meetingRepository.findById(meetingId).get();
        //아이디가 무효하거나 맴버가 아닌 사람이 나가거나 거기 안의 인원이 한명뿐일경우 나간다
        if (userId == null || isMember(userId, meetingId))
            return null;
        UserMeeting userMeeting = userMeetingRepository.findByUserIdAndMeetingId(userId, meetingId);
        //여기도 중복 부분 있어서 손봐야함

        //암튼 지우는 주체가 생성자라면? -> 편의상 폭파
        //1명뿐이라면 -> 편의상 폭파
        if (userMeeting.isCreator() || meeting.getCurrentParticipants() == 1)
            deleteMeeting(meetingId, token);
        else {
            userMeetingRepository.delete(userMeeting);
        }
        return "ok";
    }

}
