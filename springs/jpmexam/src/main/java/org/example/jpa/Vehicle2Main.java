package org.example.jpa;

import jakarta.persistence.EntityManager;

public class Vehicle2Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
//            Car2 car2 = new Car2();
//            car2.setSeatcount(2);
//            car2.setManufacturer("tesla");
//            em.persist(car2);

//            Truck2 truck2 = new Truck2();
//            truck2.setPayloadCapatity(2);
//            truck2.setManufacturer("cyber Truck");
//            em.persist(truck2);
            em.remove(em.find(Vehicle2.class, 1L));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
