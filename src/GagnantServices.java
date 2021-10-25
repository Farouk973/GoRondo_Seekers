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
  
    /**
     *
     * @param g
     */
    public void ajouterGagnant(Gagnant g){
        try {
            String req = "INSERT INTO gagnants (Id_gagnant,Nom_gagnant,Prenom_gagnant,Adresse) values (?,?,?,?)";
            PreparedStatement pst;
            pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1, g.getId_gagnant());
            pst.setString(2, g.getNom_gagnant());
             pst.setString(3, g.getPrenom_gagnant());
            pst.setString(4, g.getAdresse());
            pst.executeUpdate();
            System.out.println("gagnant added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Gagnant> getGagnant(){
        List<Gagnant> Gagnants = new ArrayList<>();
        try {
            String req = "Select * from gagnants";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Gagnant g = new Gagnant(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
                Gagnants.add(g);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Gagnants;
    }
     public void modifierGagnant (Gagnant g){
        String req="update set Id_gagnant=?,Nom_gagnant=?,Prenom_gagnant=?,Adresse=? " ;		
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1, g.getId_gagnant());
            pst.setString(2, g.getNom_gagnant());
            pst.setString(3, g.getPrenom_gagnant());
            pst.setString(4,g.getAdresse());
            pst.executeUpdate (); 
           System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    
    }
    public void supprimerGagnant ( String nom_gagnant) {

        String req = "delete from gagnants where Id_gagnant=?";
        try {
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, nom_gagnant);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    
}
