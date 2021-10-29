/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.services;

import javafx.scene.control.Label;

/**
 *
 * @author HP
 */
public class controlsaisir {

    public controlsaisir() {
    }
    public static boolean isNumeric(String str) {
        Label label;
  try {  
    Double.parseDouble(str);  
    return true;
  } catch(NumberFormatException e){  
    return false;  
  }  
  }
   public static boolean is8(String str) { 
       
       if (str.length()==8){
           return true;
       }
       return false;
   }
   
   public static boolean csaisie (String nom,String prenom,String cin,String mail,String adress,String psw,String username,String age,String tel,Label label){
       controlsaisir t =new controlsaisir();
       if (nom.equals("")){label.setText("set nom!!!");
       return false;}
        else if (prenom.equals("")){label.setText("set prenom!!!");
        return false;}
        else if (cin.equals("")){label.setText("set cin!!!");
        return false;}
        else if (mail.equals("")){label.setText("set mail!!!");
        return false;}
        else if (adress.equals("")){label.setText("set adress!!!");
        return false;}
        else if (psw.equals("")){label.setText("set psw!!!");
        return false;}
        else if (username.equals("")){label.setText("set username!!!");
        return false;}
        else if (age.equals("")){label.setText("set age!!!");
        return false;}
        else if (tel.equals("")){label.setText("set tel!!!");
        return false;}
        else if (t.is8(cin)==false){label.setText("set cin convenablement!!!");
        return false;}
        else if (t.isNumeric(cin)==false){label.setText("set cin convenablement!!!");
        return false;}
        else if (t.is8(tel)==false){label.setText("set tel convenablement!!!");
        return false;}
        else if (t.isNumeric(tel)==false){label.setText("set tel convenablement!!!");
        return false;}
        else if (age.length()<1 && age.length()>=2){label.setText("set age convenablement!!!");
        return false;}
        else if (t.isNumeric(age)==false){label.setText("set age convenablement!!!");
        return false;}
        else
        return true;
   }
}
