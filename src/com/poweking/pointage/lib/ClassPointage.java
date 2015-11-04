/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poweking.pointage.lib;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "pointage", catalog = "gestion_pointage", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pointage.findAll", query = "SELECT p FROM Pointage p"),
    @NamedQuery(name = "Pointage.findByIdPointage", query = "SELECT p FROM Pointage p WHERE p.idPointage = :idPointage"),
    @NamedQuery(name = "Pointage.findByDate", query = "SELECT p FROM Pointage p WHERE p.date = :date"),
    @NamedQuery(name = "Pointage.findByHeureDeb", query = "SELECT p FROM Pointage p WHERE p.heureDeb = :heureDeb"),
    @NamedQuery(name = "Pointage.findByHeureFin", query = "SELECT p FROM Pointage p WHERE p.heureFin = :heureFin"),
    @NamedQuery(name = "Pointage.findByMatricule", query = "SELECT p FROM Pointage p WHERE p.matricule = :matricule")})
public class ClassPointage implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPointage")
    private Integer idPointage;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @Column(name = "heure_deb")
    private String heureDeb;
    @Basic(optional = false)
    @Column(name = "heure_fin")
    private String heureFin;
    @Basic(optional = false)
    @Column(name = "matricule")
    private int matricule;

    public ClassPointage() {
    }

    public ClassPointage(Integer idPointage) {
        this.idPointage = idPointage;
    }

    public ClassPointage(Integer idPointage, String date, String heureDeb, String heureFin, int matricule) {
        this.idPointage = idPointage;
        this.date = date;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;
        this.matricule = matricule;
    }

    public Integer getIdPointage() {
        return idPointage;
    }

    public void setIdPointage(Integer idPointage) {
        Integer oldIdPointage = this.idPointage;
        this.idPointage = idPointage;
        changeSupport.firePropertyChange("idPointage", oldIdPointage, idPointage);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getHeureDeb() {
        return heureDeb;
    }

    public void setHeureDeb(String heureDeb) {
        String oldHeureDeb = this.heureDeb;
        this.heureDeb = heureDeb;
        changeSupport.firePropertyChange("heureDeb", oldHeureDeb, heureDeb);
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        String oldHeureFin = this.heureFin;
        this.heureFin = heureFin;
        changeSupport.firePropertyChange("heureFin", oldHeureFin, heureFin);
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        int oldMatricule = this.matricule;
        this.matricule = matricule;
        changeSupport.firePropertyChange("matricule", oldMatricule, matricule);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPointage != null ? idPointage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassPointage)) {
            return false;
        }
        ClassPointage other = (ClassPointage) object;
        if ((this.idPointage == null && other.idPointage != null) || (this.idPointage != null && !this.idPointage.equals(other.idPointage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "another.Pointage[ idPointage=" + idPointage + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
