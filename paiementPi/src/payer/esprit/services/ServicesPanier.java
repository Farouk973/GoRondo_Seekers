/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payer.esprit.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import payer.esprit.entities.Produits;
import payer.esprit.utils.MyConnection;

/**
 *
 * @author Utilisateur
 */
public class ServicesPanier {
    private final Connection cnx;

    public ServicesPanier() {
        cnx = MyConnection.getmyCnx().getCnx();
    }
    
    public Produits getProduitById(int id) {
        Produits prd = new Produits();
        try {
            String req = "Select * from produitstatique where id_produit = '" + id + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()) {
                prd.setId_produit(rs.getInt(1));
                prd.setNom_produit(rs.getString(2));
                prd.setType(rs.getString(3));
                prd.setPrix_unitaire(rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return prd;
        
    }
    
    
    
    
//    public int CalculerPrix(int id, int qte) {
//        
//    }
   
    
}
