package jdbc02.dao;

import java.util.List;

public interface DeptDAO {
    void insertDept(DeptDTO dept);
    List<DeptDTO> findDepts();
    void updateDeptLocationByName(String name, String location);
    void deleteDept(String name);
}
