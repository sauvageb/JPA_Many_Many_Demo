package com.example.jpa.manymany.example1.composite;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit-1");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Livre livre = new Livre();
        livre.setTitre("Steve Jobs");
        livre.setVersion(2);
        em.persist(livre);

        Editeur editeur = new Editeur();
        editeur.setName("Walter Isaacson");
        em.persist(editeur);

        LivreEditeur livreEditeur = new LivreEditeur();
        livreEditeur.setId(new LivreEditeurId());
        livreEditeur.setLivre(livre);
        livreEditeur.setEditeur(editeur);
        livreEditeur.setFormat(Format.EBOOK);
        em.persist(livreEditeur);

        LivreEditeur persistedLivreEditeur = em.find(LivreEditeur.class, new LivreEditeurId(livre.getId(), editeur.getId()));
        System.out.println(persistedLivreEditeur);

        em.getTransaction().commit();


        em.getTransaction().begin();
        Editeur editeur2 = new Editeur();
        editeur2.setName("Walter Isaacson");
        em.persist(editeur2);

        LivreEditeur livreEditeur2 = new LivreEditeur();
        livreEditeur2.setId(new LivreEditeurId());
        livreEditeur2.setLivre(livre);
        livreEditeur2.setEditeur(editeur2);
        livreEditeur2.setFormat(Format.EBOOK);
        em.persist(livreEditeur2);

        LivreEditeur persistedLivreEditeur2 = em.find(LivreEditeur.class, new LivreEditeurId(livre.getId(), editeur2.getId()));
        System.out.println(persistedLivreEditeur2);

        em.getTransaction().commit();


        em.close();
        emf.close();
    }
}
