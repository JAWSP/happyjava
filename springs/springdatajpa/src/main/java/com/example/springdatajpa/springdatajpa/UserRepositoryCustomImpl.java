package com.example.springdatajpa.springdatajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom{
    //엔티티 메니저를 가져온다
    private final EntityManager entityManager;
    @Override
    public List<User> findUserByName(String name) {
        //criteria api가 엔티티 메니저를 제공해준다
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //나는 User엔티티에 대한 쿼리를 가져올것이다라고 한다
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        //form에 해당되는 유저 루트 객체를 생성
        Root<User> userRoot = query.from(User.class);
        //본격적인 쿼리 만들기
        //얘는 SELECT u from User u WHERE u.name = name임
        query.select(userRoot).where(criteriaBuilder.equal(userRoot.get("name"), name));


        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<User> findUsersDynamically(String name, String email) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);

        //조건을 담을 객체
        //Predicate는 조건에 따라 boolean을 리턴하는 객체(람다식참조)
        List<Predicate> predicates = new ArrayList<>();
        if (name != null) {
            //이름이 있을 경우에 대한 조건?을 담는다
            predicates.add(cb.equal(userRoot.get("name"), name));
        }
        if (email != null) {
            //이베일이 있을 경우에 대한 조건을 담는다
            predicates.add(cb.equal(userRoot.get("email"), email));
        }

        //그리고 where에서 이전에 저장해두었던 조건을 넣어준다
        //[0]은 0번째가 아니라 그냥 toArray()와 같은 의미임
        query.select(userRoot).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}
