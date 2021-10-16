/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport_;

import transport.entities.transport;
import transport.services.transportService;



/**
 *
 * @author PC
 */
public class Transport_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        transportService ps = new transportService();
        transport t = new transport(55,12,"Khaled","Guedria","aaa","zzz",22,11);
        ps.ajoutertransport(t);
        
       
    
    }
    
}
