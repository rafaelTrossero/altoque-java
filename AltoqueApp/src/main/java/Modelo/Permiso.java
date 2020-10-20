/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByCreateTime", query = "SELECT p FROM Permiso p WHERE p.createTime = :createTime")
    , @NamedQuery(name = "Permiso.findByUpdateTime", query = "SELECT p FROM Permiso p WHERE p.updateTime = :updateTime")
    , @NamedQuery(name = "Permiso.findByIsActive", query = "SELECT p FROM Permiso p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "Permiso.findByIdUsuarioUpdate", query = "SELECT p FROM Permiso p WHERE p.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Permiso.findByIdPermiso", query = "SELECT p FROM Permiso p WHERE p.id = :id")
    , @NamedQuery(name = "Permiso.findByModelo", query = "SELECT p FROM Permiso p WHERE p.modelo = :modelo")
    , @NamedQuery(name = "Permiso.findByAccion", query = "SELECT p FROM Permiso p WHERE p.accion = :accion")})
public class Permiso implements Serializable {

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

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Size(max = 200)
    @Column(name = "accion")
    private String accion;
    
    //relacion RolPermiso

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "permiso")
    private List<RolPermiso> rolPermiso = new ArrayList<>();
    
    

    public Permiso() {
    }

    public Permiso(Integer idPermiso) {
        this.id = idPermiso;
    }

    public Permiso(Integer idPermiso, short isActive, String modelo) {
        this.id = idPermiso;
        this.isActive = isActive;
        this.modelo = modelo;
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

    public Integer getIdUsuarioUpdate() {
        return id;
    }

    public void setIdUsuarioUpdate(Integer idUsuarioUpdate) {
        this.id = idUsuarioUpdate;
    }

    public Integer getIdPermiso() {
        return id;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.id = idPermiso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<RolPermiso> getRolPermiso() {
        return rolPermiso;
    }

    public void setRolPermiso(List<RolPermiso> rolPermiso) {
        this.rolPermiso = rolPermiso;
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
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Permiso[ idPermiso=" + id + " ]";
    }
    
}
