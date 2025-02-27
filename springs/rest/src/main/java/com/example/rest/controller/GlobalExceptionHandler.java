package com.example.rest.controller;

import jakarta.xml.bind.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        //에러는 map로 담을거임
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->{
            //어디에서 어떤 에러가 났는지 넣어준다
            errors.put(error.getField(), error.getDefaultMessage());
        } );
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errors);
    }

}
