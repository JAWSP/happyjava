package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class VehicleMain {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            //만들기
//            Car car = new Car();
//            car.setManufacturer("sad");
//            car.setSeatCount(2);
//            em.persist(car);
            //얜 트럭을 만든다
//            Truck truck = new Truck();
//            truck.setManufacturer("ww");
//            truck.setPayloadCapacity(22.2);
//            em.persist(truck);
//            em.getTransaction().commit();
            //이번엔 조회
            Vehicle ex = em.find(Vehicle.class, 1L);
            log.info(ex.getManufacturer());

            //jpql
            List<Vehicle> vehicles = em.createQuery("SELECT v from Vehicle v", Vehicle.class).getResultList();
            for (Vehicle vehicle : vehicles) {
                //log.info(vehicle.toString());
                if (vehicle instanceof Car) {
                    Car car = (Car)vehicle;
                    log.info(car.toString());
                }

            }

        } finally {
            em.close();
        }
    }
}
