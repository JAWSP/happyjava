package com.example.springdatajpa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //쿼리 메소드 추가

    //이름으로 조회
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    List<Customer> FindUserToSelect(@Param("name")String name);
    //이메일로 조회
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    List<Customer> FindEmailToSelect(@Param("email")String email);
    //특정 문자를 가진 사람 조회
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name%")
    List<Customer> FindNameLike(@Param("name")String name);
    // 각 닝겐과 닝겐의 주문수
    @Query("SELECT c, count(o) FROM Customer c LEFT JOIN c.orders o GROUP BY c")
    List<Object[]> FindCustomerWithOrderCount();

    //닝겐의 세부 정보와 그 닝겐의 가장 최근 주문 조회
    @Query("SELECT c, o FROM Customer c JOIN c.orders o WHERE o.date = (SELECT MAX(o2.date) FROM Order o2 WHERE o2.customer = c)")
    List<Object[]> FindCustomerWithRecentOrder();
    //평균 나이보다 많은 고갱님을 조회
    @Query("SELECT c FROM Customer c WHERE c.age " +
            "> (SELECT avg(c2.age) FROM Customer c2)")
    List<Customer> FindCustomerAJae();


    List<Customer> findByEmailContaining(String email, Pageable pageable);
}
