package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//이번엔 업뎃
public class UpdateTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/scott";
        String user = "back";
        String password = "end";
        String sql = "update dept set dname=? where deptno=?;";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql);
                ) {
            ps.setString(1, "암ㅁㅇㄴㅁㅇㅁ");
            ps.setInt(2, 70);


            int count = ps.executeUpdate();
            //conn.commit();

            System.out.println("수정 완료");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
