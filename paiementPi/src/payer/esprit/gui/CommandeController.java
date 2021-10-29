/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payer.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import payer.esprit.utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class CommandeController implements Initializable {

    ObservableList list = FXCollections.observableArrayList();
    
    
    @FXML
    private TextField txt_montant_commande;
    @FXML
    private TextField txt_remarques_commande;
    @FXML
    private Button btn_enrg_commande;
    @FXML
    private TextField txt_cin_commande;
    @FXML
    private TextField txt_produit_commande;
    @FXML
    private Button btn_retour_commande;
    @FXML
    private Button btn_accueil_commande;
    @FXML
    private Label label_empty_commande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        payer.esprit.services.serviceAcheter S=new payer.esprit.services.serviceAcheter();
        txt_produit_commande.setText(S.getNom());
        txt_montant_commande.setText( Float.toString(S.getPrix()));
    }    

    @FXML
    private void getEngBase(ActionEvent event) {
        try {
        Connection cnx;
        cnx = MyConnection.getmyCnx().getCnx();
        
        String sql="INSERT INTO commande (nom_produit_commande,montant,cin_user,remarque) values ('"+txt_produit_commande.getText()+"',"+Float.parseFloat(txt_montant_commande.getText())+",'"+txt_cin_commande.getText()+"','"+txt_remarques_commande.getText()+"')";
        Statement ps;
        
            ps = (Statement)cnx.createStatement();
            ps.executeUpdate(sql);
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        label_empty_commande.setText("Votre commande est enregistrée");
                
    }
    
     public void setNomProduitCommande(String msg) {
        
        this.txt_produit_commande.setText(msg);
        
        }
     
     public void setPrixCommande(String msg) {
        
        this.txt_montant_commande.setText(msg);
        
        }
        
@FXML
    private void getRetourCommande(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_panier.fxml"));
        try {
            Parent root = loader.load();
            
            txt_produit_commande.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());;
        }
    }

    @FXML
    private void getAccueilRetour(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterPanierTest.fxml"));
        try {
            Parent root = loader.load();
            
            txt_produit_commande.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());;
        }
    }

}

    
     
   
