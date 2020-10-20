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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rat_5
 */
@Entity
@Table(name = "usuario_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u")
    , @NamedQuery(name = "UsuarioRol.findByCreateTime", query = "SELECT u FROM UsuarioRol u WHERE u.createTime = :createTime")
    , @NamedQuery(name = "UsuarioRol.findByUpdateTime", query = "SELECT u FROM UsuarioRol u WHERE u.updateTime = :updateTime")
    , @NamedQuery(name = "UsuarioRol.findByIsActive", query = "SELECT u FROM UsuarioRol u WHERE u.isActive = :isActive")
    , @NamedQuery(name = "UsuarioRol.findByIdUsuarioRol", query = "SELECT u FROM UsuarioRol u WHERE u.id = :id")
    , @NamedQuery(name = "UsuarioRol.findByUsuarioRolcol", query = "SELECT u FROM UsuarioRol u WHERE u.usuarioRolcol = :usuarioRolcol")})
public class UsuarioRol implements Serializable {

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
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario_rolcol")
    private String usuarioRolcol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private short idUsuario;

     @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id", insertable = false, updatable = false)
    private Rol rol;
    
    

    public UsuarioRol() {
    }

    public UsuarioRol(Integer idUsuarioRol) {
        this.id = idUsuarioRol;
    }

    public UsuarioRol(Integer idUsuarioRol, short isActive, String usuarioRolcol, short idUsuario, short idRol) {
        this.id = idUsuarioRol;
        this.isActive = isActive;
        this.usuarioRolcol = usuarioRolcol;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  

    public String getUsuarioRolcol() {
        return usuarioRolcol;
    }

    public void setUsuarioRolcol(String usuarioRolcol) {
        this.usuarioRolcol = usuarioRolcol;
    }

    public short getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(short idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.UsuarioRol[ idUsuarioRol=" + id + " ]";
    }
    
}
