/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.gui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField Username;
    @FXML
    private JFXPasswordField psw;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void connecteruser(ActionEvent event) {
        String Usernamee= Username.getText();
        String psww= psw.getText();
        if (Usernamee.equals("root")&&psww.equals("root")) {
            //System.out.println("hey");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin1.fxml"));
            try{
            Parent root= loader.load();
            Admin1Controller con = loader.getController();
            Username.getScene().setRoot(root);
            }catch(IOException ex){
                System.out.println(ex.getMessage());
    }
    }
    }

    @FXML
    private void inscrireuser(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("inscription.fxml"));
            try{
            Parent root= loader.load();
            Username.getScene().setRoot(root);
            }catch(IOException ex){
                System.out.println(ex.getMessage());
    }
    }
    }
    

