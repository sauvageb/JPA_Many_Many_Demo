package com.example.jpa.manymany.example2.withoutcomposite;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
class CoursEtudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Cours cours;

    LocalDateTime registeredAt;

    int grade;

    public CoursEtudiant() {
    }

    public CoursEtudiant(Etudiant etudiant, Cours cours, LocalDateTime registeredAt, int grade) {
        this.etudiant = etudiant;
        this.cours = cours;
        this.registeredAt = registeredAt;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etudiant getStudent() {
        return etudiant;
    }

    public void setStudent(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Cours getCourse() {
        return cours;
    }

    public void setCourse(Cours cours) {
        this.cours = cours;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
