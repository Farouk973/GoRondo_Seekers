/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class MaConnexion {
    public String URL="jdbc:mysql://localhost:3306/hamza";
    public String User ="root";
    public String Password ="";
    Connection cnx;
public static MaConnexion ct;
    public MaConnexion() {
        try {
        cnx = DriverManager.getConnection(URL,User,Password);
        System.out.println("connexion etablie)");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
             System.out.println("connexion échouer");
        }
        
}
    
    
public Connection getconnection(){
    return cnx;
}
public static MaConnexion getInstance(){
    if (ct == null){
        ct = new MaConnexion();
    }    
        return ct;
    
}
    }
    
