/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payer.esprit.entities;

/**
 *
 * @author Utilisateur
 */
public class Produits {

    private int id_produit;
    private String nom_produit;
    private String type;
    private int prix_unitaire;

    public Produits(int id_produit, String nom_produit, String type, int prix_unitaire) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.type = type;
        this.prix_unitaire = prix_unitaire;
    }

    public Produits() {
    }

    public Produits(String nom_produit, String type, int prix_unitaire) {
        this.nom_produit = nom_produit;
        this.type = type;
        this.prix_unitaire = prix_unitaire;
    }

    public Produits(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(int prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    @Override
    public String toString() {
        return "produit{" + "id_produit=" + id_produit + ", nom_produit=" + nom_produit + ", type=" + type + ", prix_unitaire=" + prix_unitaire + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_produit;
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
        final Produits other = (Produits) obj;
        if (this.id_produit != other.id_produit) {
            return false;
        }
        return true;
    }
     
    
}
