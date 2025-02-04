package jdbc02.dao;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeptDTO {
    private Long id;
    private int dept_no;
    private String dept_name;
    private String location;
}
