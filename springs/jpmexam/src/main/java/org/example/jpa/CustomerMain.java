package org.example.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CustomerMain {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {

            ContactInfo contactInfo = new ContactInfo("21@ww", "!@3213");
            Customer customer = new Customer("www", contactInfo);
            Customer customer12 = new Customer("wwe", contactInfo);
            em.persist(customer12);
            em.persist(customer);
            em.getTransaction().commit();

            //조회
            List<Customer> customers = em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
            for (Customer c : customers) {
                System.out.println(c.getId() + " " + c.getName() + " " +  c.getContactInfo().getPhoneNum());
            }
        }finally {
            em.close();
        }
    }
}
