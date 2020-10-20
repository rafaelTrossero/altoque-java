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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByCreateTime", query = "SELECT r FROM Rol r WHERE r.createTime = :createTime")
    , @NamedQuery(name = "Rol.findByUpdateTime", query = "SELECT r FROM Rol r WHERE r.updateTime = :updateTime")
    , @NamedQuery(name = "Rol.findByIsActive", query = "SELECT r FROM Rol r WHERE r.isActive = :isActive")
    , @NamedQuery(name = "Rol.findByIdUsuarioUpdate", query = "SELECT r FROM Rol r WHERE r.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Rol.findByIdRol", query = "SELECT r FROM Rol r WHERE r.id = :id")
    , @NamedQuery(name = "Rol.findByIdGrupo", query = "SELECT r FROM Rol r WHERE r.idGrupo = :idGrupo")
    , @NamedQuery(name = "Rol.findByNombre", query = "SELECT r FROM Rol r WHERE r.nombre = :nombre")})
public class Rol implements Serializable {

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
    @Column(name = "id_grupo")
    private short idGrupo;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    
    //relacion RolPermiso

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rol")
    private List<RolPermiso> rolPermiso = new ArrayList<>();
    
    //relacion UsuarioRol

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rol")
    private List<UsuarioRol> usuarioRol = new ArrayList<>();
    

    public Rol() {
    }

    public Rol(Integer idRol) {
        this.id = id;
    }

    public Rol(Short idRol, short isActive, short idGrupo) {
        this.id = id;
        this.isActive = isActive;
        this.idGrupo = idGrupo;
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

    public Integer getIdRol() {
        return id;
    }

    public void setIdRol(Integer idRol) {
        this.id = id;
    }

    public short getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(short idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<RolPermiso> getRolPermiso() {
        return rolPermiso;
    }

    public void setRolPermiso(List<RolPermiso> rolPermiso) {
        this.rolPermiso = rolPermiso;
    }

    public List<UsuarioRol> getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(List<UsuarioRol> usuarioRol) {
        this.usuarioRol = usuarioRol;
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
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Rol[ idRol=" + id + " ]";
    }
    
}
