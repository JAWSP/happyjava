package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class SchoolMain {
   // private static final Logger log = LoggerFactory.getLogger(School.class);
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();
        try {
            School school = entityManager.find(School.class, 1L);
            log.info("School name : {}", school.getName());
            for(Student student : school.getStudents()) {
                log.info("Student : {}", student.getName());
            }

        } finally {
            entityManager.close();
        }
    //    create();
//        find();
//        update();
        delete();
    }
    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            School school = new School("사자학교");
            school.getStudents().add(new Student("asd", school));
            school.getStudents().add(new Student("차은우", school));
            school.getStudents().add(new Student("엘론 머스크", school));


            em.persist(school);
            //Student student = new Student("wwe", em.find(School.class, 4L));
            //em.persist();
            em.getTransaction().commit();

        }finally {
            em.close();
        }
    }
    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();

        try {
            School school = em.find(School.class, 3L);
            log.info("학교 이름이? {}", school.getName());
            for(Student student : school.getStudents()) {
                log.info("출석부른다");
                log.info("너는 : {}", student.getName());
            }

        }finally {
            em.close();
        }

    }

    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            Student student = em.find(Student.class, 7L);
            student.setName("정우성");
            em.merge(student);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
//            Student student = em.find(Student.class, 8L);
//            em.remove(student);
//            log.info("{} 퇴 학 ", student.getName());
            School school = em.find(School.class, 2L);
            em.remove(school);
            log.info("{}가 이러저러한 사정으로 페교 조치를", school.getName());
            em.getTransaction().commit();
            log.info("{}가 이러저러한 사정으로 페교 조치를", school.getName());
        } finally {
            em.close();
        }
    }
}
