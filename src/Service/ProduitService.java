/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import Entité.Produit;
import connexion.MaConnexion;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author belha
 */
public class ProduitService {
     public Connection cnx;
     public PreparedStatement ste;
    public ProduitService() {
    cnx = MaConnexion.getInstance().getconnection();
    }
    public void ajouterProduit(Produit p)  {
         
        
        try {
            String sql = "insert into equipement (Nom_Produit,Marque_Produit,Categorie_Produit,Prix_Produit,Desc_Produit,Id_participant,SousCategory,nombre,stockDisponible,Disponibility)" + "values(?,?,?,?,?,?,?,?,?,?)";
            ste=cnx.prepareStatement(sql);
            ste.setString(1, p.getNom_Produit());

            ste.setString(2, p.getMarque_Produit());
            ste.setString(3, p.getCategorie_Produit());
            ste.setInt(4, p.getPrix_Produit());
            ste.setString(5, p.getDesc_Produit());
            ste.setString(6, "5555555");
            ste.setString(7, p.getSousCategory_Produit());
            ste.setInt(8, p.getNombre_Produit());
            ste.setInt(9, p.getNombre_Produit());
            ste.setInt(10, 1);
            System.out.println(ste);
            ste.executeUpdate();
        }
        catch (SQLException ex) 
        { 
            System.out.println(ex);
        }
    }
  /*
  public void ajouterProduit(Produit p){
        try {
            String req = "INSERT INTO Produit (Id_Produit,Nom_Produit,Marque_Produit,Categorie_Produit,Prix_Produit) values (?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
          ste.setInt(1, p.getId_Produit());
      ste.setString(2, p.getNom_Produit());
      ste.setString(3, p.getMarque_Produit());
      ste.setString(4, p.getCategorie_Produit());
      ste.setInt(5, p.getPrix_Produit());
      
      
            pst.executeUpdate();
            System.out.println("equipement added !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  */
  
  public void modifierProduit(int id,Produit p)  {
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
      String sql = "UPDATE equipement SET Nom_Produit= '"+p.getNom_Produit()+"',Marque_Produit='"+p.getMarque_Produit()+"',Categorie_Produit='"+p.getCategorie_Produit()+"',Prix_Produit='"+p.getPrix_Produit()+"',Desc_Produit='"+p.getDesc_Produit()+"',Id_participant='5555555',SousCategory='"+p.getSousCategory_Produit()+"',nombre="+p.getNombre_Produit()+",stockDisponible="+p.getNombre_Produit()+",Disponibility=1 WHERE Id_Produit ="+id;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    
      
    public void supprimerProduit()  {
        try {
        System.out.println("entre l Id de produit a supprimer");
        Scanner sc5 = new Scanner(System.in);
        String f = sc5.nextLine();
      
      String sql = "delete from equipement where Id_Produit="+f;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
 
public void afficherProduit() throws SQLException 
{ 
    List<Produit> pr = new ArrayList<>();
        try {

String sql = "Select * from equipement ";
ResultSet rs;
ste=cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    Produit p = new Produit ();
    p.setId_Produit(rs.getInt(1));
    p.setNom_Produit(rs.getString(2));
    p.setMarque_Produit(rs.getString(3));
    p.setCategorie_Produit(rs.getString(4));
    p.setPrix_Produit(rs.getInt(5));
    pr.add(p);
}}
catch (SQLException ex) {Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(pr);
}
    
}
