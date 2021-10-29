/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.gui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import users.entities.participant;
import users.services.controlsaisir;
import users.services.participantcontroller;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AdajouteruserController implements Initializable {

    @FXML
    private JFXTextField nom_par;
    @FXML
    private JFXTextField prenom_par;
    @FXML
    private JFXTextField cin_par;
    @FXML
    private JFXTextField mail_par;
    @FXML
    private JFXTextField adress_par;
    @FXML
    private JFXPasswordField psw_par;
    @FXML
    private JFXTextField username_par;
    @FXML
    private JFXTextField tel_par;
    @FXML
    private JFXComboBox sexe_par;
    ObservableList<String> sexe = FXCollections.observableArrayList("Homme","Femme");
    @FXML
    private Label ajouterlabel;
    @FXML
    private static AnchorPane ap1;
    @FXML
    private JFXTextField age_par;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexe_par.setValue("Homme");
        sexe_par.setItems(sexe);
    }  
    
    

    @FXML
    private void enregistrer_par(ActionEvent event) {
        String nom = nom_par.getText();
        String prenom = prenom_par.getText();
        String cin = cin_par.getText();
        String mail = mail_par.getText();
        String adress = adress_par.getText();
        String psw = psw_par.getText();
        String username = username_par.getText();
        String age = age_par.getText();
        String tel = tel_par.getText();
        String sexe = (String) sexe_par.getValue();
        controlsaisir t =new controlsaisir();
        participantcontroller t1 =new participantcontroller();
        if (t1.Recherchercin(cin)==1){ajouterlabel.setText("set un autre cin!");}
        else if (t1.Recherchertel(tel)==1){ajouterlabel.setText("set un autre tel!");}
        else if (t1.Recherchermail(mail)==1){ajouterlabel.setText("set un autre mail!");}
        else if (t1.Rechercherusername(username)==1){ajouterlabel.setText("set un autre username!");}
        else if (t.csaisie(nom, prenom, cin, mail, adress, psw, username, age, tel, ajouterlabel)){
        participantcontroller ps = new participantcontroller();
        participant p = new participant(cin,nom, prenom,sexe,age,username,psw,tel,adress,mail,"gorando");
        ps.ajouterParticipant(p);
        ajouterlabel.setText("bien enregistrer!!!");
        }
    }

    @FXML
    private void reset_par(ActionEvent event) {
        cin_par.setText("");
        nom_par.setText("");
        prenom_par.setText("");
        tel_par.setText("");
        mail_par.setText("");
        adress_par.setText("");
        psw_par.setText("");
        username_par.setText("");
        sexe_par.setValue("homme");
        age_par.setText("");
    }

    
    
    
}
