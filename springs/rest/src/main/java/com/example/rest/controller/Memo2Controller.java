package com.example.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api2/menos")
@RequiredArgsConstructor
public class Memo2Controller {
    //데이터를 저장할 타입, 그냥 간편한 DB느낌
    private final Map<Long, String> memos = new HashMap<>();
    //아이디를 매번 받을 수 있는 객체
    private final AtomicLong counter = new AtomicLong();

    //저장(C)
    @PostMapping
    public Long createMemo(@RequestBody String content) {
        Long id =counter.incrementAndGet();
        memos.put(id, content);
        return id;
    }
}
