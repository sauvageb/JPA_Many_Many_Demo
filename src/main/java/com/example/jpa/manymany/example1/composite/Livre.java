package com.example.jpa.manymany.example1.composite;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Version
    private int version;

    private String titre;

    @OneToMany(mappedBy = "livre")
    private List<LivreEditeur> livreEditeurs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<LivreEditeur> getLivreEditeurs() {
        return livreEditeurs;
    }

    public void setLivreEditeurs(List<LivreEditeur> livreEditeurs) {
        this.livreEditeurs = livreEditeurs;
    }

}
