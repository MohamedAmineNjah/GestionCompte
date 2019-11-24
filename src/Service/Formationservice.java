/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Formation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utile.DataSourcee;

/**
 *
 * @author YES_INFO
 */
public class Formationservice {
      private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    public Formationservice() {
        cnx = DataSourcee.getInstance().getConnexion();
    }

    public void insertPst(Formation F) {
        String req = "insert into formation  (nom,lieu,prix,date,description,image,nbr_places) values (?,?,?,?,?,?,?)";

        try {
            pst = cnx.prepareStatement(req);
            
            pst.setString(1, F.getNom());
            pst.setString(2, F.getLieu());
             pst.setInt(3, F.getPrix());
            pst.setString(4, F.getDate());
           
            pst.setString(5, F.getDescription());
            pst.setString(6, F.getImage());
            pst.setInt(7, F.getNbr_places());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Formationservice.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Formation> readAll() {
        String req = "select * from formation";
        List<Formation> list = new ArrayList<>();
        try {
            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Formation(rs.getInt("id"), rs.getString("nom"), rs.getString("lieu"), rs.getInt("prix"), rs.getString("date"), rs.getString("description"), rs.getString("image"), rs.getInt("nbr_places")));
             
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    public void delete(Formation f, int id) {
        String requette = "DELETE FROM formation where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("delet success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }
    }

    public void update(Formation F, int id) {
        try {
            String requette = "UPDATE formation SET nom=?,lieu=?,date=?,prix=?,description=?,image=?,nbr_places=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
              pst.setString(1, F.getNom());
            pst.setString(2, F.getLieu());
            pst.setString(3, F.getDate());
            pst.setInt(4, F.getPrix());
            pst.setString(5, F.getDescription());
             pst.setString(6, F.getImage());
            
            pst.setInt(7, F.getNbr_places());
            pst.setInt(8, id);
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");

        }
    }
 public Formation readById(int id) {
         try {
            String sql = "SELECT * FROM formation where id= ?";
            
            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            
            while (result.next()){
                String nom = result.getString(2);
                String lieu = result.getString(3);
                String date = result.getString(4);
                int prix = result.getInt(5);
                String description = result.getString(6);
                String image = result.getString(7);
                int nbr_places = result.getInt(8);
                
                
                
                String output = "User : %s - %s ";
                System.out.println(String.format(output, nom, lieu,prix,date,description,image,nbr_places));
            }       } catch (SQLException ex) {
            System.out.println("error");
            
    }
         return null;
    }

    public void insert(Formation f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
