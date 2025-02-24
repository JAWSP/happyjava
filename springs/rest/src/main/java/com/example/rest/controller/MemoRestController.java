package com.example.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/memos")
public class MemoRestController {
    //얜 그냥 값을 넣는 얘임
    private final Map<Long, String> memos = new HashMap<>();
    //얜 그냥 자동으로 올라가는 숫자인데 스레드로 부터 안전함
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody String content) {
        Long id = counter.incrementAndGet();
        memos.put(id, content);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<Map<Long, String>> getMemos() {
        return ResponseEntity.ok(memos);
    }
}
