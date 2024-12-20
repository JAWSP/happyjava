package org.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 private  int empno;

    private  String ename;
    private  String job;
    private  int mgr;
    private int sal;
    private int comm;
    private int deptno;

 */
public class empDAO {
    static Connection conn;
    static PreparedStatement ps;
    //c
    public boolean empInsert(empDTO dto) {
        boolean flag = false;
        String sql = "insert into emp(ename, job, mgr, sal, comm, deptno) values(?, ?, ?, ?, ?, null)";
        try {
                conn = DeptUtill.deptConnect();

                ps = conn.prepareStatement(sql);
                ps.setString(1, dto.getEname());
                ps.setString(2, dto.getJob());
                ps.setInt(3, dto.getMgr());
                ps.setInt(4, dto.getSal());
                ps.setInt(5, dto.getComm());

                int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println(result + "아니 이게 됨?");
                flag = true;
            }
            else
                System.out.println(result + "네가 뭐 그렇지");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DeptUtill.deptClose(conn, ps);
        }
        return flag;
    }

    //r
    public List<empDTO> empSelect(empDTO dto) {
        List<empDTO> empList = new ArrayList<empDTO>();
        ResultSet res = null;
        String sql = "select * from emp";
        try {
            conn = DeptUtill.deptConnect();
            ps = conn.prepareStatement(sql);
            //ps.setInt(1, 10);
            res = ps.executeQuery();

            while (res.next()) {
                empDTO dtoTemp = new empDTO(
                        res.getInt(1), res.getString(2), res.getString(3),
                        res.getInt(4), res.getString(5), res.getInt(6), res.getInt(7), res.getInt(8));
                empList.add(dtoTemp);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DeptUtill.deptClose(conn, ps, res);
        }
        return empList;
    }

    //u

    //d
}
