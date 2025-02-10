package springjavajdbc01;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//DTO 단순하게 값만 담아서 전달되는 객체
//엔티티 -> DTO의 역할도 하지만 DB와 객체 간의 관계를 알려주는 역할도 한다

//users테이블에 속해있다는 것이다는거
@Table("users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    //@Id는 나는 id요라는걸 알려줌
    @Id
    private Long id;
    private String name;
    private String email;

    //프라이머리 키를 제외한 2가지를 생성
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
