package com.example.friendapp.domain;

import lombok.*;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.data.annotation.Id;

//E뭐시기는 비교하기 위한거
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Friend {
    //스프링 데이타 제디비씨
    @Id
    private long id;
    private String name;
    private String email;
}
