/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class participant {
    private int id_par;
    private String cin_par;
    private String nom_par;
    private String prenom_par;
    private String sexe_par;
    private Date date_nai_par;
    private String username_par;
    private String mdp_par;
    private String numtel_par;
    private String adress_par;
    private String mail_par;
    private String id_group_par;
    private String cin_prev;

    public participant(){
    }

   
    public participant(String cin_par, String nom_par, String prenom_par, String sexe_par, String username_par, String mdp_par, String numtel_par, String adress_par, String mail_par, String id_group_par) {
        this.cin_par = cin_par;
        this.nom_par = nom_par;
        this.prenom_par = prenom_par;
        this.sexe_par = sexe_par;
        this.username_par = username_par;
        this.mdp_par = mdp_par;
        this.numtel_par = numtel_par;
        this.adress_par = adress_par;
        this.mail_par = mail_par;
        this.id_group_par = id_group_par;
    }
    public participant(String cin_prev,String cin_par, String nom_par, String prenom_par, String sexe_par, String username_par, String mdp_par, String numtel_par, String adress_par, String mail_par, String id_group_par) {
        this.cin_par = cin_par;
        this.nom_par = nom_par;
        this.prenom_par = prenom_par;
        this.sexe_par = sexe_par;
        this.username_par = username_par;
        this.mdp_par = mdp_par;
        this.numtel_par = numtel_par;
        this.adress_par = adress_par;
        this.mail_par = mail_par;
        this.id_group_par = id_group_par;
    }
    

    public String getCin_prev() {
        return cin_prev;
    }

    public void setCin_prev(String cin_prev) {
        this.cin_prev = cin_prev;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final participant other = (participant) obj;
        if (this.id_par != other.id_par) {
            return false;
        }
        if (!Objects.equals(this.cin_par, other.cin_par)) {
            return false;
        }
        if (!Objects.equals(this.username_par, other.username_par)) {
            return false;
        }
        if (!Objects.equals(this.numtel_par, other.numtel_par)) {
            return false;
        }
        return true;
    }
   
    public int getId_par() {
        return id_par;
    }

    public void setId_par(int id_par) {
        this.id_par = id_par;
    }

    public String getCin_par() {
        return cin_par;
    }

    public void setCin_par(String cin_par) {
        this.cin_par = cin_par;
    }

    public String getNom_par() {
        return nom_par;
    }

    public void setNom_par(String nom_par) {
        this.nom_par = nom_par;
    }

    public String getPrenom_par() {
        return prenom_par;
    }

    public void setPrenom_par(String prenom_par) {
        this.prenom_par = prenom_par;
    }

    public String getSexe_par() {
        return sexe_par;
    }

    public void setSexe_par(String sexe_par) {
        this.sexe_par = sexe_par;
    }

    public Date getDate_nai_par() {
        return date_nai_par;
    }

    public void setDate_nai_par(Date date_nai_par) {
        this.date_nai_par = date_nai_par;
    }

    public String getUsername_par() {
        return username_par;
    }

    public void setUsername_par(String username_par) {
        this.username_par = username_par;
    }

    public String getMdp_par() {
        return mdp_par;
    }

    public void setMdp_par(String mdp_par) {
        this.mdp_par = mdp_par;
    }

    public String getNumtel_par() {
        return numtel_par;
    }

    public void setNumtel_par(String numtel_par) {
        this.numtel_par = numtel_par;
    }

    public String getAdress_par() {
        return adress_par;
    }

    public void setAdress_par(String adress_par) {
        this.adress_par = adress_par;
    }

    public String getMail_par() {
        return mail_par;
    }

    public void setMail_par(String mail_par) {
        this.mail_par = mail_par;
    }

    public String getId_group_par() {
        return id_group_par;
    }

    public void setId_group_par(String id_group_par) {
        this.id_group_par = id_group_par;
    }

    

   
    
    
}
