package com.example.meetingex.controller;

import com.example.meetingex.dto.ErrorResponseDto;
import com.example.meetingex.dto.ParticipantsDto;
import com.example.meetingex.dto.ScheduleDto;
import com.example.meetingex.entity.Schedule;
import com.example.meetingex.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/meetings")
public class ScheduleController {
    private final ScheduleService scheduleService;

    //POST /meetings/{meetingId}/schedules 일정 생성
    @PostMapping("/{meetingId}/schedules")
    private ResponseEntity<?> createSchedule(@RequestBody ScheduleDto scheduleDto,
                                             @RequestHeader("Authorization") String token,
                                             @PathVariable("meetingId") Long meetingId ) {
      if (scheduleService.createSchedule(token,meetingId, scheduleDto) == null)
          return ResponseEntity.status(401).body(new ErrorResponseDto("뭔가 이상함"));
        return ResponseEntity.ok().build();
    }

    //GET /meetings/{meetingId}/schedules 목록 조회
    @GetMapping("/{meetingId}/schedules")
    private ResponseEntity<List<Schedule>> showSchedules(@PathVariable("meetingId") Long meetingId) {
        return ResponseEntity.ok(scheduleService.showSchedules(meetingId));
    }

    //POST /meetings/{meetingId}/schedules/{scheduleId}/join 참가
    @PostMapping("/{meetingId}/schedules/{scheduleId}/join")
    private ResponseEntity<?> joinSchedule(@RequestHeader("Authorization") String token,
                                           @PathVariable("meetingId") Long meetingId,
                                           @PathVariable("scheduleId") Long scheduleId) {
        if (scheduleService.joinSchedule(token, meetingId, scheduleId) == null)
            return ResponseEntity.status(401).body(new ErrorResponseDto("뭔가 이상함"));
        return ResponseEntity.ok().build();
    }

    //DELETE /meetings/{meetingId}/schedules/{scheduleId}/leave 탈퇴
    @DeleteMapping("/{meetingId}/schedules/{scheduleId}/leave")
    private ResponseEntity<?> exitSchedule(@RequestHeader("Authorization") String token,
                                           @PathVariable("meetingId") Long meetingId,
                                           @PathVariable("scheduleId") Long scheduleId) {
        if (scheduleService.exitSchedule(token, meetingId,scheduleId) == null)
            return ResponseEntity.status(401).body(new ErrorResponseDto("뭔가 이상함"));
        return ResponseEntity.ok().build();
    }

    // GET /meetings/{meetingId}/schedules/{scheduleId}/participants 참가자 조회
    @GetMapping("/{meetingId}/schedules/{scheduleId}/participants")
    private ResponseEntity<List<ParticipantsDto>> showParticipants(@PathVariable("meetingId") Long meetingId,
                                                                   @PathVariable("scheduleId") Long scheduleId) {
        return ResponseEntity.ok(scheduleService.showParticipants(meetingId,scheduleId));
    }
}
