package org.example.jpa;

import jakarta.persistence.EntityManager;

public class SchoolMain {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        entityManager.getTransaction().begin();
        try {
            School school = entityManager.find(School.class, 1L);
            log.info("School name : {}", school.getName());
            for(Student student : school.getStudents()) {
                log.info(Student)
            }

        } finally {
            entityManager.close();
        }
    }
}
