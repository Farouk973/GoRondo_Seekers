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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    
    public void ajoutertransport(transport t){
        try {
            String req = "INSERT INTO transport_ (id,prix,type,disponibilite,id_groupe,destination,stock,image) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1, t.getId());
            pst.setFloat(2, t.getPrix());
            pst.setString(3, t.getType());
            pst.setString(4, t.getDisponibilite());
            pst.setString(5, t.getId_groupe());
            pst.setString(6, t.getDestination());
            pst.setInt(7, t.getStock());
            pst.setInt(8, t.getImage());
            
            System.out.println("Transport added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    
    
    
    public void modifiertransport()  {
        System.out.println("entre Id de transport a Modifier");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println("entre le transport a Modifier");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE produit SET Nom_transport ='"+b+"' WHERE transport.`Id_transport` ="+a;
            PreparedStatement ste = cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}


    public void supprimertransport()  {
        try {
        System.out.println("entre l Id de transport a supprimer");
        Scanner sc5 = new Scanner(System.in);
        String f = sc5.nextLine();

      String sql = "delete from transport where Id_transport="+f;
            PreparedStatement ste = cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}

public void affichertransport() throws SQLException
{
    List<transport> tr = new ArrayList<>();
        try {

String sql = "Select * from transport ";
ResultSet rs;
        PreparedStatement ste = cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    transport t = new transport ();
    t.setId_tr(rs.getInt(1));
    t.setPrix_tr(rs.getFloat(2));
    t.setType_tr(rs.getString(3));
    t.setDisponibilite_tr(rs.getString(4));
    t.setId_groupe_tr(rs.getString(5));
    t.setDestination_tr(rs.getString(6));
    t.setStock_tr(rs.getInt(7));
    t.setImage_tr(rs.getInt(8));
    
    tr.add(t);
}}
catch (SQLException ex) {Logger.getLogger(transportService.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(tr);
}

   

}
    
    
    
