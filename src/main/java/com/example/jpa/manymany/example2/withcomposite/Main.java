package com.example.jpa.manymany.example2.withcomposite;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    // https://www.baeldung.com/jpa-many-to-many
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-unit-2");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Student student = new Student(100L);
        entityManager.persist(student);

        Course course = new Course(200L);
        entityManager.persist(course);

        CourseRating courseRating = new CourseRating();
        courseRating.setId(new CourseRatingKey());
        courseRating.setStudent(student);
        courseRating.setCourse(course);
        courseRating.setRating(10);
        entityManager.persist(courseRating);

        CourseRating persistedCourseRating = entityManager.find(CourseRating.class, new CourseRatingKey(100L, 200L));
        System.out.println(persistedCourseRating);

        entityManager.getTransaction().commit();


        entityManager.getTransaction().begin();

        Course course2 = new Course(300L);
        entityManager.persist(course2);

        CourseRating courseRating2 = new CourseRating();
        courseRating2.setId(new CourseRatingKey());
        courseRating2.setStudent(student);
        courseRating2.setCourse(course2);
        courseRating2.setRating(20);
        entityManager.persist(courseRating2);

        entityManager.getTransaction().commit();


        entityManager.close();
        emf.close();
    }
}
