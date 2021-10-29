/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport.gui;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import transport.entities.BadWords;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import transport.entities.transport;
import transport.services.transportService;
import alret.AlertDialog;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class AjouterTransportController implements Initializable {

    @FXML
    private JFXTextField tfdestination;
    @FXML
    private JFXTextField tfprix;
    @FXML
    private JFXComboBox<String> tftype;
    @FXML
    private JFXComboBox<String> tfdisponibilite;
    @FXML
    private JFXTextField tfid_groupe;
    @FXML
    private JFXTextField tfstock;
    @FXML
    private ImageView tfimage;
    @FXML
    private JFXButton ftbutton;
    @FXML
    private JFXButton ftbuttonback;
    @FXML
    private JFXButton tfajoutimage;
    private File file;
    private BufferedImage bufferedImage;
    private Image image;
    private String imagePath;
    transport transport = null;
    transportService service = new transportService();

    /**
     * Initializes the controller class.
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
       
        ObservableList<String> list = FXCollections.observableArrayList("car","bus","bike");
         tftype.setItems(list);
         ObservableList<String> list1 = FXCollections.observableArrayList("disponible","non-disponible");
         tfdisponibilite.setItems(list1);
    }
    
    @FXML
    private void selecttype(ActionEvent event) {
    }

    @FXML
    private void selectdispo(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transport.fxml"));
            try {
            Parent root= loader.load();  
            TransportController atc = loader.getController ();
            ftbuttonback.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

    @FXML
    private void ajoutimage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG (Joint Photographic Group)", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG (Joint Photographic Experts Group)", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG (Portable Network Graphics)", "*.png")
        );

        fileChooser.setTitle("Choise a Image File");

        file = fileChooser.showOpenDialog(null);

        if (file != null) {
             try {
                 System.out.println(file);
                 bufferedImage = ImageIO.read(file);
                 image = SwingFXUtils.toFXImage(bufferedImage, null);
                 tfimage.setImage(image);
                 imagePath = file.getName();
             } catch (IOException ex) {
                 
             }
        }
    }

    @FXML
    private void savetransport(ActionEvent event) {
       /* float prix = Integer.parseInt(tfprix.getText());
        String type = tftype.getSelectionModel().getSelectedItem().toString();
        String disponibilite = tfdisponibilite.getSelectionModel().getSelectedItem().toString();
        String id_groupe =tfid_groupe.getText();
        String destination =tfdestination.getText();
        int stock = Integer.parseInt(tfstock.getText());
        String image=  imagePath ;
        
        
        
        transport t = new transport(prix,type , disponibilite, id_groupe, destination, stock,image);
        
        */
        
        
         BadWords.loadConfigs();

        
        if (tfprix.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de tfprix", AlertDialog.image_cross);
        } else if (tfprix.getText().matches("^[a-zA-Z]+$")) {
            AlertDialog.showNotification("Erreur tfprix !", " incorrect", AlertDialog.image_cross);
        } else if (Integer.valueOf(tfprix.getText()) <= 0) {
            AlertDialog.showNotification("Error !", "Champ de tfprix", AlertDialog.image_cross);
        }
        
          
          
           else if (tfid_groupe.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de tfid_groupe", AlertDialog.image_cross);
        } else if (tfid_groupe.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Erreur tfid_groupe !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
        } 
           else if (BadWords.filterText(tfid_groupe.getText())) {

                AlertDialog.showNotification("Error !", "cette application n'autorise pas ces termes", AlertDialog.image_cross);

            }
           
        else if (tfdestination.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de tfdestination", AlertDialog.image_cross);
        } else if (tfdestination.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Erreur tfdestination !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
        } 
           else if (BadWords.filterText(tfdestination.getText())) {

                AlertDialog.showNotification("Error !", "cette application n'autorise pas ces termes", AlertDialog.image_cross);

            }
         else if (tfstock.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de tfdestination", AlertDialog.image_cross);
        } else if (tfstock.getText().matches("^[a-zA-Z]+$")) {
            AlertDialog.showNotification("Erreur tfdestination !", " incorrect", AlertDialog.image_cross);
        } else if (Integer.valueOf(tfstock.getText()) <= 0) {
            AlertDialog.showNotification("Error !", "Champ de tfdestination", AlertDialog.image_cross);
        }

        
          
             transport t = new transport(Integer.parseInt(tfprix.getText()),tftype.getSelectionModel().getSelectedItem(),tfdisponibilite.getSelectionModel().getSelectedItem(),tfid_groupe.getText(),tfdestination.getText(),Integer.parseInt(tfstock.getText()));
             
             transportService tr = new transportService();
             
             service.ajoutertransport(t);
         }
        }
        

    

    
 
   
    
    
    
     
        
    

   /* @FXML
    private void selecttype(ActionEvent event) {
         String s = tftype.getSelectionModel().getSelectedItem().toString();
        tftype.setText(s);
    }
    
    

    @FXML
    private void selectdispo(ActionEvent event) {
         String s = tfdisponibilite.getSelectionModel().getSelectedItem().toString();
        tfdisponibilite.setText(s);
    }
    */

    

   
    

