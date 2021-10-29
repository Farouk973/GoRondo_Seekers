/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author belha
 */
public class GetNomCategoryService {
    private static String nom_category;
    public GetNomCategoryService(){
        
    }
    

    public String getNom_category() {
        return nom_category;
    }

    public void setNom_category(String nom_category) {
        this.nom_category = nom_category;
    }
    
}
