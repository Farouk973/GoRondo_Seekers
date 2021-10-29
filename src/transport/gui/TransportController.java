/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class TransportController implements Initializable {
    Connection cnx ;
    PreparedStatement pst;
    @FXML
    private JFXButton tfajout;
    @FXML
    private JFXButton tfmodife;
    @FXML
    private JFXButton tfsupp;
    @FXML
    private JFXButton tfaffiche;
   
    public void Connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/tr","root","");
            } catch (SQLException ex) {
               
            }


        }
        catch (ClassNotFoundException ex) {}
       

    
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutertransport(ActionEvent event) {
        
        
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajouter_transport.fxml"));
            try {
            Parent root= loader.load();  
            AjouterTransportController atc = loader.getController ();
            tfajout.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
            
        
        

         
        }

    @FXML
    private void modifiertransport(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifier_Transport.fxml"));
            try {
            Parent root= loader.load();  
            Modifier_TransportController atc = loader.getController ();
            tfmodife.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

    @FXML
    private void supprimertransport(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Supprimer_transport.fxml"));
            try {
            Parent root= loader.load();  
            Supprimer_transportController atc = loader.getController ();
            tfsupp.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

    @FXML
    private void affichertransport(ActionEvent event) throws IOException {
              

          Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/transport/gui/afficher_transport.fxml")));
            stage.setScene(scene);
            stage.show();
   
            
        
            
        }
    }



        
        
        
    

   
    


