package com.example.meetingex.service;


import com.example.meetingex.dto.ErrorResponseDto;
import com.example.meetingex.dto.MeetingDto;
import com.example.meetingex.entity.Meeting;
import com.example.meetingex.entity.UserMeeting;
import com.example.meetingex.jwt.JwtUtil;
import com.example.meetingex.repository.MeetingRepository;
import com.example.meetingex.repository.UserMeetingRepository;
import com.example.meetingex.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MeetingService {
    private final UserRepository userRepository;
    private final MeetingRepository meetingRepository;
    private final UserMeetingRepository userMeetingRepository;
    private final JwtUtil jwtUtil;

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
    public String updateMeeting(MeetingDto meetingDto, Long id) {
        try {
            if (meetingRepository.existsByName(meetingDto.getName()))
                throw new Exception("중복임");
            Meeting meeting = meetingRepository.findById(id).get();
            meeting.setName(meetingDto.getName());
            meeting.setDescription(meetingDto.getDescription());
            meeting.setMaxParticipants(meetingDto.getMaxParticipants());
            meetingRepository.save(meeting);
            log.info("떴냐???@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@{}", meeting.getCurrentParticipants());
        } catch (Exception e) {
            return null;
        }
        return "ok";
    }

    //모임 삭제, 일단 생성자는 배제시킨다
    @Transactional
    public void deleteMeeting(Long id) {
        //만약 스케쥴이 있다면?
        //스케쥴에 참여한 인원을 지우고
        //스케쥴을 지우고

        //만약 참여자가 있다면?
        //참여자를 지우고


        //최종적으로 미팅을 지우게 만들면 될듯?
        meetingRepository.deleteById(id);
    }

    //모임 참여
    @Transactional
    public String joinMeeting(Long id, String token) {
        Long userId = jwtUtil.validateToken(token);
        if (userId == null || !meetingRepository.existsById(id))
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

}
