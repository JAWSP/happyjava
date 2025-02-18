package org.example.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JPAUtil {
    private static final EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory("UserPU");
    private JPAUtil() {}

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (emfInstance != null) {
                System.out.println("공장 문 닫습니다");
                //log.info("공장 문 닫습니다");
                emfInstance.close();
            }
        }));
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emfInstance;
    }
}
