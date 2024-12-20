package org.example.jdbc;

import java.sql.*;

//따로 두는게 다른 얘들도 같이 쓸 수 있다고 한다
//근데 그러기엔 이미 dept라고 써놓아서 그냥 저 테이블만 쓰는 것 같은데..
public class DeptUtill {
    //접속
    //conn객체를 가져온다
    public static Connection deptConnect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/scott";
        String user = "back";
        String password = "end"; //혹은 id, 비번을 인자로 받아도 됩

        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static Connection deptConnect(String user, String password) throws Exception {
        String url = "jdbc:mysql://localhost:3306/scott";

        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    //종료
    public static void deptClose(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } //접속하는 객체를 닫아
        }
    }

    public static void deptClose(Connection connection, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } //sql내는 객체를 닫아

        }
        deptClose(connection);
    }

    public static void deptClose(Connection connection, PreparedStatement ps, ResultSet res) {

        if (res != null) {
            try {
               res.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } //접속하는 객체를 닫아
        }
        deptClose(connection, ps);

    }
}
