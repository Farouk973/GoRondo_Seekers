/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.gui;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import users.services.participantcontroller;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AdsupprimeruserController implements Initializable {

    @FXML
    private JFXTextField supptext;
    @FXML
    private Label supplabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adsupprimeruser(ActionEvent event) {
        String cin = supptext.getText();
        participantcontroller p = new participantcontroller();
        //participant p1 = new participant(cin, cin, cin, cin, cin, cin, cin, cin, cin, cin);
        
        if (p.Recherchercin(cin)==0){
            supplabel.setText("ce participant n'existe pas");
        }
        if(p.Recherchercin(cin)==1) {
            p.supprimerParticipant(cin);
            
            }
        }
        
    }
    
    

