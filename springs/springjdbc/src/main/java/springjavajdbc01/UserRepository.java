package springjavajdbc01;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//요새는 DAO대용으로 쓴다고
//CurdRepository의 첫번째 제네릭인자는 엔티티 클래스를, 두번재는 프라이머리키의 타입을 나타낸다
public interface UserRepository extends CrudRepository<User, Long>, CustomUserRepository {

    //이렇게 만들기만 해도 알아서 가져온다고 한다
    //이를 커스텀 쿼리 메소드라는데 메소드 이름을 분석해서 sql을 자동으로 생성한다고 한다
    List<User> findByName(String name);
}
