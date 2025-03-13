package com.example.swaggerexam.Controller;

import com.example.swaggerexam.dto.LoginRequestDto;
import com.example.swaggerexam.dto.RegisterRequestDto;
import com.example.swaggerexam.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "인증 관련 API")
public class AuthController {

    //@Operation는 뭐라 설명할꺼냐 이런거
    @Operation(
            summary = "회원가입",
            description = "여기에 정보입력"
    )
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto requestDto) {
        return ResponseEntity.ok("오키도키오");
    }


    @Operation(
            summary = "로그인",
            description = "여기에 이메일과 비밀번호를 입력",
            tags = {"Authentication"}
    )
    @PostMapping("/login")
    //결과에 따라 다르니 ? 제네릭을
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        //대충 로그인 로직
        return ResponseEntity.ok("대충 로그인 완료");
    }

    //만약에 로그아웃에 뭔가를 넘겨받고 싶을때
    @Operation(
            summary = "로그아웃",
            description = "제곧내"
    )
    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            @Parameter(description = "JWT인증 토큰", required = true, example = "Bearer 대충토큰해시코드....")
            @RequestHeader("Authorization") String token
    ) {
        return ResponseEntity.ok("로갓완료");
    }

    @Operation(summary = "사용자 목록 조회", description = "사용자 목록을 페이지 단위로 조회합니다.")
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
//        List<UserDto> users = userService.getUsers(page, size);
        return ResponseEntity.ok(null);
    }

    @Operation(summary = "사용자 정보 조회", description = "사용자의 고유 ID를 이용하여 정보를 조회합니다.")
    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(
            @PathVariable("id") Long id) {
//        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(null);
    }
}
