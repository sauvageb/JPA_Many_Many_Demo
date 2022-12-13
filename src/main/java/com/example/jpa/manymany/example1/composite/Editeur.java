package com.example.jpa.manymany.example1.composite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Editeur {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "editeur")
    private Set<LivreEditeur> livreEditeurs = new HashSet<>();

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

    public Set<LivreEditeur> getLivreEditeurs() {
        return livreEditeurs;
    }

    public void setLivreEditeurs(Set<LivreEditeur> livreEditeurs) {
        this.livreEditeurs = livreEditeurs;
    }
}
