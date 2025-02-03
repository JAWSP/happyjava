package com.example.springmvc.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterForm {
        @NotNull(message = "이름은 없을 수 없다 삣삐")
        private String name;
        @Email(message = "이메일 규격을 맞춰라")
        private String email;
}
