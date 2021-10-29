/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modiferproduit;

import AffichageEquipement.AfficherProduitsController;
import Entité.Produit;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author belha
 */
public class ModiferProduitController implements Initializable {

    @FXML
    private JFXButton ProfileM;
    @FXML
    private TextArea NOMd;
    @FXML
    private ComboBox <String> categoryd;
    @FXML
    private TextArea MARQUEd;
    @FXML
    private TextArea PRIXd;
    @FXML
    private JFXButton valide;
    @FXML
    private JFXButton modifer;
    @FXML
    private TextArea Dscd;
    @FXML
    private Spinner<String> NombreProduitd;
    @FXML
    private TextArea sousCategoryd;
    @FXML
    private JFXButton RtourM;

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
        ModifierProduit();
        // TODO
    }    
    public void ModifierProduit(){
        Service.sendIdToModifier S=new Service.sendIdToModifier();
        int id=S.getId();
       
        /*String nom = NOMd.getText();
        String marque = MARQUEd.getText();
        String Dsc = Dscd.getText();
        String category=categoryd.getValue();
        String SousCat= sousCategoryd.getText();
        int nombre=Integer.parseInt(NombreProduitd.getValue());
        int prix = Integer.parseInt(PRIXd.getText());*/
        
        ProduitService p=new ProduitService();
            Connection conn = p.cnx;
            PreparedStatement ste;
            String sql=null;
            sql = "select * from equipement  where Id_Produit = "+id;
        try {
            ste = conn.prepareStatement(sql);
            System.out.println(ste);
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()){
                NOMd.setText(rs.getString(2));
                
                categoryd.setValue(rs.getString(4));
                sousCategoryd.setText(rs.getString(8));
                MARQUEd.setText(rs.getString(3));
                PRIXd.setText(rs.getString(5));
                Dscd.setText(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModiferProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        //String sql="update candidate set Nom_Produit= nom ,Marque_Produit=marque, Category_Produit= category ,Prix_Produit= prix ,sousCategory=category ,nombre=nombre  where id = '"+id+"'";
        
    }


    @FXML
    private void CancelAjout(ActionEvent event) {
    }

    @FXML
    private void ModiferM(ActionEvent event) {
        String nom = NOMd.getText();
        String marque = MARQUEd.getText();
        String Dsc = Dscd.getText();
        String category=categoryd.getValue();
        String SousCat= sousCategoryd.getText();
        int nombre=Integer.parseInt(NombreProduitd.getValue());
        int prix = Integer.parseInt(PRIXd.getText());
        Service.sendIdToModifier S3=new Service.sendIdToModifier();
        
        Produit p =new Produit(nom,marque,category,prix,Dsc,SousCat,nombre);
        
        ProduitService ps1=new ProduitService();
        
        ps1.modifierProduit(S3.getId(),p);
     }

    @FXML
    private void RtourM(ActionEvent event) {
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
    private void ProfileM(ActionEvent event) {
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
    
}
