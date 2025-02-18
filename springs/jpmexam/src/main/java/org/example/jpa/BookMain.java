package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;


@Slf4j
public class BookMain {
    public static void main(String[] args) {

      //  create();
        find();

        update();
        delete();
    }

    private static void create() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Author author = new Author("asd");
            author.getBooks().add(new Book("허리 다이어트와 마법사의 약", author));
            author.getBooks().add(new Book("허리 다이어트와 지 방", author));
            author.getBooks().add(new Book("허리 다이어트와 안찌지롱의 죄수", author));
            author.getBooks().add(new Book("허리 다이어트와 아채쥬스 잔", author));
            author.getBooks().add(new Book("허리 다이어트와 건강소대 기사단", author));
            author.getBooks().add(new Book("허리 다이어트와 요요왕자", author));
            author.getBooks().add(new Book("허리 다이어트와 지방의 성물 ", author));
            em.persist(author);
            em.getTransaction().commit();


        } finally {
            em.close();
        }
    }

    private static void find() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            Author author = em.find(Author.class, 3L);
            log.info("지은놈 : {}", author.getName());
            for (Book book : author.getBooks()) {
                log.info("걔가 지은 책 : {}", book.getTitle());
            }
//            Book book = em.find(Book.class, 1L);
//            log.info("제목 : " + book.getTitle());
//            log.info("작가  : " + book.getAuthor().getName());
        } finally {
            em.close();
        }
    }

    private static void update() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            Book book = em.find(Book.class, 7L);
            book.setTitle("허리 다이어트와 피하지방의 죄수");
            em.merge(book);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    private static void delete() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(em.find(Author.class, 3L));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
