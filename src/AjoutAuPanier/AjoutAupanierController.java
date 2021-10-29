/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AjoutAuPanier;

import AffichageEquipement.AfficherProduitsController;
import Service.ProduitService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author belha
 */
public class AjoutAupanierController implements Initializable {

    @FXML
    private Label fournisseurLabel;
    @FXML
    private DatePicker dateDe;
    @FXML
    private Label numerolabel;
    @FXML
    private DatePicker dateJusqu;
    @FXML
    private JFXButton ajoutAupanierbtn;
    @FXML
    private Label NomProduit;
    @FXML
    private Label prixProduit;
    @FXML
    private Label descriptionProduit;
    @FXML
    private Label marqueProduit;
    @FXML
    private JFXButton RtourD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Service.InfoIdEquipement S=new Service.InfoIdEquipement();
        System.out.println(S.getIdEquipement());
        ProduitService p=new ProduitService();
        Connection conn = p.cnx;
        PreparedStatement ste;
        String sql = "select * from equipement where Id_Produit="+S.getIdEquipement();
        try {
            ste = conn.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                NomProduit.setText(rs.getString(2));
                marqueProduit.setText(rs.getString(3));
                prixProduit.setText(rs.getString(5));
                descriptionProduit.setText(rs.getString(6));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AjoutAupanierController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }   

    private void RetourAffichageEquipement(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/AffichageEquipement/AfficherProduits.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AjouteAuPanier(ActionEvent event) {
    }

    @FXML
    private void DateDeChange(ActionEvent event) {
        int a=Integer.parseInt(dateDe.getValue().getYear()+dateDe.getValue().toString().substring(5, 7)+dateDe.getValue().toString().substring(8, 10));
        
        try{
            int b=Integer.parseInt(dateJusqu.getValue().getYear()+dateJusqu.getValue().toString().substring(5, 7)+dateJusqu.getValue().toString().substring(8, 10));
            
            if (a>b)
                ajoutAupanierbtn.setDisable(true);
            else {
                ajoutAupanierbtn.setDisable(false);
            }
        }
        catch (Exception e){
            
        }
        
    }

    @FXML
    private void DateJusquChange(ActionEvent event) {
        int b=Integer.parseInt(dateJusqu.getValue().getYear()+dateJusqu.getValue().toString().substring(5, 7)+dateJusqu.getValue().toString().substring(8, 10));
        
        try{
            int a=Integer.parseInt(dateDe.getValue().getYear()+dateDe.getValue().toString().substring(5, 7)+dateDe.getValue().toString().substring(8, 10));
            
            if (a>b)
                ajoutAupanierbtn.setDisable(true);
            else {
                ajoutAupanierbtn.setDisable(false);
            }
        }
        catch (Exception e){
            
        }
    }

    @FXML
    private void ProfilProduit(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/ProfilClient/Profilclient.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RtourD(ActionEvent event) {
            try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/AffichageEquipement/AfficherProduits.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
