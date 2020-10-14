/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author USUARIO
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "PastorCar.findAll", query = "SELECT p FROM PastorCar p")
    , @NamedQuery(name = "PastorCar.findById", query = "SELECT p FROM PastorCar p WHERE p.id = :id")
    , @NamedQuery(name = "PastorCar.findCarByPastor", query = "SELECT p.car FROM PastorCar p WHERE p.pastor = :pastor")
    , @NamedQuery(name = "PastorCar.findByUserCarga", query = "SELECT p FROM PastorCar p WHERE p.userCarga = :userCarga")
    , @NamedQuery(name = "PastorCar.findByIsActive", query = "SELECT p FROM PastorCar p WHERE p.isActive = :isActive")})

public class PastorCar implements Serializable {

  
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    

    @ManyToOne(optional = false)
    @JoinColumn(name = "pastor")
    private Pastor pastor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car")
    private Car car;

   
    @Column(name = "user_carga")
    private Integer userCarga;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pastor getPastor() {
        return pastor;
    }

    public void setPastor(Pastor pastor) {
        this.pastor = pastor;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getUserCarga() {
        return userCarga;
    }

    public void setUserCarga(Integer userCarga) {
        this.userCarga = userCarga;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
        if (!(object instanceof PastorCar)) {
            return false;
        }
        PastorCar other = (PastorCar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.github.adminfaces.starter.model.PastorCar[ id=" + id + " ]";
    }
    
}
