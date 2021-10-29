/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.gui;

import com.jfoenix.controls.JFXButton;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class Admin1Controller implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private BorderPane bp;
    @FXML
    private JFXButton Bar1;
    @FXML
    private JFXButton Bar2;
    @FXML
    private AnchorPane slider;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slider.setTranslateX(0);
        Bar1.setVisible(false);
        Bar2.setVisible(true);
        
    }    
    

    @FXML
    private void adAjouter(ActionEvent event) {
        loadPage("adajouteruser");
    }

    @FXML
    private void adSupprimer(ActionEvent event) {
        loadPage("adsupprimeruser");
    }

    @FXML
    private void AdModifier(ActionEvent event) {
        loadPage("admodifier1user");
    }
    @FXML
    private void affiche_menu(ActionEvent event) {
        loadPage("showusers");
    }
    public void loadPage (String page){
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        bp.setCenter(root);
    }

   /* Menu.setOnMouseClicked(event ->{
         TranslateTransition slide = new TranslateTransition();
         slide.setDuration(Duration.seconds(0.4));
         slide.setNode(slider);
         
         slide.setToX(8);
         slide.play();
         
         slider.setTranslateX(-176);
         slide.setOnFinished(ActionEvent e)->{
         Menu.setVisible(true);
         MenuClose.setVisible(false);
    });
    
    
    
    })*/
    

    @FXML
    private void Deconnectadmin(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            try{
            Parent root= loader.load();
            bp.getScene().setRoot(root);
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
    }

    @FXML
    private void run2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
         slide.setDuration(Duration.seconds(0.4));
         slide.setNode(slider);
         
         slide.setToX(-208);
         slide.play();
         slider.setTranslateX(0);
         
         Bar1.setVisible(true);
         Bar2.setVisible(false);
         
         TranslateTransition slide1 = new TranslateTransition();
         slide1.setDuration(Duration.seconds(0.4));
         slide1.setNode(bp.getCenter());
         
         slide1.setToX(-104);
         slide1.play();
         bp.getCenter().setTranslateX(0);
         
         /*AdajouteruserController l1= new AdajouteruserController();
         AnchorPane ap1 = l1.getAp1();
         TranslateTransition slide2 = new TranslateTransition();
         slide2.setDuration(Duration.seconds(0.4));
         slide2.setNode(ap1);
         
         slide2.setToX(-104);
         slide2.play();
         ap1.setTranslateX(0);*/
         
         
         
        
    }

    @FXML
    private void run1(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
         slide.setDuration(Duration.seconds(0.4));
         slide.setNode(slider);
         
         slide.setToX(0);
         slide.play();
         slider.setTranslateX(-208);
         
         Bar1.setVisible(false);
         Bar2.setVisible(true);
        
         TranslateTransition slide1 = new TranslateTransition();
         slide1.setDuration(Duration.seconds(0.4));
         slide1.setNode(bp.getCenter());
         
         slide1.setToX(0);
         slide1.play();
         bp.getCenter().setTranslateX(-104);
         
         /*AdajouteruserController l1= new AdajouteruserController();
         AnchorPane ap1 = l1.getAp1();
         TranslateTransition slide2 = new TranslateTransition();
         slide2.setDuration(Duration.seconds(0.4));
         slide2.setNode(ap1);
         
         slide2.setToX(0);
         slide2.play();
         ap1.setTranslateX(-104);*/
    }

    
    
}
