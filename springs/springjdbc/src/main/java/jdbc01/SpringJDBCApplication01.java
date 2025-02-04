package jdbc01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//간단한 실행파일
//프로젝트 하나하나 만들기 힘드니 패키지째로 만들겠다
//CommandLineRunner는 간단한 테스트를 위한 클래스
@SpringBootApplication
public class SpringJDBCApplication01 implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication01.class);
    }

    //테스트용이라 필드주입
    //저 템플릿이 다 해준다고
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //테스트 할 부분
    @Override
    public void run(String... args) throws Exception {
        //sql를 입력
//        String sql = "INSERT INTO users(name, email) VALUES(?, ?)";
//        int count = jdbcTemplate.update(sql, "asd", "213@as.com");
//        System.out.println(count);

        //현재 User의 필드와 Users 테이블의 컬럼명이 완전히 일치하므로 필요없긴한데
        //두개의 값이 다르다면 이렇게 넣을 수 있다고 한다
//        //객체를 즉석에서 생성한다는거
//        RowMapper<User> rowMapper= new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return new User(
//                        rs.getLong("id"),
//                        rs.getString("name"),
//                        rs.getString("email")
//                );
//            }
//        };
//
//        RowMapper<User> rowMapper1 = new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return new User(
//                        rs.getLong("id"),
//                        rs.getString("name"),
//                        rs.getString("email")
//                );
//            }
//        };

        //쿼리가 실행할때 결과값을 어디에 담아줄건지 알려줘야 한다
        //즉, 1은 명령할 쿼리, 2는 쿼리해서 나온 결과를 담을 그릇(DTO)
        List<User> users = jdbcTemplate.query("SELECT id, name email FROM users", new BeanPropertyRowMapper<>(User.class));

        for (User user : users) {
            System.out.println(user);
        }


    }
}
