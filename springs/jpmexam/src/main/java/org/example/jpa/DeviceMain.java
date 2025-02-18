package org.example.jpa;

import jakarta.persistence.EntityManager;

public class DeviceMain {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        try {
            LapTop laptop = new LapTop();
            laptop.setBrand("레노바");
            laptop.setPrice(39800);
            laptop.setRAM(36);
            laptop.setHasTouchScreen(true);

            entityManager.persist(laptop);

            Phone phone = new Phone();
            phone.setBrand("애플");
            phone.setPrice(888);
            phone.setOS("iOS");
            phone.setBatteryLife(222);
            entityManager.persist(phone);


            entityManager.getTransaction().commit();




        } finally {
            entityManager.close();
        }
    }
}
