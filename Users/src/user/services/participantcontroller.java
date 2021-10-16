/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
//import edu.esprit.entities.Personne;
//import edu.esprit.utils.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import user.entities.participant;
import user.util.MyConnection;
/**
 *
 * @author HP
 */
public class participantcontroller {
    private Connection cnx;
    public participantcontroller (){
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    public void ajouterParticipant (participant p){
        try {
            String req = "INSERT INTO participant (cin_par,nom_par,prenom_par,sexe_par,username_par,mdp_par,numtel_par,adress_par,mail_par,id_group) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, p.getCin_par());
            pst.setString(2, p.getNom_par());
            pst.setString(3, p.getPrenom_par());
            pst.setString(4, p.getSexe_par());
            pst.setString(5, p.getUsername_par());
            pst.setString(6, p.getMdp_par());
            pst.setString(7, p.getNumtel_par());
            pst.setString(8, p.getAdress_par());
            pst.setString(9, p.getMail_par());
            //pst.setDate(10, p.getDate_nai_par());
            pst.setString(10, p.getId_group_par());
            pst.executeUpdate();
            System.out.println("Participant added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    /*public void modifierParticipant (participant p){
        String req="update participant set cin_par=?,nom_par=?,prenom_par=?,sexe_par=?,username_par=?,mdp_par=?,numtel_par=?,adress_par=?,mail_par=?,id_group=? where cin_par=? " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, p.getCin_par());
            pst.setString(2, p.getNom_par());
            pst.setString(3, p.getPrenom_par());
            pst.setString(4, p.getSexe_par());
            pst.setString(5, p.getUsername_par());
            pst.setString(6, p.getMdp_par());
            pst.setString(7, p.getNumtel_par());
            pst.setString(8, p.getAdress_par());
            pst.setString(9, p.getMail_par());
            //pst.setDate(10, p.getDate_nai_par());
            pst.setString(10, p.getId_group_par());
            pst.setString(11, p.getCin_prev());
            pst.executeUpdate (); 
           System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
        
    }*/
    public void modifierParticipant1(String cin0,String cin, String nom, String prenom, String sexe, String username, String mdp, String numtel, String adress, String mail, String id_group){
                try {
                    String req = "update participant set cin_par='"+cin+"',nom_par='"+nom+"',prenom_par='"+prenom+"',sexe_par='"+sexe+"',username_par='"+username+"',mdp_par='"+mdp+"',numtel_par='"+numtel+"',adress_par='"+adress+"',mail_par='"+mail+"',id_group='"+id_group+"' where cin_par= "+cin0 ;
                    PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);

                    pst.executeUpdate(req);
                    System.out.println("bilan updated !");
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            }
    public void supprimerParticipant(String cin) {

        String req = "delete from participant where cin_par=?";
        try {
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setString(1, cin);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    public List<participant> getParticipant(){
        List<participant> participant = new ArrayList<>();
        try {
            String req = "Select * from participant";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                participant p = new participant(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),/* rs.getDate(5),*/ rs.getString(6),rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
                participant.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return participant;
    }
    
    
    
}
