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
     private int Id_gagnant;
    private String Nom_gagnant;
    private String Prenom_gagnant;
    private String Adresse;
  
    public Gagnant() {
    }

    /**
     *
     * @param Id_gagnant
     * @param Nom_gagnant
     * @param Prenom_gagnant
     * @param Adresse
     */
    public Gagnant(int Id_gagnant, String Nom_gagnant, String Prenom_gagnant,String Adresse) {
        this.Id_gagnant = Id_gagnant;
        this.Nom_gagnant =Nom_gagnant;
        this.Prenom_gagnant = Prenom_gagnant;
        this.Adresse= Adresse;
       
    }

  
 

    public int getId_gagnant() {
        return Id_gagnant;
    }

    public String getNom_gagnant() {
        return Nom_gagnant;
    }

    public String getPrenom_gagnant() {
        return Prenom_gagnant;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setId_gagnant(int Id_gagnant) {
        this.Id_gagnant = Id_gagnant;
    }

    public void setNom_gagnant(String Nom_gagnant) {
        this.Nom_gagnant = Nom_gagnant;
    }

    public void setPrenom_gagnant(String Prenom_gagnant) {
        this.Prenom_gagnant = Prenom_gagnant;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    @Override
    public String toString() {
        return "Gagnant{" + "Id_gagnant=" + Id_gagnant + ", Nom_gagnant=" + Nom_gagnant + ", Prenom_gagnant=" + Prenom_gagnant + ", Adresse=" + Adresse + '}';
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.Id_gagnant;
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
        return this.Id_gagnant == other.Id_gagnant;
    }

  
}

