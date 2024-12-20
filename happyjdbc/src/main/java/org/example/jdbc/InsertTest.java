package org.example.jdbc;
/*
JDBC프로그래밍의 기본
//1. 일단 선언을 해
//2. 그걸로 접속해(Connection)
//3. sql문을 만들어(Statement)
//4. 그걸로실행해
//5. 실행한 결과를 받아
//6. 다 썼으면 닫아
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) {

        //1.선언
        Connection conn = null;
        PreparedStatement ps = null; //sql 만드는 객체
        String url = "jdbc:mysql://localhost:3306/scott";
        String user = "back";
        String password = "end";

        //insert into dept(deptno,dname,loc) values(70, 'lion', '');
        //"insert into dept(deptno,dname,loc) values(" +
        //deptno +" , "+ dname + ", '');";
        // ->이렇게 쓰면 너무 힘들어 ->statement로 쓰면 저렇게 된다
        //얘는 prepared-statement할땐 저렇게 ???로 된다고 한다
        String sql = "insert into dept(deptno,dname,loc) values(?, ?, ?);";


        try {
            //2.접속
            conn = DriverManager.getConnection(url, user, password);
            //3. sql넣기
            // sql(변수임)안의 ?에 값을 바인딩(넣어줄)해야 할 필요가 있음
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 90);
            ps.setString(2, "asd");
            ps.setString(3, "그거");
            //4. 실행
            int count = ps.executeUpdate();
            //5. 결과 받기
            System.out.println(count + "가 나옴");
            conn.commit(); //얘가 커밋

        }catch(Exception e) {
            System.out.println(e);
        } finally {
            //6.닫아
            if (ps != null) try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } //sql내는 객체를 닫아

            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } //접속하는 객체를 닫아
        }


    }
}
