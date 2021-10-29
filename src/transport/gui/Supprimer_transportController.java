/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import transport.entities.transport;
import transport.services.transportService;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class Supprimer_transportController implements Initializable {

    
    @FXML
    private JFXButton ftbutton2;
    @FXML
    private JFXTextField tfid2;
    @FXML
    private JFXButton ftbuttonback2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savetransport2(ActionEvent event) {
        
      int id = Integer.parseInt(tfid2.getText());        
        

        transport t = new transport();
        
        transportService tr = new transportService();
        
        tr.supprimertransport(id);
        
        
        
        
    }

    @FXML
    private void back2(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transport.fxml"));
            try {
            Parent root= loader.load();  
            TransportController atc = loader.getController ();
            ftbuttonback2.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

    
}
       