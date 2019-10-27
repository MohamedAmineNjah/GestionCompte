/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioncompte;

import Service.UserService;
import entite.Admin;
import entite.Freelancer;
import entite.Startup;
import entite.User;
import utile.DataSourcee;

/**
 *
 * @author Lenovo
 */
public class GestionCompte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataSourcee ds1 = DataSourcee.getInstance();
        System.out.println(ds1);
        DataSourcee ds2 = DataSourcee.getInstance();
        System.out.println(ds2);
        DataSourcee ds3 = DataSourcee.getInstance();
        System.out.println(ds3);
        //singletenp bon pratique de dev permet d unifie  yejma3 les instance

        User p = new Admin("njah", "789", "admin", "amine", "njah", "amine@esprit.tn", "jardinelmenzah", "image1");
        UserService ps = new UserService();
         ps.insert(p);
        ps.readAll().forEach(e -> System.out.println(e));

        p.setLogin("njjaahh");
        p.setPassword("bn");
        p.setNom("ali");
        p.setPrenom("bnsalem");
        p.setEmail("bn@esprit.tn");
        p.setAdresse("jardinjardin");
        p.setImage("image2");
       // ps.readAll().forEach(e -> System.out.println(e));

       // ps.update(p, 11);
       // ps.delete(p, 11);
         System.out.println(ps.readAll());

    }

}
