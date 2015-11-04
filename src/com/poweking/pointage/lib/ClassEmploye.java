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

/**
 *
 */
@Entity
@Table(name = "employe", catalog = "gestion_pointage", schema = "")
@NamedQueries({
    @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e"),
    @NamedQuery(name = "Employe.findByMatricule", query = "SELECT e FROM Employe e WHERE e.matricule = :matricule"),
    @NamedQuery(name = "Employe.findByNom", query = "SELECT e FROM Employe e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employe.findByDepartemet", query = "SELECT e FROM Employe e WHERE e.departemet = :departemet"),
    @NamedQuery(name = "Employe.findByTauxPre", query = "SELECT e FROM Employe e WHERE e.tauxPre = :tauxPre"),
    @NamedQuery(name = "Employe.findBySalaireJour", query = "SELECT e FROM Employe e WHERE e.salaireJour = :salaireJour")})
public class ClassEmploye implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Matricule")
    private Integer matricule;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "departemet")
    private String departemet;
    @Basic(optional = false)
    @Column(name = "taux_pre")
    private int tauxPre;
    @Basic(optional = false)
    @Column(name = "salaire_Jour")
    private int salaireJour;

    public ClassEmploye() {
    }

    public ClassEmploye(Integer matricule) {
        this.matricule = matricule;
    }

    public ClassEmploye(Integer matricule, String nom, String departemet, int tauxPre, int salaireJour) {
        this.matricule = matricule;
        this.nom = nom;
        this.departemet = departemet;
        this.tauxPre = tauxPre;
        this.salaireJour = salaireJour;
    }

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        Integer oldMatricule = this.matricule;
        this.matricule = matricule;
        changeSupport.firePropertyChange("matricule", oldMatricule, matricule);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        changeSupport.firePropertyChange("nom", oldNom, nom);
    }

    public String getDepartemet() {
        return departemet;
    }

    public void setDepartemet(String departemet) {
        String oldDepartemet = this.departemet;
        this.departemet = departemet;
        changeSupport.firePropertyChange("departemet", oldDepartemet, departemet);
    }

    public int getTauxPre() {
        return tauxPre;
    }

    public void setTauxPre(int tauxPre) {
        int oldTauxPre = this.tauxPre;
        this.tauxPre = tauxPre;
        changeSupport.firePropertyChange("tauxPre", oldTauxPre, tauxPre);
    }

    public int getSalaireJour() {
        return salaireJour;
    }

    public void setSalaireJour(int salaireJour) {
        int oldSalaireJour = this.salaireJour;
        this.salaireJour = salaireJour;
        changeSupport.firePropertyChange("salaireJour", oldSalaireJour, salaireJour);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricule != null ? matricule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassEmploye)) {
            return false;
        }
        ClassEmploye other = (ClassEmploye) object;
        if ((this.matricule == null && other.matricule != null) || (this.matricule != null && !this.matricule.equals(other.matricule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nom+";"+matricule;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
