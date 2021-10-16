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
public class Reclam {
    private int id_reclam;
    private String nom_reclam;
    private String prenom_reclam;
    private String adresse;
    

    public Reclam() {
    }

    public Reclam(int id_reclam, String nom_reclam, String prenom_reclam,String adresse) {
        this.id_reclam = id_reclam;
        this.nom_reclam = nom_reclam;
        this.prenom_reclam = prenom_reclam;
        this.adresse= adresse;
    }

    public Reclam(String nom_reclam, String prenom_reclam) {
        this.nom_reclam = nom_reclam;
        this.prenom_reclam = prenom_reclam;
    }

    public Reclam(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_reclam() {
        return id_reclam;
    }

    public String getNom() {
        return nom_reclam;
    }

    public String getPrenom() {
        return prenom_reclam;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setId_reclam(int id_reclam) {
        this.id_reclam = id_reclam;
    }

    public void setNom(String nom_reclam) {
        this.nom_reclam = nom_reclam;
    }

    public void setPrenom(String prenom_reclam) {
        this.prenom_reclam = prenom_reclam;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Reclam{" + "id_reclam=" + id_reclam + ", nom=" + nom_reclam + ", prenom=" + prenom_reclam + ", adresse=" + adresse + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_reclam;
       
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
        final Reclam other = (Reclam) obj;
        return this.id_reclam == other.id_reclam;
    }

    public boolean getReclams() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
  