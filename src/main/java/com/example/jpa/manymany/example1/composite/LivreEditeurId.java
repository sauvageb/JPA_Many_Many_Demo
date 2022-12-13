package com.example.jpa.manymany.example1.composite;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LivreEditeurId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long livreId;
    private Long editeurId;

    public LivreEditeurId() {

    }

    public LivreEditeurId(Long livreId, Long editeurId) {
        super();
        this.livreId = livreId;
        this.editeurId = editeurId;
    }

    public Long getLivreId() {
        return livreId;
    }

    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }

    public Long getEditeurId() {
        return editeurId;
    }

    public void setEditeurId(Long editeurId) {
        this.editeurId = editeurId;
    }
}
