package com.mexpedition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expedition {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer idCommande;
    private Integer etat;

    public Expedition() {
    }

    public Expedition(Integer idCommande, Integer etat) {
        this.idCommande = idCommande;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public Expedition setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public Expedition setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
        return this;
    }

    public Integer getEtat() {
        return etat;
    }

    public Expedition setEtat(Integer etat) {
        this.etat = etat;
        return this;
    }

    public String getEtatName() {
        switch (this.getEtat()) {
            case 0:
                return "En préparation";
            case 1:
                return "Expediée";
            case 2:
                return "Livrée";
            default:
                return "INCONNU";
        }
    }
}
