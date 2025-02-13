package org.example.jpa;

import jakarta.persistence.*;

public class UserRun {
    //실행할려면? 매니저
    //매니저를 만들려면? 팩토리
    public static void main(String[] args) {
        //여기서 첫번째 인자는 설정에 적용시킨 유닛명을
        //공장만들기

        System.out.println("공장");
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();

//        EntityManagerFactory entityManagerFactory =
//                Persistence.createEntityManagerFactory("UserPU");
        //매니저 만들기
        System.out.println("매니저");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //트랜잭션 만들기
        //얘가 있어야지 실제 영속된 얘들이 실제 DB에 넣어진다
        System.out.println("트랜생성");
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        //엔티티 생성
     //   User user = new User();
        //user.setId(1L);
//        user.setName("sds");
//        user.setEmail("asd@qw.com");
        //그냥 생성시 아직 영속성 컨텍스트와는 관계 없는 상태

        //영속성 컨텍스트가 관리하도록 함
        //이 상태를 영속상태라고 함
        //여기서 아이디가 채워진다
       // entityManager.persist(user);


        //엔티티 조회(SELECT)
       User user = entityManager.find(User.class, 2L);
   //     User user2 = entityManager.find(User.class, 2L);
//        System.out.println(user);
//        System.out.println(user == user2);

        //엔티티 수정
        user.setName("john_doe");

        //그리고 똑같은걸 다시 불러온다 하면?
        //User user2 = entityManager.find(User.class, 502L);
        //user2.setName("jane_doe");

        System.out.println("트랜잭션");
        //영속성 컨텍스트를 분석해서 알맞는 동작을 한다
        transaction.commit();
        System.out.println("트랜잭션 끝");



    }
}
