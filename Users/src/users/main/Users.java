/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users.main;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import user.entities.participant;
import user.services.participantcontroller;

/**
 *
 * @author HP
 */

public class Users {
    
    
    public static void main(String[] args) {
    
    participantcontroller ps = new participantcontroller();
    //Date d1 = Date. valueOf("2000-09-01");
    /*Calendar calendar = Calendar.getInstance();
    calendar.set(2018, 11, 31, 59, 59, 59);
    Date d1 = (Date) calendar.getTime();
        DateFormat dateformat= new SimpleDateFormat("YYYY,MM,DD");
        String date =dateformat.format(d1);*/
    //Date d1 = StringToDate("2015-12-06 17:03:00");
    //Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
    participant p = new participant("12444478","farouk", "felfel","Homme","farouk0009","0000","12444678","nabeul","farouk01@gmail.com","gorando");
    //participant p1 = new participant("12345678","11111111","farouk", "felfel","Homme","farouk009","0000","1244","nabeul","farouk1@gmail.com","gorando");
    //ps.ajouterParticipant(p);
    ps.modifierParticipant1("12444478","12345678","farouk","felfel","Homme","farouk","0000","12345679","nabeul","farouk001@hmail.com","gorando");
   // ps.supprimerParticipant("12345678");
    System.out.println(ps.getParticipant());
    
}
}
