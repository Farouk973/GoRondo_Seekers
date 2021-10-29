/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
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
public class AdmodifieruserController implements Initializable {

    @FXML
    private JFXTextField Nommod;
    @FXML
    private JFXTextField prenommod;
    @FXML
    private JFXTextField cinmod;
    @FXML
    private JFXTextField mailmod;
    @FXML
    private JFXTextField adressmod;
    @FXML
    private JFXPasswordField pswmod;
    @FXML
    private JFXTextField usernamemod;
    @FXML
    private JFXTextField telephonemod;
    @FXML
    private JFXComboBox sexemod;
    ObservableList<String> sexe = FXCollections.observableArrayList("Homme","Femme");
    @FXML
    private Label modifflabel;
    @FXML
    private JFXTextField agemod;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexemod.setValue("Homme");
        sexemod.setItems(sexe);
    }    

    @FXML
    private void Enregistrermod(ActionEvent event) {
        users.services.getcinamodifier S=new users.services.getcinamodifier();
        String cin_part=S.getId();
        System.out.println(cin_part);
        String nom = Nommod.getText();
        String prenom = prenommod.getText();
        String cin = cinmod.getText();
        String mail = mailmod.getText();
        //String dat_nai = dat_nai_par.getText();
        String adress = adressmod.getText();
        String psw = pswmod.getText();
        String username = usernamemod.getText();
        String tel = telephonemod.getText();
        String age = agemod.getText();
        String sexe = (String) sexemod.getValue();
        controlsaisir t =new controlsaisir();
        participantcontroller t1 =new participantcontroller();
        if (t1.Recherchercin(cin)==1){modifflabel.setText("set un autre cin!");}
        else if (t1.Recherchertel(tel)==1){modifflabel.setText("set un autre tel!");}
        else if (t1.Recherchermail(mail)==1){modifflabel.setText("set un autre mail!");}
        else if (t1.Rechercherusername(username)==1){modifflabel.setText("set un autre username!");}
        else if (t.csaisie(nom, prenom, cin, mail, adress, psw, username, age, tel, modifflabel)){
        participantcontroller ps = new participantcontroller();
        ps.modifierParticipant1(cin_part, cin, nom, prenom, sexe,age, username, psw, tel, adress, mail, adress);
        modifflabel.setText("bien modifier!!!");
        }
        
    }

    @FXML
    private void resetmod(ActionEvent event) {
        cinmod.setText("");
        Nommod.setText("");
        prenommod.setText("");
        telephonemod.setText("");
        mailmod.setText("");
        adressmod.setText("");
        pswmod.setText("");
        usernamemod.setText("");
        agemod.setText("");
        sexemod.setValue("Homme");
    }

    @FXML
    private void backmod(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin1.fxml"));
            try{
            Parent root= loader.load();
            Nommod.getScene().setRoot(root);
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
    }
    
}
