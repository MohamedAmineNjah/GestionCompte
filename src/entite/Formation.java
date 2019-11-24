/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author wiemhjiri
 */
public class Formation {
    private int  id;
    private String nom;
    private String lieu;
        private int prix;
    private String date;

    private String description;
    private String image;
    private int nbr_places;

    public Formation(int id, String nom, String lieu, int prix, String date, String description, String image, int nbr_places) {
        this.id = id;
        this.nom = nom;
        this.lieu = lieu;
        this.prix = prix;
        this.date = date;
        this.description = description;
        this.image = image;
        this.nbr_places = nbr_places;
    }

    public Formation(String nom, String lieu, int prix, String date, String description, String image, int nbr_places) {
        this.nom = nom;
        this.lieu = lieu;
        this.prix = prix;
        this.date = date;
        this.description = description;
        this.image = image;
        this.nbr_places = nbr_places;
    }

   
        
     
    

  
   

    public int getNbr_places() {
        return nbr_places;
    }

    public void setNbr_places(int nbr_places) {
        this.nbr_places = nbr_places;
    }

   

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
     public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Formation() {
    }

    public Formation (int id, String nom, String lieu) {
        this.id = id;
        this.nom = nom;
        this.lieu = lieu;
    }
     public Formation(String nom, String prenom) {
        this.nom = nom;
        this.lieu = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getlieu() {
        return lieu;
    }

    public void setlieu(String prenom) {
        this.lieu = prenom;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", nom=" + nom + ", lieu=" + lieu + ", date=" + date + ", prix=" + prix + ", description=" + description + ", image=" + image + ", nbr_places=" + nbr_places + '}';
    }

    

    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Formation other = (Formation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    /*public Object getnom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    
    
}

