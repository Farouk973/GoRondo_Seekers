/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport.entities;

/**
 *
 * @author PC
 */
public class transport {
    private int id_tr;
    private float prix_tr;
    private String type_tr;
    private String disponibilite_tr;
    private String id_groupe_tr;
    private String destination_tr;
    private int stock_tr;
    private int image_tr ;

    public transport() {
    }

    public transport(int id, float prix, String type, String disponibilite, String id_groupe, String destination, int stock, int image) {
        this.id_tr = id;
        this.prix_tr = prix;
        this.type_tr = type;
        this.disponibilite_tr = disponibilite;
        this.id_groupe_tr = id_groupe;
        this.destination_tr = destination;
        this.stock_tr = stock;
        this.image_tr = image;
    }

   
    public int getId() {
        return id_tr;
    }

    public void setId(int id) {
        this.id_tr = id;
    }

    public float getPrix() {
        return prix_tr;
    }

    public void setPrix(float prix) {
        this.prix_tr = prix;
    }

    public String getType() {
        return type_tr;
    }

    public void setType(String type) {
        this.type_tr = type;
    }

    public String getDisponibilite() {
        return disponibilite_tr;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite_tr = disponibilite;
    }

    public String getId_groupe() {
        return id_groupe_tr;
    }

    public void setId_groupe(String id_groupe) {
        this.id_groupe_tr = id_groupe;
    }

    public String getDestination() {
        return destination_tr;
    }

    public void setDestination(String destination) {
        this.destination_tr = destination;
    }

    public int getStock() {
        return stock_tr;
    }

    public void setStock(int stock) {
        this.stock_tr = stock;
    }

    public int getImage() {
        return image_tr;
    }

    public void setImage(int image) {
        this.image_tr = image;
    }

   

    @Override
    public String toString() {
        return "transport{" + "id=" + id_tr + ", prix=" + prix_tr + ", type=" + type_tr + ", disponibilite=" + disponibilite_tr + ", id_groupe=" + id_groupe_tr + ", destination=" + destination_tr + ", stock=" + stock_tr + ", image=" + image_tr + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id_tr;
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
        final transport other = (transport) obj;
        if (this.id_tr!= other.id_tr) {
            return false;
        }
        return true;
    }

    public void setId_tr(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPrix_tr(float aFloat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setType_tr(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDisponibilite_tr(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId_groupe_tr(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDestination_tr(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setStock_tr(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setImage_tr(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
 
    
}
