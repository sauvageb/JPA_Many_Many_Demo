package com.example.jpa.manymany.example2.withoutcomposite;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "cours")
    private Set<CoursEtudiant> inscriptions = new HashSet<>();

    // additional properties

    public Cours() {
    }

    public Cours(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CoursEtudiant> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<CoursEtudiant> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
