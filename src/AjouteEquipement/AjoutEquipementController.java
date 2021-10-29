/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AjouteEquipement;

import AffichageEquipement.AfficherProduitsController;
import Entité.Produit;
import Service.ProduitService;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author belha
 */
public class AjoutEquipementController implements Initializable {

    @FXML
    private TextArea NOMd;
    @FXML
    private TextArea MARQUEd;
    @FXML
    private TextArea PRIXd;
    @FXML
    private JFXButton ajouter;
    @FXML
    private TextArea Dscd;
    @FXML
    private Spinner<String> NombreProduitd;
    @FXML
    private TextArea sousCategoryd;
    @FXML
    private ComboBox<String> categoryd;
    @FXML
    private JFXButton RtoureB;
    @FXML
    private JFXButton RtoureB1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Beach","Sahara","Forest");
        categoryd.setItems(list);
        ObservableList<String> months = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
        SpinnerValueFactory<String> valueFactory =new SpinnerValueFactory.ListSpinnerValueFactory<String>(months);
        NombreProduitd.setValueFactory(valueFactory);
        // TODO
    }    

    @FXML
    private void Ajouterp(ActionEvent event) {
        
        
        String nom = NOMd.getText();
        String marque = MARQUEd.getText();
        String Dsc = Dscd.getText();
        String category=categoryd.getValue();
        String SousCat= sousCategoryd.getText();
        int nombre=Integer.parseInt(NombreProduitd.getValue());
        int prix = Integer.parseInt(PRIXd.getText());
     
        Produit p =new Produit(nom,marque,category,prix,Dsc,SousCat,nombre);
        
        ProduitService ps1=new ProduitService();
        ps1.ajouterProduit(p);
       
    }

    @FXML
    private void RtoureB(ActionEvent event) {
           try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/CategoryEquipement/Categoryequipement.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    private void ProfilProduit(ActionEvent event) {
    }
    
}
