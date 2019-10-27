/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Lenovo
 */
public class Freelancer extends User{

    public Freelancer() {
        super();
    }

    public Freelancer(String login, String password, String role, String nom, String prenom, String email, String adresse, String image) {
        super(login, password, role, nom, prenom, email, adresse, image);
    }

    public Freelancer(int id, String login, String password, String role, String nom, String prenom, String email, String adresse, String image) {
        super(id, login, password, role, nom, prenom, email, adresse, image);
    }

    public Freelancer(int id, String login, String password, String role) {
        super(id, login, password, role);
    }

    public Freelancer(String login, String password) {
        super(login, password);
    }

    public Freelancer(String login, String password, String role) {
        super(login, password, role);
    }
    public Freelancer(String login, String password, String nom, String prenom, String email, String adresse, String image) {
        super(login, password, nom, prenom, email, adresse, image);
    }

    @Override
    public String toString() {
        return "Freelancer{" + super.toString()+ '}';
    }
    
}
