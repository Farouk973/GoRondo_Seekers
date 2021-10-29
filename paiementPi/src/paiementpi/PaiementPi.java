/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paiementpi;

import payer.esprit.services.ServicesPanier;
import payer.esprit.utils.MyConnection;

/**
 *
 * @author Utilisateur
 */
public class PaiementPi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyConnection.getmyCnx();
        ServicesPanier sp = new ServicesPanier();
        System.out.println(sp.getProduitById(13).getNom_produit());
    }
    
}
