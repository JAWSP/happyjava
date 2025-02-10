//package springjavajdbc01;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.support.PageableExecutionUtils;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//
//import java.awt.print.Pageable;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RequiredArgsConstructor
//public class CustomUserRepositoryImpl implements CustomUserRepository{
//    private final NamedParameterJdbcTemplate jdbcTemplate;
//
//    //커스텀특) 네가 다 만들어야 함
//    //찾아온 정보 중 일부분만 가져오고 싶다면?
//    //페이지가 수만갠데 그중 n번째식 가져온다고 가정
//    @Override
//    public Page<User> findAllUsersWithPagination(Pageable pageable) {
//        //여기서 :는 들어가는 변수라고 한다
//        // ?를 안쓰고 :를 쓰는 이유는 뭐지
//        String query = "SELECT " +
//                "id, name, email " +
//                "FROM users " +
//                "LIMIT :limit" +
//                " OFFSET : offset";
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("limit", pageable.getPageSize());
//        params.put("offset", pageable.getOffset());
//
//        List<User> users = jdbcTemplate.query(query, params, new BeanPropertyRowMapper<>(User.class));
//
//        String countQuery = "SELECT count(*) FROM users";
//        return PageableExecutionUtils.getPage(users, pageable,
//                ()->jdbcTemplate.queryForObject(countQuery, params, Long.class));
//    }
//}
