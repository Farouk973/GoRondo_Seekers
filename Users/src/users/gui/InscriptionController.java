/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.gui;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import users.entities.participant;
import users.services.controlsaisir;
import users.services.participantcontroller;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InscriptionController implements Initializable {

    @FXML
    private JFXTextField nom_par;
    @FXML
    private JFXTextField prenom_par;
    @FXML
    private JFXTextField cin_par;
    @FXML
    private JFXTextField email_par;
    @FXML
    private JFXTextField username_par;
    @FXML
    private JFXTextField psw_par;
    @FXML
    private JFXTextField telephone_par;
    @FXML
    private JFXTextField adress_par;
    @FXML
    private JFXComboBox sexe_par;
    
    ObservableList<String> sexe = FXCollections.observableArrayList("Homme","Femme");
    @FXML
    private Label inscrilabel;
    @FXML
    private JFXTextField age_par;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sexe_par.setValue("Homme");
        sexe_par.setItems(sexe);
    }    

    @FXML
    private void backinscription(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            try{
            Parent root= loader.load();
            nom_par.getScene().setRoot(root);
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
    }

    @FXML
    private void reset(ActionEvent event) {
        cin_par.setText("");
        nom_par.setText("");
        prenom_par.setText("");
        telephone_par.setText("");
        email_par.setText("");
        adress_par.setText("");
        psw_par.setText("");
        username_par.setText("");
        sexe_par.setValue("Homme");
        age_par.setText("");
    }

    @FXML
    private void inscription(ActionEvent event) {
        String nom = nom_par.getText();
        String prenom = prenom_par.getText();
        String cin = cin_par.getText();
        String mail = email_par.getText();
        String age = age_par.getText();
        String adress = adress_par.getText();
        String psw = psw_par.getText();
        String username = username_par.getText();
        String tel = telephone_par.getText();
        String sexe = (String) sexe_par.getValue();
        controlsaisir t =new controlsaisir();
        participantcontroller t1 =new participantcontroller();
        if (t1.Recherchercin(cin)==1){inscrilabel.setText("set un autre cin!");}
        else if (t1.Recherchertel(tel)==1){inscrilabel.setText("set un autre tel!");}
        else if (t1.Recherchermail(mail)==1){inscrilabel.setText("set un autre mail!");}
        else if (t1.Rechercherusername(username)==1){inscrilabel.setText("set un autre username!");}
        else if (t.csaisie(nom, prenom, cin, mail, adress, psw, username, age, tel, inscrilabel)){
        participantcontroller ps = new participantcontroller();
        participant p = new participant(cin,nom, prenom,sexe,age,username,psw,tel,adress,mail,"gorando");
        ps.ajouterParticipant(p);
        inscrilabel.setText("bien enregistrer!!!");
        }
    }
    
}
