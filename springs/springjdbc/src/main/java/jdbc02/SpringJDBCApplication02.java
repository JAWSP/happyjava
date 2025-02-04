package jdbc02;

import jdbc02.dao.DeptDAO;
import jdbc02.dao.DeptDTO;
import jdbc02.dao.User;
import jdbc02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringJDBCApplication02 implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringJDBCApplication02.class);
    }

    //dao 주입
    @Autowired
    private UserDao userDao;
    @Autowired
    private DeptDAO deptDAO;

    @Override
    public void run(String... args) throws Exception {
//        //insert
        userDao.insertUser(new User(null, "qqq", "@!"));
//        //Update
        userDao.updateUserEmail("엄준식", "@!#@!21");
//        //show
//        List<User> users= userDao.findUsers();
//        //DELECTe
//        userDao.deleteUser("qqq");
//
//        for (User user : users)
//            System.out.println(user);
        deptDAO.insertDept(new DeptDTO(null, 0, "asd", "hell"));
        List<DeptDTO> depts = deptDAO.findDepts();
        deptDAO.updateDeptLocationByName("asd", "OMG");

        for (DeptDTO dept : depts)
            System.out.println(dept);
        deptDAO.deleteDept("asd");
    }
}
