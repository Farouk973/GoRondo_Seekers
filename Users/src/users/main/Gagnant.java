/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclametgam.entities;

/**
 *
 * @author user
 */
public class Gagnant {
     private int id_gagnant;
    private String nom_gagnant;
    private String prenom_gagnant;
    private String adresse;

    public Gagnant() {
    }

    public Gagnant(int id_gagnant, String nom_gagnant, String prenom_gagnant,String adresse) {
        this.id_gagnant = id_gagnant;
        this.nom_gagnant = nom_gagnant;
        this.prenom_gagnant = prenom_gagnant;
        this.adresse= adresse;
    }

    public Gagnant(String nom_gagnant, String prenom_gagnant) {
        this.nom_gagnant = nom_gagnant;
        this.prenom_gagnant = prenom_gagnant;
    }

    public Gagnant(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_gagnant() {
        return id_gagnant;
    }

    public String getNom() {
        return nom_gagnant;
    }

    public String getPrenom() {
        return prenom_gagnant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId_gagnat(int id_gagnant) {
        this.id_gagnant = id_gagnant;
    }

    public void setNom(String nom_gagnant) {
        this.nom_gagnant = nom_gagnant;
    }

    public void setPrenom(String prenom_gagnant) {
        this.prenom_gagnant = prenom_gagnant;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Gagnant{" + "id_gagnant=" + id_gagnant + ", nom=" + nom_gagnant + ", prenom=" + prenom_gagnant + ", adresse=" + adresse + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id_gagnant;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gagnant other = (Gagnant) obj;
        return this.id_gagnant == other.id_gagnant;
    }
    
}

