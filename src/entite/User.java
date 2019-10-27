/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class User {
    private int id;
    private String login;
    private String password;
 private String role;
  private String nom;
 private String prenom;
 private String email;
 private String adresse;
 private String image;

 
    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User(int id, String login, String password,String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role=role;
    }

        
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public User( String login, String password, String role, String nom, String prenom, String email, String adresse, String image) {
       
        this.login = login;
        this.password = password;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.image = image;
    }
    public User( String login, String password, String nom, String prenom, String email, String adresse, String image) {
       
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.image = image;
    }
     public User(int id, String login, String password, String role, String nom, String prenom, String email, String adresse, String image) {
        this.id=id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.login);
        hash = 79 * hash + Objects.hashCode(this.password);
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", login=" + login + ", password=" + password + ", role=" + role + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse + ", image=" + image + '}';
    }

    
    
    
}
