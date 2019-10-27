/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entite.User;
import java.sql.Connection;
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
 * @author Lenovo
 */
public class UserService implements IService<User> {

    private Connection cnx;
    private Statement ste;
    private ResultSet rs;
    private PreparedStatement pst;

    public UserService() {
        cnx = DataSourcee.getInstance().getConnexion();
    }

    @Override
    public void insert(User p) {
        try {
            String req = "insert into User (login,password,role,nom,prenom,email,adresse,image) values ('" + p.getLogin() + "','" + p.getPassword() + "','" + p.getRole() + "','" + p.getNom() + "','" + p.getPrenom() + "','" + p.getEmail() + "','" + p.getAdresse() + "','" + p.getImage() + "')";
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // public void insertPst()autre methode
    @Override
    public List<User> readAll() {
        String req = "select * from User";
        List<User> list = new ArrayList<>();
        try {

            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("role"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("adresse"), rs.getString("image")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void update(User p, int id) {
        try {
            String requette = "UPDATE User SET login=?,password=?,nom=?,prenom=?,email=?,adresse=?,image=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setString(1, p.getLogin());
            pst.setString(2, p.getPassword());
            pst.setString(3, p.getNom());
            pst.setString(4, p.getPrenom());
            pst.setString(5, p.getEmail());
            pst.setString(6, p.getAdresse());
            pst.setString(7, p.getImage());
            pst.setInt(8, id);
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");
        }

    }

    @Override
    public void delete(int id) {
        String requette = "DELETE FROM User where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("delet success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }
    }

}
