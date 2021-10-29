/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payer.esprit.entities;

import static java.awt.SystemColor.text;
import java.util.Objects;

/**
 *
 * @author Utilisateur
 */
public class Commande {
    private int id_commande;
    private int prix_total;
    private int id_user;
    private String remarque;

    public Commande() {
    }

    public Commande(int id_commande, int prix_total, int id_user, String remarque) {
        this.id_commande = id_commande;
        this.prix_total = prix_total;
        this.id_user = id_user;
        this.remarque = remarque;
    }

    public Commande(int prix_total, int id_user, String remarque) {
        this.prix_total = prix_total;
        this.id_user = id_user;
        this.remarque = remarque;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(int prix_total) {
        this.prix_total = prix_total;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id_commande;
        hash = 23 * hash + this.prix_total;
        hash = 23 * hash + this.id_user;
        hash = 23 * hash + Objects.hashCode(this.remarque);
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
        final Commande other = (Commande) obj;
        if (this.id_commande != other.id_commande) {
            return false;
        }
        if (this.prix_total != other.prix_total) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (!Objects.equals(this.remarque, other.remarque)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", prix_total=" + prix_total + ", id_user=" + id_user + ", remarque=" + remarque + '}';
    }
    
    
    
}
