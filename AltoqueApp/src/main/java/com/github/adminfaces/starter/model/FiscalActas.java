/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rat_5
 */
@Entity
@Table(name = "fiscal_actas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FiscalActas.findAll", query = "SELECT f FROM FiscalActas f")
    , @NamedQuery(name = "FiscalActas.findAllNoCargadas", query = "SELECT f FROM FiscalActas f WHERE f.isCargada = FALSE")
    , @NamedQuery(name = "FiscalActas.findAllCargadas", query = "SELECT f FROM FiscalActas f WHERE f.isCargada = TRUE")
    , @NamedQuery(name = "FiscalActas.findAllManual", query = "SELECT f FROM FiscalActas f WHERE f.isManual = TRUE")
    , @NamedQuery(name = "FiscalActas.findById", query = "SELECT f FROM FiscalActas f WHERE f.id = :id")
    , @NamedQuery(name = "FiscalActas.findByFecha", query = "SELECT f FROM FiscalActas f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "FiscalActas.findByImagen", query = "SELECT f FROM FiscalActas f WHERE f.imagen = :imagen")
    , @NamedQuery(name = "FiscalActas.findByIsActive", query = "SELECT f FROM FiscalActas f WHERE f.isActive = :isActive")
    , @NamedQuery(name = "FiscalActas.findByIsValidated", query = "SELECT f FROM FiscalActas f WHERE f.isValidated = :isValidated")
    , @NamedQuery(name = "FiscalActas.findByIsCargadaTipo", query = "SELECT f FROM FiscalActas f WHERE f.isCargada = TRUE AND f.tipo =:tipo AND f.mesa =:mesa")
    , @NamedQuery(name = "FiscalActas.findByIdFiscal", query = "SELECT f FROM FiscalActas f WHERE f.idFiscal = :idFiscal")})
public class FiscalActas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "mesa")
    private Integer mesa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_validated")
    private Boolean isValidated;
    @Column(name = "is_cargada")
    private Boolean isCargada;
    @Column(name = "is_manual", columnDefinition = "boolean default false")
    private Boolean isManual;
    @Column(name = "id_fiscal")
    private Integer idFiscal;
    @Column(name = "tipo")
    private String tipo; //provincial o nacional

    @ManyToOne(optional = false)
    @JoinColumn(name = "fiscal")
    private Fiscal fiscal;

    @OneToMany(mappedBy = "acta_fiscal")
    private List<Acta> lstActaFiscal;

    public FiscalActas() {
    }

    public FiscalActas(Integer id) {
        this.id = id;
    }

    public FiscalActas(Integer id, Date fecha, String imagen, boolean isActive) {
        this.id = id;
        this.fecha = fecha;
        this.imagen = imagen;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsValidated() {
        return isValidated;
    }

    public void setIsValidated(Boolean isValidated) {
        this.isValidated = isValidated;
    }

    public Integer getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(Integer idFiscal) {
        this.idFiscal = idFiscal;
    }

    public Fiscal getFiscal() {
        return fiscal;
    }

    public void setFiscal(Fiscal fiscal) {
        this.fiscal = fiscal;
    }

    public Boolean getIsCargada() {
        return isCargada;
    }

    public void setIsCargada(Boolean isCargada) {
        this.isCargada = isCargada;
    }

    public List<Acta> getLstActaFiscal() {
        return lstActaFiscal;
    }

    public void setLstActaFiscal(List<Acta> lstActaFiscal) {
        this.lstActaFiscal = lstActaFiscal;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getIsManual() {
        return isManual;
    }

    public void setIsManual(Boolean isManual) {
        this.isManual = isManual;
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
        if (!(object instanceof FiscalActas)) {
            return false;
        }
        FiscalActas other = (FiscalActas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.github.adminfaces.starter.model.FiscalActas[ id=" + id + " ]";
    }

}
