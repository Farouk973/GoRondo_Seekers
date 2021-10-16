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
import reclametgam.entities.Reclam;
import reclametgam.util.MyConnection;

/**
 *
 * @author user
 */
public class ReclamServices {
    private final Connection cnx;

    public ReclamServices() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    public void ajouterPersonne (Reclam r){
        try {
            String req = "INSERT INTO reclam (nom,prenom) values ('"+r.getNom()+"','"+r.getPrenom()+"')";
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void ajouterReclam(Reclam r){
        try {
            String req = "INSERT INTO personne (nom,prenom) values (?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, r.getNom());
            pst.setString(2, r.getPrenom());
            pst.executeUpdate();
            System.out.println("reclam added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Reclam> getReclam(){
        List<Reclam> Reclams = new ArrayList<>();
        try {
            String req;
            req = "Select * from reclam";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Reclam r = new Reclam(rs.getInt(1), rs.getString(2), rs.getString(3));
                Reclams.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Reclams;
    }
    public void modifierReclam (Reclam r){
        String req="update set id_reclam=?,nom_reclam=?,prenom_reclam=?,adresse=? " ;		
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, r.getNom());
            pst.setString(2, r.getPrenom());
           
            
           
            pst.executeUpdate (); 
           System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    
    }
    public void supprimerReclam ( String id_reclam) {

        String req = "delete from reclamation where id_reclam=?";
        try {
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, id_reclam);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    
}
