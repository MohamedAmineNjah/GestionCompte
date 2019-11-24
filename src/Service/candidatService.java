/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.candidat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utile.DataSourcee;

/**
 *
 * @author MOHAMED RTIMI
 */
public class candidatService {
    
    private Connection cnx;
    
    
    public candidatService() {
        cnx=DataSourcee.getInstance().getConnexion();
}
    public void insert(candidat p){
       String req="insert into candidat (nom,prenom,mail,tel,sexe,date_naissance,diplome) values ('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getMail()+"','"+p.getTel()+"','"+p.getSexe()+"','"+p.getDate_naissance()+"','"+p.getDiplome()+"')";
        try {
           Statement ste = cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(candidatService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void insertPst(candidat p) throws SQLException{
      // Date date_naissance = (Date) Calendar.getInstance().getTime();
           //  SimpleDateFormat format = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");  
             SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd"); 
             
            //  String s = d.
             String req = "INSERT INTO `candidat`(`id_candidat`, `nom`,  `prenom`,  `mail`, `tel`, `sexe`, `date_naissance`, `diplome`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cnx.prepareStatement(req);
             pstm.setInt(1, p.getId_candidat());
             pstm.setString(2, p.getNom());
             pstm.setString(3, p.getPrenom());
             pstm.setString(4, p.getMail());
             pstm.setInt(5, p.getTel());
             pstm.setString(6, p.getSexe());
             pstm.setDate(7, (java.sql.Date) p.getDate_naissance());
             pstm.setString(8, p.getDiplome());
             
             pstm.executeUpdate();
         
    }
  
 
    public boolean isInt(String s)
    {
        try
        { int i = Integer.parseInt(s); return true; }

        catch(NumberFormatException er)
        { return false; }
    }

    
   
        
    }



