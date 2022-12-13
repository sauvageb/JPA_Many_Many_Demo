package com.example.jpa.lazy_eager;

import jakarta.persistence.*;


public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit-4");

        // Insert Author before testing in update ddl mode
        insertAuthorWithBooks(emf);

        // Solution : using JOIN FETCH with JPQL query
        Author author = fetchAuthorWithBooks(emf);
        System.out.println(author);

        emf.close();
    }

    private static Author fetchAuthorWithBooks(EntityManagerFactory emf) {
        Author author = null;
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            TypedQuery<Author> query = em.createQuery("SELECT a FROM Author a JOIN FETCH a.bookList WHERE a.id=:id", Author.class);
            query.setParameter("id", 1L);
            author = query.getSingleResult();
            et.commit();
        } catch (Exception e) {
            System.err.println(e);
            if (et.isActive()) et.rollback();
        } finally {
            em.close();
            return author;
        }
    }

    private static void insertAuthorWithBooks(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Author author = new Author("Boris");
            Book book = new Book("Mon livre");
            book.setAuthor(author);
            author.getBookList().add(book);
            em.persist(author);
            et.commit();
        } catch (Exception e) {
            System.err.println(e);
            if (et.isActive()) et.rollback();
        } finally {
            em.close();
        }
    }


}
