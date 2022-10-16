package com.example.babetown.Models;

import javax.persistence.*;

@Entity
public class Arrivage {
    private String matriculeprod;
    private String datearrivage;
    private int id;

    @Basic
    @Column(name = "matriculeprod")
    public String getMatriculeprod() {
        return matriculeprod;
    }

    public void setMatriculeprod(String matriculeprod) {
        this.matriculeprod = matriculeprod;
    }

    @Basic
    @Column(name = "datearrivage")
    public String getDatearrivage() {
        return datearrivage;
    }

    public void setDatearrivage(String datearrivage) {
        this.datearrivage = datearrivage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Arrivage arrivage = (Arrivage) o;

        if (matriculeprod != null ? !matriculeprod.equals(arrivage.matriculeprod) : arrivage.matriculeprod != null)
            return false;
        if (datearrivage != null ? !datearrivage.equals(arrivage.datearrivage) : arrivage.datearrivage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = matriculeprod != null ? matriculeprod.hashCode() : 0;
        result = 31 * result + (datearrivage != null ? datearrivage.hashCode() : 0);
        return result;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
