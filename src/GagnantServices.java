/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclametgam.services;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import reclametgam.entities.Gagnant;
import reclametgam.util.MyConnection;

/**
 *
 * @author user
 */
public class GagnantServices {
     private final Connection cnx;

    public GagnantServices() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    public void ajouterGagnant (Gagnant g){
        try {
            String req = "INSERT INTO reclam (nom,prenom) values ('"+g.getNom()+"','"+g.getPrenom()+"')";
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" gagnant added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void ajouterGagnant1(Gagnant g){
        try {
            String req = "INSERT INTO personne (nom,prenom) values (?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, g.getNom());
            pst.setString(2, g.getPrenom());
            pst.executeUpdate();
            System.out.println("gagnat added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Gagnant> getGagnant(){
        List<Gagnant> Gagnants = new ArrayList<>();
        try {
            String req = "Select * from gagnat";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Gagnant g = new Gagnant(rs.getInt(1), rs.getString(2), rs.getString(3));
                Gagnants.add(g);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Gagnants;
    }
     public void modifierGagnant (Gagnant g){
        String req="update set id_gagnant=?,nom_gagnant=?,prenom_gagnant=?,adresse=? " ;		
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, g.getNom());
            pst.setString(2, g.getPrenom());
           
            
           
            pst.executeUpdate (); 
           System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    
    }
    public void supprimerGagnat ( String id_gagnant) {

        String req = "delete from gagnant where id_gagnant=?";
        try {
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, id_gagnant);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    
}
