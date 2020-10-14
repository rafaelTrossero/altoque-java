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
@Table(name = "fiscal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fiscal.findAll", query = "SELECT f FROM Fiscal f")
    , @NamedQuery(name = "Fiscal.findById", query = "SELECT f FROM Fiscal f WHERE f.id = :id")
    , @NamedQuery(name = "Fiscal.findByApeNom", query = "SELECT f FROM Fiscal f WHERE f.apeNom = :apeNom")
    , @NamedQuery(name = "Fiscal.findByMesa", query = "SELECT f FROM Fiscal f WHERE f.mesa = :mesa")
    , @NamedQuery(name = "Fiscal.findByTelefono", query = "SELECT f FROM Fiscal f WHERE f.telefono = :telefono")
    , @NamedQuery(name = "Fiscal.findByChatId", query = "SELECT f FROM Fiscal f WHERE f.chatId = :chatId")
    , @NamedQuery(name = "Fiscal.findByAutorizado", query = "SELECT f FROM Fiscal f WHERE f.autorizado = :autorizado")
    , @NamedQuery(name = "Fiscal.findByAutorizo", query = "SELECT f FROM Fiscal f WHERE f.autorizo = :autorizo")
    , @NamedQuery(name = "Fiscal.findByFechaAutorizacion", query = "SELECT f FROM Fiscal f WHERE f.fechaAutorizacion = :fechaAutorizacion")
    , @NamedQuery(name = "Fiscal.findByNivelConfianza", query = "SELECT f FROM Fiscal f WHERE f.nivelConfianza = :nivelConfianza")
    , @NamedQuery(name = "Fiscal.findByIsActive", query = "SELECT f FROM Fiscal f WHERE f.isActive = :isActive")})
public class Fiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "ape_nom")
    private String apeNom;
    @Column(name = "mesa")
    private Integer mesa;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "chat_id")
    private Integer chatId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autorizado")
    private boolean autorizado;
    @Size(max = 2147483647)
    @Column(name = "autorizo")
    private String autorizo;
    @Column(name = "fecha_autorizacion")
    @Temporal(TemporalType.TIME)
    private Date fechaAutorizacion;
    @Column(name = "nivel_confianza")
    private Integer nivelConfianza;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "is_general")
    private Boolean isGeneral;
     @Column(name = "is_consultavoto")
    private Boolean isConsultaVoto;
    
    @OneToMany(mappedBy = "fiscal")
    private List<FiscalActas> lstFiscalActas; //Actas que suben con la foto
    
     @OneToMany(mappedBy = "fiscal")
    private List<Acta> lstActas; // resultados de acta que se suben a mano


    public Fiscal() {
    }

    public Fiscal(Integer id) {
        this.id = id;
    }

    public Fiscal(Integer id, boolean autorizado) {
        this.id = id;
        this.autorizado = autorizado;
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

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

   

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public boolean getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public String getAutorizo() {
        return autorizo;
    }

    public void setAutorizo(String autorizo) {
        this.autorizo = autorizo;
    }

    public Date getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    public void setFechaAutorizacion(Date fechaAutorizacion) {
        this.fechaAutorizacion = fechaAutorizacion;
    }

    public Integer getNivelConfianza() {
        return nivelConfianza;
    }

    public void setNivelConfianza(Integer nivelConfianza) {
        this.nivelConfianza = nivelConfianza;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<FiscalActas> getLstFiscalActas() {
        return lstFiscalActas;
    }

    public void setLstFiscalActas(List<FiscalActas> lstFiscalActas) {
        this.lstFiscalActas = lstFiscalActas;
    }

    public Boolean getIsGeneral() {
        return isGeneral;
    }

    public void setIsGeneral(Boolean isGeneral) {
        this.isGeneral = isGeneral;
    }

    public List<Acta> getLstActas() {
        return lstActas;
    }

    public void setLstActas(List<Acta> lstActas) {
        this.lstActas = lstActas;
    }

    public Boolean getIsConsultaVoto() {
        return isConsultaVoto;
    }

    public void setIsConsultaVoto(Boolean isConsultaVoto) {
        this.isConsultaVoto = isConsultaVoto;
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
        if (!(object instanceof Fiscal)) {
            return false;
        }
        Fiscal other = (Fiscal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.github.adminfaces.starter.model.Fiscal[ id=" + id + " ]";
    }

    public boolean hasApeNom() {
       return apeNom != null && !"".equals(apeNom.trim());
    }

    public boolean hasTel() {
       return telefono != null && !"".equals(telefono);
    }

    public boolean hasMesa() {
        return mesa != null && !"".equals(mesa);
    }
    
        public boolean hasChatId() {
        return chatId != null && !"".equals(chatId);
    }
    
    
}
