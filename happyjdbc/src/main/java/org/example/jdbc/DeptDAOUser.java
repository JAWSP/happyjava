package org.example.jdbc;

import java.util.List;

public class DeptDAOUser {
    public static void main(String[] args) {
        DeptDAO dao = new DeptDAO();
        DeptDTO dto = new DeptDTO(110, "뭐시기", "거시기");
        DeptDTO dto2 = new DeptDTO(110, "무언가", "그런건가");

        boolean result = dao.DAO_insert(dto);

        //생성
       // if (result)
       //     System.out.println("쥬끼얏홍~");
       // else
       //     System.out.println("크아아아악");

        //수정
        /*
        if (dao.DAO_updatet(dto2) == 1)
            System.out.println("쥬끼얏홍~");
        else
            System.out.println("쥬끼아아아아악");
            */

        // 읽기
           // dao.DAO_read(dto);
        List<DeptDTO> list = dao.getDepts(dto);
        for (DeptDTO d : list) {
            System.out.println(d);
        }

        //삭제
        //dao.DAO_delete(110);
    }
}
