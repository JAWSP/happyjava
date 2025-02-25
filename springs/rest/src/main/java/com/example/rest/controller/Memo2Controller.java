package com.example.rest.controller;

import com.example.rest.domain.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api2/memos")
@RequiredArgsConstructor
public class Memo2Controller {
    //데이터를 저장할 타입, 그냥 간편한 DB느낌
    private final Map<Long, Memo> memos = new HashMap<>();
    //private final List<Memo> memos = new ArrayList<>();
    //아이디를 매번 받을 수 있는 객체
    private final AtomicLong counter = new AtomicLong();

    //저장(C)
    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody String content) {
        Memo memo = new Memo();
        Long id = counter.incrementAndGet();
        memo.setId(id);
        memo.setContent(content);
        memos.put(id, memo);
        //기존 버전
        //return id;
        //리스폰스 엔티티 버전
        return ResponseEntity.status(201).body(id);
    }

    //보기
    @GetMapping
    public ResponseEntity<Map<Long, Memo>> getMemos() {
        //return memos;
        return ResponseEntity.ok(memos);
    }

    //특정 번호 보기
    @GetMapping("/{id}")
    public ResponseEntity<Memo> getMemo(@PathVariable("id")Long id) {
        Memo memo = memos.get(id);
        if (memo == null) {
            //없으면 에러를
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memo);
        //있으면 그 값을, 없다면 디폴트 벨류를 넣어준다
        //return memos.getOrDefault(id, null);
    }
    //수정
    @PutMapping("/{id}")
    private ResponseEntity<String> updateMemo(@PathVariable("id")Long id, @RequestBody Memo memo) {
        if (!memos.containsKey(id))
            return ResponseEntity.status(404).body("없는댑쇼");
        memo.setId(id);
        memos.replace(id, memo);
        return ResponseEntity.ok().body("수정끝 " + memo.getContent());
    }

    //삭제
    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteMemo(@PathVariable("id")Long id) {
        if (memos.remove(id) == null)
            return ResponseEntity.status(404).body("그게 없는댑쇼");
        return ResponseEntity.ok().body("삭제완");
    }
}
