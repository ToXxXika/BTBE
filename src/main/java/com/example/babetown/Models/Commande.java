package com.example.babetown.Models;

import javax.persistence.*;

@Entity
public class Commande {
    private String matriculeprod;
    private Integer quantite;
    private int refcommande;
    private String localisation;
    private Double prixtotal;
    private String numtel;
    private Product productByMatriculeprod;

    //create a constructor with matirculeprod, quantite, localisation, prixtotal, numtel
    public Commande(String matriculeprod, Integer quantite, String localisation, Double prixtotal, String numtel) {
        this.matriculeprod = matriculeprod;
        this.quantite = quantite;
        this.localisation = localisation;
        this.prixtotal = prixtotal;
        this.numtel = numtel;
    }
    public Commande(){

    }
    @Basic
    @Column(name = "matriculeprod")
    public String getMatriculeprod() {
        return matriculeprod;
    }

    public void setMatriculeprod(String matriculeprod) {
        this.matriculeprod = matriculeprod;
    }

    @Basic
    @Column(name = "quantite")
    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "refcommande")
    public int getRefcommande() {
        return refcommande;
    }

    public void setRefcommande(int refcommande) {
        this.refcommande = refcommande;
    }

    @Basic
    @Column(name = "localisation")
    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Basic
    @Column(name = "prixtotal")
    public Double getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(Double prixtotal) {
        this.prixtotal = prixtotal;
    }

    @Basic
    @Column(name = "numtel")
    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (refcommande != commande.refcommande) return false;
        if (matriculeprod != null ? !matriculeprod.equals(commande.matriculeprod) : commande.matriculeprod != null)
            return false;
        if (quantite != null ? !quantite.equals(commande.quantite) : commande.quantite != null) return false;
        if (localisation != null ? !localisation.equals(commande.localisation) : commande.localisation != null) return false;
        if (prixtotal != null ? !prixtotal.equals(commande.prixtotal) : commande.prixtotal != null) return false;
        if (numtel != null ? !numtel.equals(commande.numtel) : commande.numtel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = matriculeprod != null ? matriculeprod.hashCode() : 0;
        result = 31 * result + (quantite != null ? quantite.hashCode() : 0);
        result = 31 * result + refcommande;
        result = 31 * result + (localisation != null ? localisation.hashCode() : 0);
        result = 31 * result + (prixtotal != null ? prixtotal.hashCode() : 0);
        result = 31 * result + (numtel != null ? numtel.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "matriculeprod", referencedColumnName = "matricule", nullable = false ,insertable = false, updatable = false)
    public Product getProductByMatriculeprod() {
        return productByMatriculeprod;
    }

    public void setProductByMatriculeprod(Product productByMatriculeprod) {
        this.productByMatriculeprod = productByMatriculeprod;
    }
}
