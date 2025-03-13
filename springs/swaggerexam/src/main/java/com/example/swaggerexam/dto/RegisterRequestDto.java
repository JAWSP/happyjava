package com.example.swaggerexam.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterRequestDto {
    @Schema(description = "사용자 이베일", example = "ex@mple.com")
    private String email;

    @Schema(description = "사용자 비밀번호", example = "q1q2w3e4r!")
    private String password;
}
