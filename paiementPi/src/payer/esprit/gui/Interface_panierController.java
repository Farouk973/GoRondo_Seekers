/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payer.esprit.gui;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;
import payer.esprit.entities.Commande;
import payer.esprit.entities.Produits;
import payer.esprit.services.ServicesPanier;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class Interface_panierController implements Initializable {

    @FXML
    private Button btn_cancel_panier;
    @FXML
    private Button btn_acheter_panier;
    @FXML
    private TextField tf_prixtotale_panier;
    @FXML
    private TextField tf_produit_panier;
    @FXML
    private TextField tf_type_panier;
    @FXML
    private TextField tf_insererquantite_panier;
    @FXML
    private TextField tf_prixunitaire_panier;
    @FXML
    private Button btn_prixtotale_panier;
    @FXML
    private Button btn_consulter_commande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        // TODO
    }   
    
    public void setNomProduit(String msg) {
        
        this.tf_produit_panier.setText(msg);
        
        }
    public void setTypeProduit(String msg)
    {
     
        this.tf_type_panier.setText(msg);
    }
    
    public void setPrixProduit(String msg)
    {
     
        this.tf_prixunitaire_panier.setText(msg);
        
    }

  


 

    @FXML
    private void calc(ActionEvent event) {
           
         Integer qrix = Integer.valueOf(tf_prixunitaire_panier.getText());
           
         Integer qte = Integer.valueOf(tf_insererquantite_panier.getText());
         
         float somme=   qte*qrix;
         String s = Float.toString(somme);
      
       tf_prixtotale_panier.setText(s);
    }

    @FXML
    private void getCommande(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Commande.fxml"));
        try {
            Parent root = loader.load();
            
            tf_prixtotale_panier.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());;
        }
    }

    @FXML
    private void getRetour(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterPanierTest.fxml"));
        try {
            Parent root = loader.load();
            
            tf_prixtotale_panier.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());;
        }
    }

    @FXML
    private void getEng2(ActionEvent event) {
        
        //int id = Integer.parseInt(test_id_panier.getText());
        Produits prd = new Produits();
        ServicesPanier sp = new ServicesPanier();
        
        String nom=null;
        float prix_total=1;
        nom=tf_produit_panier.getText();
        prix_total=Float.parseFloat(tf_prixtotale_panier.getText());
        payer.esprit.services.serviceAcheter S=new payer.esprit.services.serviceAcheter();
        S.setNom(nom);
        S.setPrix(prix_total);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Commande.fxml"));
        try {
            Parent root = loader.load();
            
            tf_prixtotale_panier.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());;
        }
        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Commande.fxml"));
        try {
            Parent root = loader.load();
            
            CommandeController cc = loader.getController();
            
            cc.setNomProduit(sp.getProduitById(id).getNom_produit());
            cc.setTypeProduit(sp.getProduitById(id).getType());
            cc.setPrixProduit(sp.getProduitById(id).getPrix_unitaire()+"");
            
            test_id_panier.getScene().setRoot(root);
            
           } catch (IOException ex) {
               System.err.println(ex.getMessage());
           }*/
        
    }
    
    
    
}
