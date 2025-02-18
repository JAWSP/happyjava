package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class MPMain {
    public static void main(String[] args) {
        //create();
        find();
        //update();
        delete();
    }

    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            log.info("잘됨?");
            Project project = em.find(Project.class, 3L);
            log.info("프로젝트명 : " +project.getTitle());

            for (Employee employee : project.getEmployees()) {
                log.info("사원이름 : "+employee.getName());
            }

        } finally {
            em.close();
        }
    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            //사원 추가
//            Employee employee1 = new Employee("asd");
//            Employee employee2 = new Employee("relvolver");
//
//            //플잭 추가
//            Project project1 = new Project();
//            project1.setTitle("사자 프로젝트");
//
//            //사원 추가
//            employee1.getProjects().add(project1);
//            project1.getEmployees().add(employee1);
//            //적용
//            em.persist(employee1);
//            em.persist(project1);

            //만약 한쪽만만 add시키면...?
            //그럼 무소속인가
            Employee employee2 = new Employee("난 누구지");
            em.find(Project.class, 3L).getEmployees().add(employee2);
            //employee2.getProjects().add(em.find(Project.class, 3L));
            em.persist(employee2);
            em.persist(em.find(Project.class, 3L));


            //커밋
            em.getTransaction().commit();

        } catch (Exception e) {
            //만약에 트랜잭션이 돌아가고 있다면 롤백시킴
            if (em.getTransaction().isActive()) {
                log.info("트랜잭션 롤백으로 카르마지정할게요");
                em.getTransaction().rollback();
            }
            throw e;
        }
        finally {
            em.close();
        }
    }

    private static void update (){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            //그냥 이름 바꾸기
            Employee employee = em.find(Employee.class, 3L);
            employee.setName("John doe");
           // em.merge(employee);

            //프로젝트에 새 맴버 추가하기
            Employee employee2 = em.find(Employee.class, 1L);
            employee2.getProjects().add(em.find(Project.class, 3L));

            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
//            Employee employee = em.find(Employee.class, 4L);
//            em.remove(employee);
            Project project = em.find(Project.class, 3L);
            em.remove(project);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
