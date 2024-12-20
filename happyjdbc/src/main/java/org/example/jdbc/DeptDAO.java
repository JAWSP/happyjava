package org.example.jdbc;

//DAO는 각 테이블(DB?)에서 유동적으로 잘 되게 하는 방법이라고 한다

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
    //기본 CRUD
    //insert -- c
    public boolean DAO_insert(DeptDTO dto) {

        //1. 선언
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        String sql = "insert into dept(deptno,dname,loc) values(?, ?, ?);";

        try {
            //2. 접속
            conn = DeptUtill.deptConnect();
            //3. 작성
            ps = conn.prepareStatement(sql);
            ps.setInt(1, dto.getDeptno());
            ps.setString(2, dto.getDname());
            ps.setString(3, dto.getLoc());

            //4. 실행
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
            //5. 닫아
            DeptUtill.deptClose(conn, ps);
        }
        return flag;
    }
    //read -- r
    //Array list로 굳이 안해도 된다고 한다
    public List<DeptDTO> getDepts(DeptDTO dto) {

        List<DeptDTO> deptlist = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        String sql = "select deptno, dname, loc from dept where deptno=?";
        try {
            conn = DeptUtill.deptConnect();
            ps = conn.prepareStatement("select deptno, dname, loc from dept");
            res = ps.executeQuery();
            //결과값 담기
            while(res.next()) {
                //객체 만들어서 담고
                DeptDTO dtoTmp = new DeptDTO();
                dtoTmp.setDeptno(res.getInt(1));
                dtoTmp.setDname(res.getString(2));
                dtoTmp.setLoc(res.getString(3));
                //담은 객체를 리스트에 추가
                deptlist.add(dtoTmp);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DeptUtill.deptClose(conn, ps, res);
        }
        return deptlist;
    }



    //update -- u
    public int DAO_updatet(DeptDTO dto) {
        //1. 선언
        Connection conn = null;
        PreparedStatement ps = null;
        int flag = 0;
        String sql = "update dept set dname=? where deptno=?;";

        try {
            //2. 접속
            conn = DeptUtill.deptConnect();
            //3. 작성
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getDname());
            ps.setInt(2, dto.getDeptno());

            //4. 실행
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println(result + "아니 이게 됨?");
                flag = 1;
            }
            else
                System.out.println(result + "네가 뭐 그렇지");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //5. 닫아
            DeptUtill.deptClose(conn, ps);
        }
        return flag;

    }
    //delete -- d
    //근데 삭제 기준을 deptno만 쓰려나
    public void DAO_delete(int deptno) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from dept where deptno=?;";

        try {
            //2. 접속
            conn = DeptUtill.deptConnect();
            //3. 작성
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deptno);


            //4. 실행
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println(result + "아니 이게 됨?");
            }
            else
                System.out.println(result + "네가 뭐 그렇지");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //5. 닫아
            DeptUtill.deptClose(conn, ps);
        }

    }
}
