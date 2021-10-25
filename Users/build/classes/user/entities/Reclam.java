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
    private int Id_reclam;
    private String Nom_reclam;
    private String Prenom_reclam;
    private String Adresse_reclam;
    private String RECLAM;
    

    public Reclam() {
    }

    public Reclam(int Id_reclam, String Nom_reclam, String Prenom_reclam,String Adresse_reclam,String RECLAM) {
        this.Id_reclam = Id_reclam;
        this.Nom_reclam = Nom_reclam;
        this.Prenom_reclam = Prenom_reclam;
        this.Adresse_reclam= Adresse_reclam;
    }

    public Reclam(String Nom_reclam, String Prenom_reclam) {
        this.Nom_reclam = Nom_reclam;
        this.Prenom_reclam = Prenom_reclam;
    }

    public Reclam(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_reclam() {
        return Id_reclam;
    }

    public void setId_reclam(int Id_reclam) {
        this.Id_reclam = Id_reclam;
    }

    public String getNom_reclam() {
        return Nom_reclam;
    }

    public void setNom_reclam(String Nom_reclam) {
        this.Nom_reclam = Nom_reclam;
    }

    public String getPrenom_reclam() {
        return Prenom_reclam;
    }

    public void setPrenom_reclam(String Prenom_reclam) {
        this.Prenom_reclam = Prenom_reclam;
    }

    public String getAdresse_reclam() {
        return Adresse_reclam;
    }

    public void setAdresse_reclam(String Adresse_reclam) {
        this.Adresse_reclam = Adresse_reclam;
    }

    public String getRECLAM() {
        return RECLAM;
    }

    public void setRECLAM(String RECLAM) {
        this.RECLAM = RECLAM;
    }

   
    @Override
    public String toString() {
        return "Reclam {" + "Id_reclam=" + Id_reclam + ", Nom_reclam=" + Nom_reclam + ", Prenom_reclam=" + Prenom_reclam + ", Adresse_reclam=" + Adresse_reclam + ", RECLAM=" + RECLAM + '}';
    }

   

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.Id_reclam;
       
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
        return this.Id_reclam == other.Id_reclam;
    }

   
   
}
  