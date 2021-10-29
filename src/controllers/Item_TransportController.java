/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import transport.entities.transport;
import transport.services.transportService;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class Item_TransportController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label Txt_prix;
    @FXML
    private Label libelle;
    @FXML
    private Label Txt_type;
    @FXML
    private Label Txt_id_groupe;
    @FXML
    private Label Txt_destination;
    @FXML
    private Label Txt_stock;
    @FXML
    private Label Txt_disponibilte;
    transport transport = null;
    transportService service = new transportService();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
       transport= service.getTransport(Afficher_transportController.indiceTransport);
        
       Txt_prix.setText(String.valueOf(transport.getPrix())+" DT");
       libelle.setText("Transport");
       Txt_type.setText(transport.getType());
              Txt_id_groupe.setText(transport.getId_groupe());
          Txt_destination.setText(transport.getDestination());
              Txt_disponibilte.setText(transport.getDisponibilite());
               Txt_stock.setText(String.valueOf(transport.getStock()));
       
    }    
    
}
