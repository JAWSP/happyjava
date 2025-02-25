package com.example.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

//일종의 컨트롤러 보조 같은거
@ControllerAdvice
public class GlobalExceptionHandler {
    //런타임 예외일때 시행하는 핸들러함수임을 명시
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRunTimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("대충 에러남");
    }

    //이렇게도 가능
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handlerResponseStatusException(ResponseStatusException e) {
        return ResponseEntity.status(e.getStatusCode()).body("이것도 에러임" + e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("허접~");
    }
}
