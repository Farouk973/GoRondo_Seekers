/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.gui;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.jfoenix.controls.JFXComboBox;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import users.entities.participant;
import users.util.MyConnection;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowusersController implements Initializable {
    

    @FXML
    private Pane panee1;
    @FXML
    private JFXComboBox comboaffich;
    @FXML
    private Pane panee2;
    @FXML
    private Pane panee3;
    @FXML
    private Pane panee4;
    @FXML
    private Pane panee5;
    @FXML
    private Pane panee6;
    @FXML
    private Pane panee7;
    @FXML
    private Pane panee8;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }  
    
    public void remplirComboPage(){
        try {
            participant p=new participant();
            Connection cnx;
            cnx = MyConnection.getMyCnx().getConnection();
            String sql = "select count(*) from participant ";
            PreparedStatement ste = (PreparedStatement) cnx.prepareStatement(sql);
            ResultSet rs = ste.executeQuery(sql);
            ObservableList<String> list=FXCollections.observableArrayList();  
            while(rs.next()){
                if (Integer.parseInt(rs.getString(1))%8==0){
                    for (int i=1;i<Integer.parseInt(rs.getString(1))/8+1;i++)       
                    {
                        list.add(Integer.toString(i));
                    }
                }
                else {
                    for (int i=1;i<Integer.parseInt(rs.getString(1))/8+2;i++)
                    {
                        
                        list.add(Integer.toString(i));
                    }
                }
            }
            comboaffich.setItems(list);
            rs.close();
            comboaffich.setValue("1");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void afficherr(ActionEvent event) {
        remplirComboPage();
            List<Pane> panes=new ArrayList<>();
            panes.add(panee1);panes.add(panee2);panes.add(panee3);panes.add(panee4);panes.add(panee5);panes.add(panee6);panes.add(panee7);panes.add(panee8);
            for (Pane p : panes){
                p.setVisible(false);
            }
            participant p=new participant();
            Connection cnx;
            cnx = MyConnection.getMyCnx().getConnection();
            int a=(Integer.parseInt(comboaffich.getValue().toString())-1)*8;
            int b=Integer.parseInt(comboaffich.getValue().toString())*8;
            //System.out.println("a="+a +"\nb="+b);
            
            
            String sql = "select cin_par,username_par,mdp_par,mail_par from participant  limit "+a+","+b;
            
            try {
                PreparedStatement ste = (PreparedStatement) cnx.prepareStatement(sql);
                ResultSet rs = ste.executeQuery(sql);
                int i=0;
            
                while(rs.next()){
                    panes.get(i).setVisible(true);
                    ((Label)panes.get(i).getChildren().get(4)).setText(rs.getString(1));
                    ((Label)panes.get(i).getChildren().get(5)).setText(rs.getString(2));
                    ((Label)panes.get(i).getChildren().get(6)).setText(rs.getString(3));
                    ((Label)panes.get(i).getChildren().get(7)).setText(rs.getString(4));
                    i++;
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            
        
    }

    @FXML
    private void comboaction(ActionEvent event) {
        List<Pane> panes=new ArrayList<>();
            panes.add(panee1);panes.add(panee2);panes.add(panee3);panes.add(panee4);panes.add(panee5);panes.add(panee6);panes.add(panee7);panes.add(panee8);
            for (Pane p : panes){
                p.setVisible(false);
            }
            participant p=new participant();
            Connection cnx;
            cnx = MyConnection.getMyCnx().getConnection();
            int a=(Integer.parseInt(comboaffich.getValue().toString())-1)*8;
            int b=Integer.parseInt(comboaffich.getValue().toString())*8;
            //System.out.println("a="+a +"\nb="+b);
            
            
            String sql = "select cin_par,username_par,mdp_par,mail_par from participant  limit "+a+","+b;
            
            try {
                PreparedStatement ste = (PreparedStatement) cnx.prepareStatement(sql);
                ResultSet rs = ste.executeQuery(sql);
                int i=0;
            
                while(rs.next()){
                    panes.get(i).setVisible(true);
                    ((Label)panes.get(i).getChildren().get(4)).setText(rs.getString(1));
                    ((Label)panes.get(i).getChildren().get(5)).setText(rs.getString(2));
                    ((Label)panes.get(i).getChildren().get(6)).setText(rs.getString(3));
                    ((Label)panes.get(i).getChildren().get(7)).setText(rs.getString(4));
                    i++;
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
}
