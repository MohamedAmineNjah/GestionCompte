/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entite.Reclamation;
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
public class ReclamationService {
    private Connection cnx;
    private Statement ste;
    private ResultSet rs;
    private PreparedStatement pst;
    
    public ReclamationService() {
        cnx = DataSourcee.getInstance().getConnexion();
    }
     public void insertamine(Reclamation r) {
        try {
            String req = "insert into Reclamation (sujet11,text11,phone11) values ('" + r.getSujet11() + "','" + r.getText11() + "','" + r.getPhone11() + "')";
            ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      public List<Reclamation> readAllamine() {
        String req = "select * from Reclamation";
        List<Reclamation> list = new ArrayList<>();
        try {

            ste = cnx.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Reclamation(rs.getInt("id11"), rs.getString("sujet11"), rs.getString("text11"), rs.getString("phone11")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      public void updateamine(Reclamation r, int id) {
        try {
            String requette = "UPDATE Reclamation SET sujet11=?,text11=?,phone11=? WHERE id11=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setString(1, r.getSujet11());
            pst.setString(2, r.getText11());
            pst.setString(3, r.getPhone11());
            pst.setInt(4, id);
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");
        }

    }
      public void deleteamine(int id) {
        String requette = "DELETE FROM Reclamation where id11=?";
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
