package day16;

import java.util.HashSet;
import java.util.Set;

public class EmployeeManager {
    Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public boolean removeEmployee(Employee e) {
        return employees.remove(e);
    }

    //id
    public void findEmployee (String target) {
        if (target == null)
            return ;
        for (Employee e : employees) {
            if (e.getId().equals(target))
                System.out.println(e);
        }
    }
}
