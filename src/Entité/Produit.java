/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

/**
 *
 * @author belha
 */
public class Produit {
    private int Id_Produit ;
    private String Nom_Produit ;
    private String Marque_Produit ;
    private String Categorie_Produit ;
    private int Prix_Produit ;
    private String Desc_Produit;
    private String sousCategory_Produit;
    private int Nombre_Produit;
    public Produit() {
        
    }
    public Produit(String Nom_Produit, String Marque_Produit, String Categorie_Produit, int Prix_Produit, String Desc_Produit, String sousCategory_Produit, int Nombre_Produit) {
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
        this.Desc_Produit = Desc_Produit;
        this.sousCategory_Produit = sousCategory_Produit;
        this.Nombre_Produit = Nombre_Produit;
    }
    public String getSousCategory_Produit() {
        return sousCategory_Produit;
    }

    public void setSousCategory_Produit(String sousCategory_Produit) {
        this.sousCategory_Produit = sousCategory_Produit;
    }

    public int getNombre_Produit() {
        return Nombre_Produit;
    }

    public void setNombre_Produit(int Nombre_Produit) {
        this.Nombre_Produit = Nombre_Produit;
    }

    


    public String getDesc_Produit() {
        return Desc_Produit;
    }

    public void setDesc_Produit(String Desc_Produit) {
        this.Desc_Produit = Desc_Produit;
    }

    public int getId_Produit() {
        return Id_Produit;
    }

    public String getNom_Produit() {
        return Nom_Produit;
    }

    public String getMarque_Produit() {
        return Marque_Produit;
    }

    public String getCategorie_Produit() {
        return Categorie_Produit;
    }



    public void setId_Produit(int Id_Produit) {
        this.Id_Produit = Id_Produit;
    }

    public void setNom_Produit(String Nom_Produit) {
        this.Nom_Produit = Nom_Produit;
    }

    public void setMarque_Produit(String Marque_Produit) {
        this.Marque_Produit = Marque_Produit;
    }

    public void setCategorie_Produit(String Categorie_Produit) {
        this.Categorie_Produit = Categorie_Produit;
    }

    public int getPrix_Produit() {
        return Prix_Produit;
    }

    public void setPrix_Produit(int Prix_Produit) {
        this.Prix_Produit = Prix_Produit;
    }

 

    @Override
    public String toString() {
        return "Produit{" + "Id_Produit=" + Id_Produit + ", Nom_Produit=" + Nom_Produit + ", Marque_Produit=" + Marque_Produit + ", Categorie_Produit=" + Categorie_Produit + ", Prix_Produit=" + Prix_Produit + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.Id_Produit;
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
        final Produit other = (Produit) obj;
        if (this.Id_Produit != other.Id_Produit) {
            return false;
        }
        return true;
    }


    }

