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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "rol_permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolPermiso.findAll", query = "SELECT r FROM RolPermiso r")
    , @NamedQuery(name = "RolPermiso.findByCreateTime", query = "SELECT r FROM RolPermiso r WHERE r.createTime = :createTime")
    , @NamedQuery(name = "RolPermiso.findByUpdateTime", query = "SELECT r FROM RolPermiso r WHERE r.updateTime = :updateTime")
    , @NamedQuery(name = "RolPermiso.findByIsActive", query = "SELECT r FROM RolPermiso r WHERE r.isActive = :isActive")
    , @NamedQuery(name = "RolPermiso.findByIdUsuarioUpdate", query = "SELECT r FROM RolPermiso r WHERE r.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "RolPermiso.findByIdRolPermiso", query = "SELECT r FROM RolPermiso r WHERE r.id = :id")})
public class RolPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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


    
    
     @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id", insertable = false, updatable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_permiso", referencedColumnName = "id", insertable = false, updatable = false)
    private Permiso permiso;
    

    public RolPermiso() {
    }

    public RolPermiso(Integer idRolPermiso) {
        this.id = idRolPermiso;
    }

    public RolPermiso(Integer idRolPermiso, short isActive, short idRol, short idPermiso) {
        this.id = idRolPermiso;
        this.isActive = isActive;
        
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

    public Integer getIdRolPermiso() {
        return id;
    }

    public void setIdRolPermiso(Integer idRolPermiso) {
        this.id = idRolPermiso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
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
        if (!(object instanceof RolPermiso)) {
            return false;
        }
        RolPermiso other = (RolPermiso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.RolPermiso[ idRolPermiso=" + id + " ]";
    }
    
}
