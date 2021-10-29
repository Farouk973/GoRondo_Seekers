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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import transport.entities.transport;
import transport.services.transportService;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class Modifier_TransportController implements Initializable {

    
    @FXML
    private JFXButton ftbutton1;
    @FXML
    private JFXTextField tfprix1;
    @FXML
    private JFXComboBox<String> tftype1;
    @FXML
    private JFXComboBox<String> tfdisponibilite1;
    @FXML
    private JFXTextField tfid_groupe1;
    @FXML
    private JFXTextField tfdestination1;
    @FXML
    private JFXTextField tfstock1;
    @FXML
    private ImageView tfimage1;
    @FXML
    private JFXTextField tfid;
    @FXML
    private Label tfdestination;
    @FXML
    private JFXButton ftbuttonback1;
    @FXML
    private JFXButton tfimageM;
    private File file;
    private BufferedImage bufferedImage;
    private Image image;
    private String imagePath;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("car","bus","bike");
         tftype1.setItems(list);
         ObservableList<String> list1 = FXCollections.observableArrayList("disponible","non-disponible");
         tfdisponibilite1.setItems(list1);
    }    

    @FXML
    private void savetransport1(ActionEvent event) {
        int id = Integer.parseInt(tfid.getText());
        float prix = Integer.parseInt(tfprix1.getText());
        String type = tftype1.getSelectionModel().getSelectedItem().toString();
        String disponibilite = tfdisponibilite1.getSelectionModel().getSelectedItem().toString();
        String id_groupe =tfid_groupe1.getText();
        String destination =tfdestination1.getText();
        int stock = Integer.parseInt(tfstock1.getText());
         String image=  imagePath ;
        
        
        
        transport t = new transport(id,prix, type, disponibilite, id_groupe, destination, stock,image);
        
        transportService tr = new transportService();
        
        tr.modifiertransport(t);
        
    }

    @FXML
    private void back1(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Transport.fxml"));
            try {
            Parent root= loader.load();  
            TransportController atc = loader.getController ();
            ftbuttonback1.getScene().setRoot(root);
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            
        }
    }

    @FXML
    private void modifierimage(ActionEvent event) {
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
                 tfimage1.setImage(image);
                 imagePath = file.getAbsolutePath();
             } catch (IOException ex) {
                 
             }
        }
    }

   
}
