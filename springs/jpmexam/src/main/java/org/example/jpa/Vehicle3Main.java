package org.example.jpa;

import jakarta.persistence.EntityManager;

public class Vehicle3Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {

            Car3 car3 = new Car3();
            car3.setSeatcount(2);
            car3.setManufacturer("tesla");
            em.persist(car3);

            Truck3 truck3 = new Truck3();
            truck3.setPayloadCapatity(2);
            truck3.setManufacturer("cyber Truck");
            em.persist(truck3);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
