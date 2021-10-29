/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport.services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import transport.entities.transport;
import transport.utils.MyConnection;

/**
 *
 * @author PC
 */
public class transportService {
    private Connection cnx;

    public transportService() {
        cnx = MyConnection.getMyCnx().getConnection();
    }
    
    /*public ObservableList<transport> search(String cas) throws SQLException {
                            ObservableList<transport> list = FXCollections.observableArrayList();

            String requete = "select * from transport_ where  id_tr LIKE '%" + cas + "%' or prix_tr LIKE '%" + cas+ "%' or type_tr LIKE '%" + cas + "%' or disponiblite_tr LIKE '%" + cas+ "%' or id_groupe_tr LIKE '%" + cas+ "%' or destination_tr LIKE '%"+ cas+ "%' or stock_tr LIKE '%"+ cas+ "%' or image_tr LIKE '%"+ cas + "%' ";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet tr = ps.executeQuery();

            while (tr.next()) {
        
list.add(new transport(tr.getInt("id_tr"),tr.getFloat("prix_tr"),tr.getString("type_tr"),tr.getString("disponiblite_tr"),tr.getString("id_groupe_tr"),tr.getString("destination_tr"),tr.getInt("stock_tr"),tr.getString("image_tr")));
             
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return list;
    
    
    
    
    
    
    
    }*/
    public void ajoutertransport(transport t){
        try {
            String req = "INSERT INTO transport_ (prix_tr,type_tr,disponiblite_tr,id_groupe_tr,destination_tr,stock_tr,image_tr) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setFloat(1, t.getPrix());
            pst.setString(2, t.getType());
            pst.setString(3, t.getDisponibilite());
            pst.setString(4, t.getId_groupe());
            pst.setString(5, t.getDestination());
            pst.setInt(6, t.getStock());
            pst.setString(7, t.getImage());
            pst.executeUpdate();
            
            System.out.println("Transport added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
      
    public void modifiertransport(transport t)  {
        String req="update transport_ set prix_tr=?,type_tr=?,disponiblite_tr=?,id_groupe_tr=?,destination_tr=?,stock_tr=?,image_tr=? where id_tr=? " ;
        try { 
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setFloat(1, t.getPrix());
            pst.setString(2, t.getType());
            pst.setString(3, t.getDisponibilite());
            pst.setString(4, t.getId_groupe());
            pst.setString(5, t.getDestination());
            pst.setInt(6, t.getStock());
            pst.setString(7, t.getImage());
            pst.setInt(8,t.getId());
            pst.executeUpdate (); 
           System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
        
}


    public void supprimertransport(int id_tr)  {
    String req = "delete from transport_ where id_tr=?";
        try {
             PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1, id_tr);
            pst.executeUpdate();
            System.out.println("Suppression effectuée avec succès");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
}
   public transport getTransport(int i)
   {
       transport t = new transport();
        int nombre = 0;
      String requete = "SELECT * FROM transport_"       ;
         try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (i == nombre) {
                  
    t.setPrix(rs.getFloat("prix_tr"));
    t.setType(rs.getString("type_tr"));
     
    t.setDisponibilite(rs.getString("disponiblite_tr"));
    t.setId_groupe(rs.getString("id_groupe_tr"));
    t.setDestination(rs.getString("destination_tr"));
    t.setStock(rs.getInt("stock_tr"));
     
               
                }
                nombre++;
                         }

        } catch (SQLException ex) {
            System.out.println(ex.getCause());
        }
        return t;
   }
public ObservableList<transport> affichertransport() throws SQLException
{
 
       ObservableList<transport> tr = FXCollections.observableArrayList();
        try {
        

String sql = "Select * from transport_ ";
ResultSet rs;
        PreparedStatement ste = cnx.prepareStatement(sql);
rs = ste.executeQuery();
  
while (rs.next()){
    transport t = new transport ();
    t.setId(rs.getInt("id_tr"));
    t.setPrix(rs.getFloat("prix_tr"));
    t.setType(rs.getString("type_tr"));
    t.setDisponibilite(rs.getString("disponiblite_tr"));
    t.setId_groupe(rs.getString("id_groupe_tr"));
    t.setDestination(rs.getString("destination_tr"));
    t.setStock(rs.getInt("stock_tr"));

    
    tr.add(t);
}
        }
catch (SQLException ex) {


            System.out.println("erreur lors de l'affichage " + ex.getMessage());

}
        return tr;
}


}
    
        


    
    

    



   

    
   


    





    
    
