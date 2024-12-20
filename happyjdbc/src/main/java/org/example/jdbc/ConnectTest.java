package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
1. 일단 드라이버를 설치(?)한다
2. 접속 객체를 생성한다, DriverManager라는 클래스를 이용한다

    mysql을 접속한다는 뜻

3. Statement클래스에서 sql을 작성하고
4. 작성한 sql을 DB가 받아서 실행하고
5. ResultSet클래스에서 실행된 결과를 받아낸다
6. 다 사용하고 나면 close를 한다고 한다
 */
public class ConnectTest {
    public static void main(String[] args) throws Exception {

        //옛날엔 드라이버까지 로딩을 했어야 했는데 요새는 안해도 된다고 한다


        // 1. 접속 확인

        //url의 localhost앞은 국룰 양식이라고 한다
        // 국룰://위치:포트번호/DB명순
        String url = "jdbc:mysql://localhost:3306/scott";
        String user = "back";
        String password = "end";

        Connection conn = null; // 접속이 추상화된 객체
        //예외처리 해줘야 한다
        try{
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null)
                System.out.println("이게 되네");
            else
                System.out.println("네가 뭐 그렇지 뭘 할 수 있겠어");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if(conn!= null) try {
             conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
