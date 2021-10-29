/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payer.esprit.utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Utilisateur
 */
public class MyConnection {
    private String url = "jdbc:mysql://localhost:3306/paiement";
    private String user = "root";
    private String pwd = "";
    private Connection cnx;
    
    private static MyConnection myCnx;
    
    private MyConnection() {
        try {
            cnx = (Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    public static MyConnection getmyCnx() {
          if (myCnx == null) {
              myCnx = new MyConnection();
          }
        return myCnx;
    }    
    
    
}
