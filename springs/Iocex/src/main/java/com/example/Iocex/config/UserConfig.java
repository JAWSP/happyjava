package com.example.Iocex.config;

import com.example.Iocex.controller.UserController;
import com.example.Iocex.domain.User;
import com.example.Iocex.repository.UserDao;
import com.example.Iocex.repository.UserDaoimpl;
import com.example.Iocex.service.UserService;
import com.example.Iocex.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

//객체를 등록한다 이말이야
@ComponentScan(basePackages ="com.example.Iocex")
public class UserConfig {
        @Bean
    public UserDao UserDao(List<User> userList) {
        UserDao userDao = new UserDaoimpl(userList);
        return userDao;
    }
}

//ComponentScan없는 버전
//public class UserConfig {
//    //얜 등록 안해도 됨
////    @Bean
////    public User user() {
////        return new User();
////    }
//
//    //나는 Dao에 미리 저장하게 만드러써요
//    @Bean
//    public UserDao UserDao(List<User> userList) {
//        UserDao userDao = new UserDaoimpl(userList);
//        return userDao;
//    }
////    @Bean
////    public UserDao userDao() {
////        return new UserDaoimpl();
////    }
//
//    @Bean
//    public UserService UserService(UserDao dao) {
//        //UserService userService = new UserServiceImpl(dao);
//        //return userService;//요 위와 같음
//        //return new UserServiceImpl(dao); //생성자 주입
//
//        //setter주입할때 impl로 해야 한다 원본 인터페이스에선 없거든
//        UserServiceImpl userService = new UserServiceImpl();//setter주입
//        userService.setUserDao(dao);
//        return  userService;
//    }
//
//
//    @Bean
//    public UserController userController(UserService userService) {
//        UserController userController = new UserController();
//        userController.setUserService(userService); //setter주입
//        return userController;
//        //return new UserController(userService); -> 생성자주입
//    }
//
//
//}
