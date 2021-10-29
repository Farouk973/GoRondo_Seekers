/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.gui;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import users.services.participantcontroller;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Admodifier1userController implements Initializable {

    @FXML
    private JFXTextField Cinamodifier;
    @FXML
    private Label modifier1label;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
    @FXML
    private void check_modifier(ActionEvent event) {
        
        
        participantcontroller p = new participantcontroller();
        String  cinaa=Cinamodifier.getText();
        users.services.getcinamodifier S=new users.services.getcinamodifier();
        S.setId(cinaa);
        if (p.Recherchercin(cinaa)==0){
            modifier1label.setText("ce participant n'existe pas");
        }
        if(p.Recherchercin(cinaa)==1) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admodifieruser.fxml"));
            try{
            Parent root= loader.load();
            modifier1label.getScene().setRoot(root);
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        
        
            
        }
        
    }

   

    
    
}
    

