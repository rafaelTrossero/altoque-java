/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rat_5
 */
@Entity
@Table(name = "permisosComando")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisosComando.findByChatId", query = "SELECT p FROM PermisosComando p where p.idChat =:idchat")})
public class PermisosComando implements Serializable {
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
    
    @Column(name = "id_chat")
    private Long idChat;
    
    @Column(name = "permiso_resultados")
    private Boolean permiso_resultados;
    
    @Column(name = "is_active")
    private Boolean isActive;

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

    public Long getIdChat() {
        return idChat;
    }

    public void setIdChat(Long idChat) {
        this.idChat = idChat;
    }

    public Boolean getPermiso_resultados() {
        return permiso_resultados;
    }

    public void setPermiso_resultados(Boolean permiso_resultados) {
        this.permiso_resultados = permiso_resultados;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.apeNom);
        hash = 67 * hash + Objects.hashCode(this.telefono);
        hash = 67 * hash + Objects.hashCode(this.descripcion);
        hash = 67 * hash + Objects.hashCode(this.idChat);
        hash = 67 * hash + Objects.hashCode(this.permiso_resultados);
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
        final PermisosComando other = (PermisosComando) obj;
        if (!Objects.equals(this.apeNom, other.apeNom)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idChat, other.idChat)) {
            return false;
        }
        if (!Objects.equals(this.permiso_resultados, other.permiso_resultados)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PermisosComando{" + "id=" + id + ", apeNom=" + apeNom + ", telefono=" + telefono + ", descripcion=" + descripcion + ", idChat=" + idChat + ", permiso_resultados=" + permiso_resultados + '}';
    }
    
    
    
    
    
}
