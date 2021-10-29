/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import alret.AlertDialog;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import transport.entities.transport;
import transport.gui.TransportController;
import transport.services.transportService;


/**
 * FXML Controller class
 *
 * @author PC
 */
public class Afficher_transportController implements Initializable {
    
   

    @FXML
    private JFXTextField txt_search;
    @FXML
    private ScrollPane scrollpaneTransport;
    @FXML
    private HBox hbox_transport;
    private int taille_Transport = 0;
     
   private transportService serivce = new transportService();
   static int indiceTransport = 0;
    @FXML
    private JFXButton tfcapture;
    @FXML
    private JFXButton tfback3;
    @FXML
    private JFXButton tfrech;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             try {
          
            taille_Transport = serivce.affichertransport().size();
            System.out.println(taille_Transport);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        Node[] nodes_transports = new Node[taille_Transport];
        scrollpaneTransport.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        for (indiceTransport = 0; indiceTransport < taille_Transport; indiceTransport++) {
            try {

                nodes_transports[indiceTransport] = FXMLLoader.load(getClass().getResource("/transport/gui/Item_Transport.fxml"));

                hbox_transport.getChildren().add(nodes_transports[indiceTransport]);
            } catch (IOException e) {
                System.out.println(e.getCause());
            }
        }
    }    

    @FXML
    private void capture(ActionEvent event) {
        Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
           Scene scene =  node.getScene();
         WritableImage writableImage = scene.snapshot(null);
            File file = new File("capturedScene.png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
                System.out.println("Captured: " + file.getAbsolutePath());
                
            } catch (IOException ex) {
             
            }
            AlertDialog.showNotification("Capture !", "Capture", AlertDialog.image_checked);
    }
   
    
    @FXML
    private void recherche(ActionEvent event) {
      
    }

    @FXML
    private void back1(ActionEvent event) {
          try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/tarnsport.gui/Transport.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
    }
    }
    }
    
            
            
        
            
        

    
