/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payer.esprit.services;

/**
 *
 * @author Utilisateur
 */
public class serviceAcheter {
    private static String nom;
    private static float prix;

    public serviceAcheter() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        serviceAcheter.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        serviceAcheter.prix = prix;
    }
    
}
