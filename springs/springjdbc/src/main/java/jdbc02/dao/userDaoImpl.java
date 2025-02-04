package jdbc02.dao;

import jdbc02.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//요 어노테이션은 final에만 생성자를 만든다고 한다
@RequiredArgsConstructor
@Repository
public class userDaoImpl implements UserDao{
    private final JdbcTemplate jdbcTemplate;

//    JdbcTemplate jdbcTemplate;
//    //생성자 주입
//    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users(name, email) VALUES(?, ?)";
        try {
            jdbcTemplate.update(sql, user.getName(), user.getEmail());
        } catch (DataAccessException e) {
            //얜 순수 추상이라서 인스턴스화가 안되니 뒤에 {}를 붙여준다
            throw new DataAccessException("값이 이상해요" + user.getName(), e) {};
        }
    }

    @Override
    public List<User> findUsers() {
        List<User> users = jdbcTemplate.query("SELECT name, email FROM users",
                new BeanPropertyRowMapper<>(User.class));

        return users;
    }

    @Override
    public void updateUserEmail(String name, String email) {
        String sql = "UPDATE users SET email=? WHERE name=?";
       int res= jdbcTemplate.update(sql, email, name);
        if(res == 0)
            throw new UserNotFoundException("유저를 못찾았는뎁쇼?");

    }

    @Override
    public void deleteUser(String name) {
        String sql = "DELETE FROM users WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }
}
