/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payer.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import payer.esprit.entities.Produits;
import payer.esprit.services.ServicesPanier;

/**
 * FXML Controller class
 *
 * @author Utilisateur
 */
public class AjouterPanierTestController implements Initializable {

    @FXML
    public TextField test_id_panier;
    @FXML
    private Button btn_test_id_panier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void getProduitByIdProduit(ActionEvent event) {
        int id = Integer.parseInt(test_id_panier.getText());
        Produits prd = new Produits();
        ServicesPanier sp = new ServicesPanier();
        
        sp.getProduitById(id);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_panier.fxml"));
        try {
            Parent root = loader.load();
            
            Interface_panierController intfP = loader.getController();
            
            intfP.setNomProduit(sp.getProduitById(id).getNom_produit());
            intfP.setTypeProduit(sp.getProduitById(id).getType());
            intfP.setPrixProduit(sp.getProduitById(id).getPrix_unitaire()+"");
            
            test_id_panier.getScene().setRoot(root);
            
           } catch (IOException ex) {
               System.err.println(ex.getMessage());
           }
        
                
        
        
    }
    
}
