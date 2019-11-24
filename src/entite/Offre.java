/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Objects;

/**
 *
 * @author MOHAMED RTIMI
 */
public class Offre {
     private int id;
    private String contrat;
    private String lieu;
    private String remuneration;
    private String competence;
    private String parttime;

    public Offre(String contrat, String lieu, String remuneration, String competence, String parttime) {
        this.contrat = contrat;
        this.lieu = lieu;
        this.remuneration = remuneration;
        this.competence = competence;
        this.parttime = parttime;
    }

    public Offre() {
    }
    
   
    
    public Offre (int id, String contrat, String lieu, String remuneration, String competence, String parttime) {
        this.id = id;
        this.contrat = contrat;
        this.lieu = lieu;
        this.remuneration = remuneration;
        this.competence = competence;
        this.parttime = parttime;
        
     }
        
        public Offre(String contrat, String lieu) {
        this.contrat = contrat;
        this.lieu = lieu;
        }
        
        public int getId() {
        return id;
        }
        
        
         public void setId(int id) {
        this.id = id;
    }
         
         public String getContrat() {
        return contrat;
    }
         
         public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    public String getRenumeration() {
        return remuneration;
    }

    public void setRemuneration(String renumeration) {
        this.remuneration = remuneration;
    }
    
    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }
    
    public String getParttime() {
        return parttime;
    }

    public void setParttime(String parttime) {
        this.parttime = parttime;
    }

    @Override
    public String toString() {
        return "offre{" + "id=" + id + ", contrat=" + contrat + ", lieu=" + lieu + ", remuneration=" + remuneration + ", competence=" + competence + ", parttime=" +parttime + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Offre other = (Offre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.contrat, other.contrat)) {
            return false;
        }
         if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
         }
          if (!Objects.equals(this.remuneration, other.remuneration)) {
            return false;
          }
           if (!Objects.equals(this.competence, other.competence)) {
            return false;
           }
            if (!Objects.equals(this.parttime, other.parttime)) {
            return false;
            }
        return true;
    }
    
    
    
    
}
   
