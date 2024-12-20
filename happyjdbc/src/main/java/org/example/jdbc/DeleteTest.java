package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/scott";
        String user = "back";
        String password = "end";
        String sql = "delete from ? where deptno=?";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql);

        ) {
            ps.setString(1, "dept");
            ps.setInt(2, 70);
            System.out.println(ps);

            int count = ps.executeUpdate();
           // conn.commit();

            System.out.println("삭제 완료");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
