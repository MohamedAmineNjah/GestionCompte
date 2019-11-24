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
public class Reclamation {
    private int id11;
    private String sujet11;
    private String text11;
    private String phone11;

    public Reclamation() {
    }

    public Reclamation(String sujet11, String text11, String phone11) {
        this.sujet11 = sujet11;
        this.text11 = text11;
        this.phone11 = phone11;
    }

    public Reclamation(int id11, String sujet11, String text11, String phone11) {
        this.id11 = id11;
        this.sujet11 = sujet11;
        this.text11 = text11;
        this.phone11 = phone11;
    }

    public int getId11() {
        return id11;
    }

    public void setId11(int id11) {
        this.id11 = id11;
    }

    public String getSujet11() {
        return sujet11;
    }

    public void setSujet11(String sujet11) {
        this.sujet11 = sujet11;
    }

    public String getText11() {
        return text11;
    }

    public void setText11(String text11) {
        this.text11 = text11;
    }

    public String getPhone11() {
        return phone11;
    }

    public void setPhone11(String phone11) {
        this.phone11 = phone11;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id11;
        hash = 17 * hash + Objects.hashCode(this.sujet11);
        hash = 17 * hash + Objects.hashCode(this.text11);
        hash = 17 * hash + Objects.hashCode(this.phone11);
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
        final Reclamation other = (Reclamation) obj;
        if (this.id11 != other.id11) {
            return false;
        }
        if (!Objects.equals(this.sujet11, other.sujet11)) {
            return false;
        }
        if (!Objects.equals(this.text11, other.text11)) {
            return false;
        }
        if (!Objects.equals(this.phone11, other.phone11)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id11=" + id11 + ", sujet11=" + sujet11 + ", text11=" + text11 + ", phone11=" + phone11 + '}';
    }
    
    
}
