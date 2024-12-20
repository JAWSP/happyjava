package org.example.jdbc;

import java.util.List;

public class empUser {
    public static void main(String[] args) {
        empDAO dao = new empDAO();
        empDTO dto = new empDTO(213, "아무개", "무직", 0, "", 10, 220, 0);
        //boolean result = dao.empInsert(dto);

  //      if (result)
  //          System.out.println("쥬끼얏홍~");
  //      else
  //          System.out.println("크아아아악");
        List<empDTO> list = dao.empSelect(dto);
        for (empDTO d : list) {
            System.out.println(d);
        }
    }

}
