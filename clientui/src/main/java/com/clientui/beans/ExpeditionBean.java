package com.clientui.beans;

public class ExpeditionBean {

        private Integer id;
        private Integer idCommande;
        private Integer etat;

        public ExpeditionBean() {
        }

        public ExpeditionBean(Integer idCommande, Integer etat) {
            this.idCommande = idCommande;
            this.etat = etat;
        }

        public Integer getId() {
            return id;
        }

        public ExpeditionBean setId(Integer id) {
            this.id = id;
            return this;
        }

        public Integer getIdCommande() {
            return idCommande;
        }

        public ExpeditionBean setIdCommande(Integer idCommande) {
            this.idCommande = idCommande;
            return this;
        }

        public Integer getEtat() {
            return etat;
        }

        public ExpeditionBean setEtat(Integer etat) {
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
