/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rat_5
 */
@Entity
@Table(name = "sesiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesiones.findAll", query = "SELECT s FROM Sesiones s")
    , @NamedQuery(name = "Sesiones.findByCreateTime", query = "SELECT s FROM Sesiones s WHERE s.createTime = :createTime")
    , @NamedQuery(name = "Sesiones.findByUpdateTime", query = "SELECT s FROM Sesiones s WHERE s.updateTime = :updateTime")
    , @NamedQuery(name = "Sesiones.findByIsActive", query = "SELECT s FROM Sesiones s WHERE s.isActive = :isActive")
    , @NamedQuery(name = "Sesiones.findByIdUsuarioUpdate", query = "SELECT s FROM Sesiones s WHERE s.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Sesiones.findByIdSesion", query = "SELECT s FROM Sesiones s WHERE s.idSesion = :idSesion")
    , @NamedQuery(name = "Sesiones.findByIdUsuario", query = "SELECT s FROM Sesiones s WHERE s.idUsuario = :idUsuario")})
public class Sesiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private short isActive;
    @Column(name = "id_usuario_update")
    private Short idUsuarioUpdate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sesion")
    private Integer idSesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private short idUsuario;

    public Sesiones() {
    }

    public Sesiones(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public Sesiones(Integer idSesion, short isActive, short idUsuario) {
        this.idSesion = idSesion;
        this.isActive = isActive;
        this.idUsuario = idUsuario;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public Short getIdUsuarioUpdate() {
        return idUsuarioUpdate;
    }

    public void setIdUsuarioUpdate(Short idUsuarioUpdate) {
        this.idUsuarioUpdate = idUsuarioUpdate;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSesion != null ? idSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesiones)) {
            return false;
        }
        Sesiones other = (Sesiones) object;
        if ((this.idSesion == null && other.idSesion != null) || (this.idSesion != null && !this.idSesion.equals(other.idSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Sesiones[ idSesion=" + idSesion + " ]";
    }
    
}
