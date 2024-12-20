package org.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class selectTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        //데이터가 1개일때
        String sql = "select deptno, dname, loc from dept where deptno=?";
        //데이터가 2개일때
        try {
            //연결하고 sql을 준비한다
            conn = DeptUtill.deptConnect();
            //조건에 맞는 데이터 1개 조회
            /*
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 10);
            //결과 값을 받을때 exe메소드는 다른걸로 한다
            res = ps.executeQuery();
            //결과는 한줄씩 보여준다고 한다
            //저거 OutputStream의 next부분과 같은건가
            if (res.next()) {
                //순서는 칼럼들(왼쪽 부터 오른쪽)
                System.out.println(res.getInt(1)); //칼럼 번호를 쓰던가
                System.out.println(res.getString("dname"));
                System.out.println(res.getString(3));
            }
            */
            //여러개 조회
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 10);
            //ps = conn.prepareStatement("select deptno, dname, loc from dept");
            res= ps.executeQuery();
            while (res.next()) {
                //순서는 칼럼들(왼쪽 부터 오른쪽)
                System.out.println(res.getInt(1)); //칼럼 번호를 쓰던가
                System.out.println(res.getString("dname"));
                System.out.println(res.getString(3));
            }



        } catch (Exception e) {
            System.out.println(e);
        }
            DeptUtill.deptClose(conn, ps, res);
    }
}
