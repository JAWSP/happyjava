package jdbc02.dao;

import java.util.List;

public interface UserDao {
    //대충 유저 입력받는거
    void insertUser(User user);
    //대충 유저 찾는거
    List<User> findUsers();
    //대충 유저 업데이트
    void updateUserEmail(String name, String email);
    //대충 유저 삭제
    void deleteUser(String name);
}
