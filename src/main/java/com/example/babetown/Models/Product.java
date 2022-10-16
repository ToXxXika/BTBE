package com.example.babetown.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product {
    private String nomproduit;
    private double prix;
    private int quantite;
    private String matricule;
    private Collection<Commande> ordersByMatricule;

    @Basic
    @Column(name = "nomproduit")
    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    @Basic
    @Column(name = "prix")
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "quantite")
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Id
    @Column(name = "matricule")
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.prix, prix) != 0) return false;
        if (quantite != product.quantite) return false;
        if (nomproduit != null ? !nomproduit.equals(product.nomproduit) : product.nomproduit != null) return false;
        if (matricule != null ? !matricule.equals(product.matricule) : product.matricule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nomproduit != null ? nomproduit.hashCode() : 0;
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantite;
        result = 31 * result + (matricule != null ? matricule.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productByMatriculeprod")
    public Collection<Commande> getOrdersByMatricule() {
        return ordersByMatricule;
    }

    public void setOrdersByMatricule(Collection<Commande> ordersByMatricule) {
        this.ordersByMatricule = ordersByMatricule;
    }
}
