/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author MOHAMED RTIMI
 */
public class candidat {
    
     private int id_candidat;  
    private String nom;
    private String prenom;
    private String mail;
    private int tel;
    private String sexe;
    private Date date_naissance;
    private String diplome;
    

    public candidat(int id_candidat, String nom, String prenom, String mail, int tel, String sexe, Date date_naissance, String photo, String diplome ) {
        this.id_candidat = id_candidat;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.sexe = sexe;
        this.date_naissance = date_naissance;
        this.diplome=diplome;
      
    }
    public candidat( String nom, String prenom, String mail, int tel, String sexe, Date date_naissance, String photo,String diplome  ) {
     
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.tel = tel;
        this.sexe = sexe;
        this.date_naissance = date_naissance;
        this.diplome=diplome;

    }

    public candidat(String nom, String prenom) {
        this.nom=nom;
        this.prenom=prenom;
    }

   
    

   

   
    

    @Override
    public String toString() {
        return "Candidat{" + "id_candidat=" + id_candidat + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", tel=" + tel + ", sexe=" + sexe + ", date_naissance=" + date_naissance + ", diplome=" + diplome +  '}';
    }

    
   
    
    
    public int getId_candidat() {
        return id_candidat;
    }

    public void setId_candidat(int id_candidat) {
        this.id_candidat = id_candidat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

   

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
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
        final candidat other = (candidat) obj;
        if (this.id_candidat != other.id_candidat) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.diplome, other.diplome)) {
            return false;
        }
        if (!Objects.equals(this.date_naissance, other.date_naissance)) {
            return false;
        }
        return true;
    }

  
    
 
}


    
