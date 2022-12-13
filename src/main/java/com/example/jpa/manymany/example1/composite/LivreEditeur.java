package com.example.jpa.manymany.example1.composite;


import jakarta.persistence.*;

@Entity
public
class LivreEditeur {

    @EmbeddedId
    private LivreEditeurId id = new LivreEditeurId();

    @ManyToOne
    @MapsId("livreId")
    private Livre livre;

    @ManyToOne
    @MapsId("editeurId")
    private Editeur editeur;

    @Enumerated(EnumType.STRING)
    private Format format;

    public LivreEditeurId getId() {
        return id;
    }

    public void setId(LivreEditeurId id) {
        this.id = id;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}
