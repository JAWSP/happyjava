package com.example.springdatajpa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    //이름을 기준으로 조회하고 싶다면?
    //이렇게 메소드를 가져올 수 있다고 한다
    List<User> findByName(String name);
    List<User> findByEmail(String email);
    //얜 SELECT * FROM jpa_suer WHERe name LIKE %a;
    List<User> findByNameContaining(String name);
    //얜 둘다 찾는거
    List<User> findByNameAndEmail(String name, String email);
    List<User> findByNameOrEmail(String name, String email);

    //jpql을 이용한다고 한다
    //:name은 ?와 같은거
    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> selectUser(@Param("name")String name);
    @Query("SELECT u.name FROM User u WHERE u.name LIKE %:name")
    List<String> selectUserLike(@Param("name")String name);

    //데이터가 수정될꺼면 이걸 붙여야지 데이터가 수정됨, 저 2개를 붙여야한다
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.email = :email")
    int deleteByEmail(@Param("email")String email);


    //얜 업데이트
    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.name = :name WHERE u.id=:id ")
    int updateByname(@Param("id")Long id, @Param("name")String name);

    //네이티브 쿼리
    @Query(nativeQuery = true, value = "SELECT * FROM jpa_user WHERE email like %:email")
    List<User> selectBYEmailNative(@Param("email")String email);

    //페이징도 가능함
    List<User> findByNameContaining(String name, Pageable pageable);

}
