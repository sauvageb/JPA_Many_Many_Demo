package com.example.jpa.manymany.example2.withoutcomposite;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class Main {

    // https://www.baeldung.com/jpa-many-to-many
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit-3");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Etudiant etudiant = new Etudiant("Boris");
        entityManager.persist(etudiant);

        Cours cours = new Cours("JAVA WEB");
        entityManager.persist(cours);

        CoursEtudiant coursEtudiant = new CoursEtudiant();
        coursEtudiant.setStudent(etudiant);
        coursEtudiant.setCourse(cours);
        coursEtudiant.setGrade(10);
        entityManager.persist(coursEtudiant);

//        CoursEtudiant persistedCoursEtudiant = entityManager.find(CoursEtudiant.class, 300L);
//        System.out.println(persistedCoursEtudiant);

        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();

        Cours cours2 = new Cours("SPRING BOOT");
        entityManager.persist(cours2);

        CoursEtudiant coursEtudiant2 = new CoursEtudiant(etudiant, cours2, LocalDateTime.now(), 15);
        entityManager.persist(coursEtudiant2);

        entityManager.getTransaction().commit();


        entityManager.close();
        emf.close();
    }
}
