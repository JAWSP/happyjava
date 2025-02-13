package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAO {
    private EntityManagerFactory entityManagerFactory;
    private static final Logger log = LoggerFactory.getLogger(User.class);

    public UserDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("UserPU");
    }

//    //트랜잭션
//    public void entityTransaction(Object object) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        //따로 변수를 새로 생성한게 아니라서 try()안에 넣을 수 없음
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.getTransaction().commit();
//        } finally {
//            entityManager.close();
//        }
//    }
//
//    public void entityTransaction_nonpersist(Object object) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        //따로 변수를 새로 생성한게 아니라서 try()안에 넣을 수 없음
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.getTransaction().commit();
//        } finally {
//            entityManager.close();
//        }
//    }

    //생성
    public void createUser(User user) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    //수정
    public void updateUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    //삭제
    public void deleteUser(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(user)?user : entityManager.merge(user));
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    //탐색
    public User findUserById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.find(User.class, id);
        return entityManager.find(User.class, id);
    }

}
