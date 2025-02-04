package jdbc01;

import lombok.*;

//값을 꺼낼 getter
//모든 인자를 담는 생성자, 디폴트 생성자
//Tostring까지 톰켓으로 생성
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long id;
    private String name;
    private String email;
}
