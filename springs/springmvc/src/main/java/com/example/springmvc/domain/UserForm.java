package com.example.springmvc.domain;

//규칙대로 체크한다?

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    @NotEmpty(message = "username은 공백을 허용안한다 삣삐")
    @Size(min = 5, max = 20, message ="username은 5~20자만 허용한다 삣삐")
    private String username;

    @NotEmpty(message = "passoword는 공백을 허용안한다 삣삐")
    @Size(min = 6, message ="passoword는 6자 이상자만 허용한다 삣삐")
    private String password;
}
