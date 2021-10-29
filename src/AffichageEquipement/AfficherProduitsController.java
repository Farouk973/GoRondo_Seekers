/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AffichageEquipement;
import Service.ProduitService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import connexion.MaConnexion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author belha
 */
public class AfficherProduitsController implements Initializable {
    
    @FXML
    private Pane paneFilter;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;
    @FXML
    private Pane pane6;
    @FXML
    private JFXComboBox<String> comboPage;
    static int id;
    @FXML
    private JFXButton btnFilter;
    @FXML
    private JFXButton RtoureB;
    @FXML
    private JFXCheckBox M1;
    @FXML
    private JFXCheckBox M2;
    @FXML
    private JFXCheckBox M3;
    @FXML
    private JFXCheckBox M4;
    @FXML
    private JFXCheckBox M5;
    @FXML
    private JFXCheckBox M6;
    @FXML
    private JFXCheckBox M7;
    @FXML
    private JFXCheckBox M8;
    @FXML
    private JFXCheckBox M9;
    @FXML
    private JFXCheckBox M10;
    @FXML
    private JFXCheckBox M;
    @FXML
    private JFXComboBox<String> SousCategoryCombo;
    @FXML
    private Pane paneMarque;
    @FXML
    private TextArea minEntry;
    @FXML
    private TextArea maxEntry;
    @FXML
    private JFXButton Ajouteeee;
    @FXML
    private Label id1;
    @FXML
    private Label id2;
    @FXML
    private Label id3;
    @FXML
    private Label id4;
    @FXML
    private Label id5;
    @FXML
    private Label id6;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        remplirComboPage();
        affichageEquipement();
        remplirFilter();
    }    
    public void remplirComboPage(){
        try {
            ProduitService p=new ProduitService();
            Connection conn = p.cnx;
            PreparedStatement ste;
            String sql = "select count(*) from equipement ";
            ste = conn.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            ObservableList<String> list=FXCollections.observableArrayList();  
            while(rs.next()){
                if (Integer.parseInt(rs.getString(1))%6==0){
                    for (int i=1;i<Integer.parseInt(rs.getString(1))/6+1;i++)
                    {
                        list.add(Integer.toString(i));
                    }
                }
                else {
                    for (int i=1;i<Integer.parseInt(rs.getString(1))/6+2;i++)
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
    public void affichageEquipement(){
        try {
            List<Pane> panes=new ArrayList<>();
            panes.add(pane1);panes.add(pane2);panes.add(pane3);panes.add(pane4);panes.add(pane5);panes.add(pane6);
            for (Pane p : panes){
                p.setVisible(false);
            }
            ProduitService p=new ProduitService();
            Connection conn = p.cnx;
            PreparedStatement ste;
            int a=(Integer.parseInt(comboPage.getValue())-1)*6;
            int b=Integer.parseInt(comboPage.getValue())*6;
            Service.GetNomCategoryService S=new Service.GetNomCategoryService();
            //System.out.println(S.getNom_category());
            String sql=null;
            sql = "select Nom_Produit,Desc_Produit,Marque_Produit,Prix_Produit,Id_Produit from equipement  where Categorie_Produit = '"+S.getNom_category()+"' limit "+a+","+b;
            ste = conn.prepareStatement(sql);
            System.out.println(ste);
            ResultSet rs = ste.executeQuery(sql);
            int i=0;
            while(rs.next()){
                panes.get(i).setVisible(true);
                ((Label)panes.get(i).getChildren().get(1)).setText(rs.getString(2));
                ((Label)panes.get(i).getChildren().get(2)).setText(rs.getString(4));
                ((Label)panes.get(i).getChildren().get(3)).setText(rs.getString(3));
                ((Label)panes.get(i).getChildren().get(8)).setText(rs.getString(1));
                ((Label)panes.get(i).getChildren().get(9)).setText(rs.getString(5));
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void afficherPaneFIlter(ActionEvent event) {
        if (paneFilter.isVisible())
            paneFilter.setVisible(false);
        else 
            paneFilter.setVisible(true);
    }

    @FXML
    private void nextPage(ActionEvent event) {
        affichageEquipement();
    }

    private void MouseChange(MouseDragEvent event) {
        Node node = (Node) event.getSource();
        Scene scene = (Scene) node.getScene();
        scene.setCursor(Cursor.HAND);
    }

    @FXML
    private void InfoProduit(MouseEvent event) {
        List<Pane> panes=new ArrayList<>();
            panes.add(pane1);panes.add(pane2);panes.add(pane3);panes.add(pane4);panes.add(pane5);panes.add(pane6);
        Service.InfoIdEquipement S=new Service.InfoIdEquipement();
        Service.GetNomCategoryService S2=new Service.GetNomCategoryService();
        ProduitService p=new ProduitService();
        Connection conn = p.cnx;
        PreparedStatement ste;
        Pane pane_clicked=null;
        String ch =event.getSource().toString().substring(12, 13);
        
        for (Pane pa : panes ){
            if (pa.getId().toString().equals(event.getSource().toString().substring(8, 13))){
                pane_clicked=pa;
            }
        }
        
        String sql = "select Id_Produit from equipement where Id_Produit="+((Label)pane_clicked.getChildren().get(9)).getText();
        try {
            ste=conn.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            while(rs.next()){
                //System.out.println(rs.getString(1));
                S.setIdEquipement(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/AjoutAuPanier/AjoutAupanier.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    @FXML
    private void MouseChange(MouseEvent event) {
        if (event.getEventType().toString().equals("MOUSE_ENTERED")){
            Node node = (Node) event.getSource();
            Scene scene = (Scene) node.getScene();
            scene.setCursor(Cursor.HAND);
        }
        else if (event.getEventType().toString().equals("MOUSE_EXITED")){
            Node node = (Node) event.getSource();
            Scene scene = (Scene) node.getScene();
            scene.setCursor(Cursor.DEFAULT);
        }
    }

    private void ajoutEquipement(ActionEvent event) {
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

    @FXML
    private void ProfilProduit(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/ProfilClient/Profilclient.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RtoureB(ActionEvent event) {
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
    private void CancelFiltrage(ActionEvent event) {
        paneFilter.setVisible(false);
    }

    @FXML
    private void FiltrageParMarqueTous(ActionEvent event) {
        List<JFXCheckBox> MT=new ArrayList <> ();
        MT.add(M1);MT.add(M2);MT.add(M3);MT.add(M4);MT.add(M5);MT.add(M6);MT.add(M7);MT.add(M8);MT.add(M9);MT.add(M10);
        if (!M.isSelected()){
            for(JFXCheckBox m :MT){
                m.setSelected(false);
            }
        }
        else {
            for(JFXCheckBox m :MT){
                m.setSelected(true);
            }
        }
            
        
        
        
        
    }

    @FXML
    private void FiltrageParMarque(ActionEvent event) {
        List<JFXCheckBox> MT=new ArrayList <> ();
        MT.add(M1);MT.add(M2);MT.add(M3);MT.add(M4);MT.add(M5);MT.add(M6);MT.add(M7);MT.add(M8);MT.add(M9);MT.add(M10);
        
        if (M.isSelected()){
            M.setSelected(false);
        }
        
    }

    @FXML
    private void FiltrageOk(ActionEvent event) {
        List<Pane> panes=new ArrayList<>();
            panes.add(pane1);panes.add(pane2);panes.add(pane3);panes.add(pane4);panes.add(pane5);panes.add(pane6);
        int min=0;
        int max=5000;
        if (!minEntry.getText().isEmpty()){
            min=Integer.parseInt(minEntry.getText());
        }
        if (!maxEntry.getText().isEmpty()){
            max=Integer.parseInt(maxEntry.getText());
        }
        ProduitService p=new ProduitService();
        Connection conn = p.cnx;
        PreparedStatement ste;
        Service.GetNomCategoryService S=new Service.GetNomCategoryService();
        String cat=S.getNom_category();
        String sql = "select Nom_Produit,Desc_Produit,Marque_Produit,Prix_Produit,Id_Produit from equipement ";
        
        
        try {
            ste = conn.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            int i=0;
            while (rs.next()){
                panes.get(i).setVisible(true);
                ((Label)panes.get(i).getChildren().get(1)).setText(rs.getString(2));
                ((Label)panes.get(i).getChildren().get(2)).setText(rs.getString(4));
                ((Label)panes.get(i).getChildren().get(3)).setText(rs.getString(3));
                ((Label)panes.get(i).getChildren().get(8)).setText(rs.getString(1));
                ((Label)panes.get(i).getChildren().get(9)).setText(rs.getString(5));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void remplirFilter(){
        ProduitService p=new ProduitService();
        Connection conn = p.cnx;
        PreparedStatement ste;
        Service.GetNomCategoryService S=new Service.GetNomCategoryService();
        String cat=S.getNom_category();
        String sql = "select DISTINCT(sousCategory) from equipement where Categorie_Produit='"+cat+"'";
        ObservableList<String> list=FXCollections.observableArrayList();
        try {
            ste = conn.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()){
                list.add(rs.getString(1));
            }
            rs.close();
            SousCategoryCombo.setItems(list);
            SousCategoryCombo.getValue();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneMarque.setVisible(false);
        
        
    }

    @FXML
    private void SousCategorieChange(ActionEvent event) {
        List<JFXCheckBox> MT=new ArrayList <> ();
        MT.add(M1);MT.add(M2);MT.add(M3);MT.add(M4);MT.add(M5);MT.add(M6);MT.add(M7);MT.add(M8);MT.add(M9);MT.add(M10);
        for(JFXCheckBox m: MT){
            m.setVisible(false);
        }
        String Souscat=SousCategoryCombo.getValue();
        ProduitService p=new ProduitService();
        Connection conn = p.cnx;
        PreparedStatement ste;
        Service.GetNomCategoryService S=new Service.GetNomCategoryService();
        String cat=S.getNom_category();
        String sql = "select DISTINCT(Marque_Produit) from equipement where Categorie_Produit='"+cat+"' and sousCategory='"+Souscat+"' limit 0,10";
        try {
            ste = conn.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            int i=0;
            
            while (rs.next()){
                MT.get(i).setText(rs.getString(1));
                MT.get(i).setVisible(true);
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AfficherProduitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        paneMarque.setVisible(true);
        
    }

    @FXML
    private void ajouteeee(ActionEvent event) {   try {
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
