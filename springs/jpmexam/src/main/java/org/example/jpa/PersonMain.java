package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonMain {
    public static void main(String[] args) {
        //find();
        //create();
        //update();
        delete();
    }

    private static void find() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            Person person = entityManager.find(Person.class, 1L);
            log.info("이름 : {}", person.getName());
            log.info("려권 번호 : {}", person.getPassport().getPassportNumber());
        } finally {
            entityManager.close();
        }
    }

    private static void create() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Person person = new Person("Jane Doe");
            Passport passport = new Passport("e2312e2424");

            //서로 관계를 적용시켜야 한다
            person.setPassport(passport);
            passport.setPerson(person);

             entityManager.persist(person);
            //entityManager.persist(passport);
            entityManager.getTransaction().commit();

        } finally {
            entityManager.close();
        }
    }

    private static void update() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Person person = entityManager.find(Person.class, 4L);
            person.setName("asd");
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                log.info("롤백 발동시?");
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    private static void delete() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Person person = entityManager.find(Person.class, 4L);
            entityManager.remove(person);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
