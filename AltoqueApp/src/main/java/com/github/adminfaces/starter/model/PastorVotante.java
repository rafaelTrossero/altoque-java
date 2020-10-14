/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.model;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rat_5
 */
@Entity
@Table(name = "pastor_votante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PastorVotante.findAll", query = "SELECT p FROM PastorVotante p")
    , @NamedQuery(name = "PastorVotante.findById", query = "SELECT p FROM PastorVotante p WHERE p.id = :id")
    , @NamedQuery(name = "PastorVotante.removeByPastor", query = "DELETE FROM PastorVotante p WHERE p.pastor = :pastor")
    , @NamedQuery(name = "PastorVotante.findVotantesByPastor", query = "SELECT p.votante FROM PastorVotante p WHERE p.pastor = :pastor AND p.isActive = true")
    , @NamedQuery(name = "PastorVotante.findByUserCarga", query = "SELECT p FROM PastorVotante p WHERE p.userCarga = :userCarga")
    , @NamedQuery(name = "PastorVotante.findByVotanteYpastor", query = "SELECT p FROM PastorVotante p WHERE p.pastor = :pastor AND p.votante =:votante")
    , @NamedQuery(name = "PastorVotante.findByIsActive", query = "SELECT p FROM PastorVotante p WHERE p.isActive = :isActive")})

public class PastorVotante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "padronVv")
    private PadronVv votante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pastor")
    private Pastor pastor;

    @Column(name = "user_carga")
    private Integer userCarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;

    public PastorVotante() {
    }

    public PastorVotante(Integer id) {
        this.id = id;
    }

    public PastorVotante(Integer id, int idVotante, boolean isActive) {
        this.id = id;

        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserCarga() {
        return userCarga;
    }

    public void setUserCarga(Integer userCarga) {
        this.userCarga = userCarga;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public PadronVv getVotante() {
        return votante;
    }

    public void setVotante(PadronVv votante) {
        this.votante = votante;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Pastor getPastor() {
        return pastor;
    }

    public void setPastor(Pastor pastor) {
        this.pastor = pastor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PastorVotante)) {
            return false;
        }
        PastorVotante other = (PastorVotante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.github.adminfaces.starter.model.PastorVotante[ id=" + id + " ]";
    }

}
