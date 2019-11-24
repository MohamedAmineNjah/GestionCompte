/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Offre;
import entite.candidat;
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
 * @author asus
 */
public class OffreService {
    private Connection cnx;
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public OffreService() {
        cnx=DataSourcee.getInstance().getConnexion();
}
 public void insert(Offre p){
       String req="insert into offre (contrat,lieu,remuneration,competence,parttime) values ('"+p.getContrat()+"','"+p.getLieu()+"','"+p.getRenumeration()+"','"+p.getCompetence()+"','"+p.getParttime()+"')";
        try {
            ste=cnx.createStatement();
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void insertPst(Offre p){
        String req="insert into offre (contrat,lieu,remuneration,competence,parttime) values (?,?,?,?,?)";
        
        try {
            pst= cnx.prepareStatement(req);
            pst.setString(1,p.getContrat());
            pst.setString(2,p.getLieu());
            pst.setString(3,p.getRenumeration());
            pst.setString(4,p.getCompetence());
            pst.setString(5,p.getParttime());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Offre> readAll(){
        String req="select * from offre";
        List<Offre> list=new ArrayList<>();
        try {
            ste=cnx.createStatement();
            rs=ste.executeQuery(req);
            while(rs.next()){
                list.add(new Offre(rs.getInt("id"), rs.getString("contrat"), rs.getString("lieu"), rs.getString("remuneration"), rs.getString("competence"), rs.getString("parttime")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
    }
    
   

    public Offre readById(int id) {
          try {
            String sql = "SELECT * FROM offre where id= ?";
            
            PreparedStatement r = cnx.prepareStatement(sql);
            r.setInt(1, id);
            ResultSet result = r.executeQuery();
            
            while (result.next()){
                String nom = result.getString(2);
                String prenom = result.getString(3);
                
                String output = "User : lieu: %s - contrat: %s ";
                System.out.println(String.format(output, nom, prenom));
            }       } catch (SQLException ex) {
            System.out.println("error");
            } //To change body of generated methods, choose Tools | Templates.
        return null;
    }

    
     public void delete(int id) {
          String requette = "DELETE FROM offre where id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("delet success");
        } catch (SQLException ex) {
            System.out.println("error of delete");
        }
    }

    public void update(Offre t, int id) {
          try {
            String requette = "UPDATE offre SET contrat=?,lieu=?,remuneration=?,competence=?,parttime=? WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
            
             pst.setString(1,t.getContrat());
            pst.setString(2,t.getLieu());
            pst.setString(3,t.getRenumeration());
            pst.setString(4,t.getCompetence());
            pst.setString(5,t.getParttime());
            pst.setInt(6, id);
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println("update failed");
        } //To change body of generated methods, choose Tools | Templates.
    }
    
     public List<Offre> chercher(String competence){
        String req="select * from offre where competence like '"+competence+"'";
        List<Offre> list=new ArrayList<>();
        try {
             ste=cnx.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
               
                //list.add(new Demande(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"),rs.getString("dateann"),rs.getString("photo"),rs.getString("titre"),rs.getString("description")));
              list.add(new Offre(rs.getInt("id"),rs.getString("contrat"),rs.getString("lieu"),rs.getString("remuneration"),rs.getString("competence"),rs.getString("parttime")));  
                //list.add(new Event(rs.getInt("numero"),rs.getString("dateann"),rs.getString("nom"), rs.getString("prenom"),rs.getString("type"),rs.getString("description")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
        
     }

 public List<Offre> rechercherpartbycomp(String choix,String nom) throws SQLException {
        List<Offre> event = new ArrayList<>();
      Offre p = null ;
      /*String nom1="";
      nom1="'"+nom+"%'";
     System.out.println(nom1);*/

      String req1="select * from offre where "+choix+" LIKE '"+nom+"'";
      System.out.println(req1);
          Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(req1);
          
          //ResultSet res=  ste.executeQuery(req2);
          while (rs.next()) { 
              p = new Offre();
                     p.setId( rs.getInt("id"));
                      p.setContrat(rs.getString("Contrat") );
                      p.setLieu(rs.getString("Lieu"));
                      p.setRemuneration(rs.getString("Remuneration"));
                      p.setCompetence(rs.getString("Competence"));
                      p.setParttime (rs.getString("Parttime"));
                     
                      event.add(p);

          }
        return event;
  }
}