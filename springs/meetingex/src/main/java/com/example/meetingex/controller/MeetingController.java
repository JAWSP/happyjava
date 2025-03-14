package com.example.meetingex.controller;

import com.example.meetingex.dto.ErrorResponseDto;
import com.example.meetingex.dto.MeetingDto;
import com.example.meetingex.dto.ParticipantsDto;
import com.example.meetingex.entity.Meeting;
import com.example.meetingex.jwt.JwtUtil;
import com.example.meetingex.service.MeetingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/meetings")
@Slf4j
public class MeetingController {
    private final MeetingService meetingService;
    private final JwtUtil jwtUtil;

    //POST /meetings
    @PostMapping("")
    private ResponseEntity<?> createMeeting(@RequestBody MeetingDto meetingDto, @RequestHeader("Authorization") String token) {
//        String token = null;
//        if (bearerToken.startsWith("Bearer ")) {
//            token = bearerToken.substring(7);
//        }

        //여기선 리턴값은 아이디값이 나오게 된다
//        if (jwtUtil.validateToken(token) == null)
//            return ResponseEntity.status(401).body(new ErrorResponseDto("토큰이 이상함"));
        //근데 이거 자꾸 이래야 하나?
        if (meetingService.createMeeting(meetingDto, token) == null)
            return ResponseEntity.status(401).body(new ErrorResponseDto("미팅 생성 실패!"));
        return ResponseEntity.ok().build();
    }

    //GET /meetings
    @GetMapping("")
    private ResponseEntity<List<Meeting>>showAllMeetings() {
        return ResponseEntity.ok(meetingService.findAllMeetings());
    }

    //PUT /meetings/{meetingId}
    @PostMapping("/{meetingId}")
    private ResponseEntity<?>updateMeetings(@RequestBody MeetingDto meetingDto,
                                            @RequestHeader("Authorization") String token,
                                            @PathVariable("meetingId") Long meetingId) {


        if (meetingService.updateMeeting(meetingDto,token, meetingId) == null)
            return ResponseEntity.status(401).body(new ErrorResponseDto("뭔가 이상함"));
        return ResponseEntity.ok().build();
    }

    //DELETE /meetings/{meetingId}
    @DeleteMapping("/{meetingId}")
    private ResponseEntity<?>deleteMeetings(@RequestHeader("Authorization") String token,
                                            @PathVariable("meetingId")Long id) {

        if (meetingService.deleteMeeting(id, token) == null)
            return ResponseEntity.status(401).body(new ErrorResponseDto("토큰이 이상함"));
        return ResponseEntity.ok().build();
    }


    //POST /meetings/{meetingId}/join
    @PostMapping("/{meetingId}/join")
    private ResponseEntity<?>joinMeeting(@RequestHeader("Authorization") String token,@PathVariable("meetingId")Long id){
        if (meetingService.joinMeeting(id, token) == null)
            return ResponseEntity.status(401).body(new ErrorResponseDto("참가가 안됨"));
        return ResponseEntity.ok().build();
    }

    //GET /meetings/{meetingId}/participants
    @GetMapping("/{meetingId}/participants")
    private ResponseEntity<List<ParticipantsDto>>showParticipants(@PathVariable("meetingId")Long id) {
        //여기에 리스트를 추가
        return ResponseEntity.ok(meetingService.showParticipants(id));
    }

    //delete /meetings/{meetingId}/leave
    @DeleteMapping("{meetingId}/leave")
    private ResponseEntity<?> exitMeeting(@RequestHeader("Authorization") String token,
                                          @PathVariable("meetingId")Long id)
    {
        if(meetingService.exitMeeting(token, id) == null)
            return ResponseEntity.status(401).body(new ErrorResponseDto("탈퇴 에러"));
        return ResponseEntity.ok().build();
    }

}
