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
    
    public void ajouterReclam (Reclam r){
        try {
            String req = "INSERT INTO reclamation (,Id_reclam,Nom_reclam,Prenom_reclam,RECLAM) values ('"+r.getId_reclam()+"','"+r.getNom_reclam()+"','"+r.getPrenom_reclam()+"','"+r.getAdresse_reclam()+"','"+r.getRECLAM()+"')";
            Statement st = (Statement) cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("reclamation added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @param r
     */
    public void ajouterReclam1 (Reclam r){
        try {
            String req = "INSERT INTO reclamation (Id_reclam,Nom_reclam,Prenom_reclam,Adresse_reclam,RECLAM) values (?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
             pst.setInt(1, r.getId_reclam());
            pst.setString(2, r.getNom_reclam());
            pst.setString(3, r.getPrenom_reclam());
             pst.setString(4, r.getAdresse_reclam());
            pst.setString(5, r.getRECLAM());
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
            req = "Select * from reclamation";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Reclam r = new Reclam(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
                Reclams.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Reclams;
    }
    public void modifierReclam (Reclam r){
        String req="update set Id_reclam=?,Nom_reclam=?,Prenom_reclam=?,Adresse_reclam=?,RECLAM=? " ;		
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
             pst.setInt(1, r.getId_reclam());
            pst.setString(1, r.getNom_reclam());
            pst.setString(2, r.getPrenom_reclam());
            pst.setString(3, r.getAdresse_reclam());
            pst.setString(3, r.getRECLAM());
           
            
           
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
