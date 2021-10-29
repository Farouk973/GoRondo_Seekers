/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfilClient;

import AffichageEquipement.AfficherProduitsController;
import Service.ProduitService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author belha
 */
public class ProfilclientController implements Initializable {

    @FXML
    private Pane paneFilter;
    @FXML
    private Pane pane1;
    @FXML
    private JFXComboBox<String> comboPage;
    private Pane pane11;
    private Pane pane12;
    @FXML
    private JFXButton Rtour;
    @FXML
    private ImageView upprimeproduit;
    @FXML
    private JFXButton Ajouteeee;
    @FXML
    private Label id1;
    @FXML
    private Pane pane2;
    @FXML
    private Label id2;
    @FXML
    private Pane pane3;
    @FXML
    private Label id3;
    @FXML
    private JFXButton croix1;
    @FXML
    private JFXButton croix2;
    @FXML
    private JFXButton croix3;
    @FXML
    private JFXButton Modifer1;
    @FXML
    private JFXButton Modifer2;
    @FXML
    private JFXButton Modifer3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        remplirComboPage();
        AffichageProduitProfil();
    }    
    public void remplirComboPage(){
        try {
            String Id="5555555";
            ProduitService p=new ProduitService();
            Connection conn = p.cnx;
            PreparedStatement ste;
            String sql = "select count(*) from equipement where Id_participant='"+Id+"'";
            ste = conn.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            ObservableList<String> list=FXCollections.observableArrayList();  
            while(rs.next()){
                if (Integer.parseInt(rs.getString(1))%3==0){
                    for (int i=1;i<Integer.parseInt(rs.getString(1))/3+1;i++)
                    {
                        list.add(Integer.toString(i));
                    }
                }
                else {
                    for (int i=1;i<Integer.parseInt(rs.getString(1))/3+2;i++)
                    {
                        
                        list.add(Integer.toString(i));
                    }
                }
            }
            comboPage.setItems(list);
            rs.close();
            comboPage.setValue("1");
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void AffichageProduitProfil(){
        String Id="5555555";
        try {
            List<Pane> panes=new ArrayList<>();
            panes.add(pane1);panes.add(pane2);panes.add(pane3);
            for (Pane p : panes){
                p.setVisible(false);
            }
            ProduitService p=new ProduitService();
            Connection conn = p.cnx;
            PreparedStatement ste;
            int a=(Integer.parseInt(comboPage.getValue())-1)*3;
            int b=Integer.parseInt(comboPage.getValue())*3;
            Service.GetNomCategoryService S=new Service.GetNomCategoryService();
            //System.out.println(S.getNom_category());
            String sql=null;
            sql = "select Nom_Produit,Desc_Produit,Marque_Produit,Prix_Produit,Id_Produit from equipement  where Id_participant = '"+Id+"' limit "+a+","+b;
            ste = conn.prepareStatement(sql);
            System.out.println(ste);
            ResultSet rs = ste.executeQuery(sql);
            int i=0;
            while(rs.next()){
                System.out.println("a="+a+"   b="+b);
                panes.get(i).setVisible(true);
                ((Label)panes.get(i).getChildren().get(7)).setText(rs.getString(1));
                ((Label)panes.get(i).getChildren().get(1)).setText(rs.getString(3));
                ((Label)panes.get(i).getChildren().get(2)).setText(rs.getString(4));
                ((Label)panes.get(i).getChildren().get(10)).setText(rs.getString(5));
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void SupprimerProduit(ActionEvent event) {
        List<JFXButton> btns=new ArrayList<>();
            btns.add(croix1);btns.add(croix2);btns.add(croix3);
        Service.InfoIdEquipement S=new Service.InfoIdEquipement();
        Service.GetNomCategoryService S2=new Service.GetNomCategoryService();
        ProduitService p=new ProduitService();
        Connection conn = p.cnx;
        PreparedStatement ste;
        Pane pane_clicked=null;
        String ch=null;
        
        for (JFXButton b : btns ){
            if (b.getId().toString().equals(event.getSource().toString().substring(13, 19))){
                ch=event.getSource().toString().substring(13, 19);
            }
        }
        if (ch.equals("croix1")){
            pane_clicked=pane1;
        }
        if (ch.equals("croix2")){
            pane_clicked=pane2;
        }
        if (ch.equals("croix3")){
            pane_clicked=pane3;
        }
        String a =((Label)pane_clicked.getChildren().get(10)).getText();
        String sql = "delete from equipement where Id_Produit = "+a;
        
        try {
            ste=conn.prepareStatement(sql);
            ste.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        remplirComboPage();
        AffichageProduitProfil();
    }

    @FXML
    private void ModifierEquipement(ActionEvent event) {
        List<JFXButton> btns=new ArrayList<>();
            btns.add(Modifer1);btns.add(Modifer2);btns.add(Modifer3);
        Service.InfoIdEquipement S=new Service.InfoIdEquipement();
        Service.GetNomCategoryService S2=new Service.GetNomCategoryService();
        ProduitService p=new ProduitService();
        Connection conn = p.cnx;
        PreparedStatement ste;
        Pane pane_clicked=null;
        String ch=null;
        
        for (JFXButton b : btns ){
            System.out.println(event.getSource().toString());
            if (b.getId().equals(event.getSource().toString().substring(13, 21))){
                ch=event.getSource().toString().substring(13, 21);
            }
        }
        System.out.println("ch="+ch);
        if (ch.equals("Modifer1")){
            pane_clicked=pane1;
        }
        if (ch.equals("Modifer2")){
            pane_clicked=pane2;
        }
        if (ch.equals("Modifer3")){
            pane_clicked=pane3;
        }
        int a =Integer.parseInt(((Label)pane_clicked.getChildren().get(10)).getText());
        Service.sendIdToModifier S3=new Service.sendIdToModifier();
        S3.setId(a);
        
         try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Modiferproduit/ModiferProduit.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void MouseChange(MouseEvent event) {
    }

    @FXML
    private void InfoProduit(MouseEvent event) {
    }

    @FXML
    private void nextPage(ActionEvent event) {
        AffichageProduitProfil();
    }

    @FXML
    private void RtourA(ActionEvent event) {
            try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/Categoryequipement/Categoryequipement.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Ajouteequipenttt(ActionEvent event) {
         try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/AjouteEquipement/AjoutEquipement.fxml")));
            stage.setScene(scene);
            stage.show();
        } 
        catch (IOException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    
    

