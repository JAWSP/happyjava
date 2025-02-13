package org.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserMain {

    //원래 요 부분은 롭북이@Slf4j를 써주는건데..
    private static final Logger log = LoggerFactory.getLogger(UserMain.class);
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        User user = userDAO.findUserById(2L);
        System.out.println(user);

        //로그는 콘솔을 건들여서 배포시 다 빼야 한다
        log.info("로그로그로그");
        log.info("find user : {}{}", user, user.getName());


        User updateUser = new User("네오 뉴 asd", "sd@w");
        userDAO.updateUser(updateUser);

        //userDAO.updateUser();
        //userDAO.deleteUser(userDAO.findUserById(502L));
    }
}
