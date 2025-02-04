package jdbc02.dao;

import lombok.*;

//넌 dto느낌?
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
}
