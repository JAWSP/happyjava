package jdbc02.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class DeptDAOImpl implements DeptDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void insertDept(DeptDTO dept) {
        jdbcTemplate.update("INSERT INTO dept(dept_no, dept_name, location) VALUES(?, ?, ?)",
                dept.getDept_no(), dept.getDept_name(), dept.getLocation());

    }

    @Override
    public List<DeptDTO> findDepts() {
//        RowMapper<DeptDTO> rowMapper = new RowMapper<DeptDTO>() {
//            @Override
//            public DeptDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return new DeptDTO(
//                        rs.getLong("dept_no"),
//                        rs.getString("dept_name"),
//                        rs.getString("location")
//                );
//            }
//        };
        String sql = "SELECT * FROM dept";
        List<DeptDTO> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DeptDTO.class));
        return result;
    }

    @Override
    public void updateDeptLocationByName(String name, String location) {
        String sql = "UPDATE dept SET location=? WHERE dept_name=?";
        jdbcTemplate.update(sql, location, name);
    }

    @Override
    public void deleteDept(String name) {
        jdbcTemplate.update("DELETE FROM dept WHERE dept_name = ?", name);
    }
}
