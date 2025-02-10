package springjavajdbc01;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

//커스텀 유저 리포지토리
//자바가 기본으로 인식하는 것 말고 내가 뭔갈 더 만들고 싶음
public interface CustomUserRepository {
    //찾아온 정보 중 일부분만 가져오고 싶다면?
    //페이지가 수만갠데 그중 n번째식 가져온다고 가정
    Page<User> findAllUsersWithPagination(Pageable pageable);
}
