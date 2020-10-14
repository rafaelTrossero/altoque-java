/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rat_5
 */
@Entity
@Table(name = "pastor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pastor.findAll", query = "SELECT p FROM Pastor p")
    , @NamedQuery(name = "Pastor.findById", query = "SELECT p FROM Pastor p WHERE p.id = :id")
    , @NamedQuery(name = "Pastor.findByApeNom", query = "SELECT p FROM Pastor p WHERE p.apeNom = :apeNom")
    , @NamedQuery(name = "Pastor.findByTelefono", query = "SELECT p FROM Pastor p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Pastor.findByDescripcion", query = "SELECT p FROM Pastor p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Pastor.findByCantidad", query = "SELECT p FROM Pastor p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Pastor.findByNivelConfianza", query = "SELECT p FROM Pastor p WHERE p.nivelConfianza = :nivelConfianza")
    , @NamedQuery(name = "Pastor.findByIsActive", query = "SELECT p FROM Pastor p WHERE p.isActive = :isActive")})
public class Pastor implements Serializable {

   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "ape_nom")
    private String apeNom;
    @Size(max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "nivel_confianza")
    private Integer nivelConfianza;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    
     @OneToMany(mappedBy = "pastor")
    private List<PastorVotante> lstPastorVotante;
     
     @OneToMany(mappedBy = "pastor")
    private List<PastorCar> lstPastorCar;

    public Pastor() {
    }

    public Pastor(Integer id) {
        this.id = id;
    }

    public Pastor(Integer id, boolean isActive) {
        this.id = id;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApeNom() {
        return apeNom;
    }

    public void setApeNom(String apeNom) {
        this.apeNom = apeNom;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getNivelConfianza() {
        return nivelConfianza;
    }

    public void setNivelConfianza(Integer nivelConfianza) {
        this.nivelConfianza = nivelConfianza;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<PastorVotante> getLstPastorVotante() {
        return lstPastorVotante;
    }

    public void setLstPastorVotante(List<PastorVotante> lstPastorVotante) {
        this.lstPastorVotante = lstPastorVotante;
    }

    public List<PastorCar> getLstPastorCar() {
        return lstPastorCar;
    }

    public void setLstPastorCar(List<PastorCar> lstPastorCar) {
        this.lstPastorCar = lstPastorCar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public boolean hasApeNom() {
        return apeNom != null && !"".equals(apeNom.trim());
    }

    public boolean hasTel() {
        return telefono != null && !"".equals(telefono.trim());
    }

    public boolean hasDesc() {
        return descripcion != null && !"".equals(descripcion.trim());
    }

    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pastor)) {
            return false;
        }
        Pastor other = (Pastor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.github.adminfaces.starter.model.Pastor[ id=" + id + " ]";
    }

}
