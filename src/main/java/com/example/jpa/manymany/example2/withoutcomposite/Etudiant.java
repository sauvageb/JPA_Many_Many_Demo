package com.example.jpa.manymany.example2.withoutcomposite;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String firstname;

    @OneToMany(mappedBy = "etudiant")
    private Set<CoursEtudiant> inscriptions = new HashSet<>();

    // additional properties

    public Etudiant() {
    }

    public Etudiant(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Set<CoursEtudiant> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<CoursEtudiant> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
