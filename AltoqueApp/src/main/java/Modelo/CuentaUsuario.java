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
@Table(name = "cuenta_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaUsuario.findAll", query = "SELECT c FROM CuentaUsuario c")
    , @NamedQuery(name = "CuentaUsuario.findByCreateTime", query = "SELECT c FROM CuentaUsuario c WHERE c.createTime = :createTime")
    , @NamedQuery(name = "CuentaUsuario.findByUpdateTime", query = "SELECT c FROM CuentaUsuario c WHERE c.updateTime = :updateTime")
    , @NamedQuery(name = "CuentaUsuario.findByIsActive", query = "SELECT c FROM CuentaUsuario c WHERE c.isActive = :isActive")
    , @NamedQuery(name = "CuentaUsuario.findByIdUsuarioUpdate", query = "SELECT c FROM CuentaUsuario c WHERE c.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "CuentaUsuario.findByIdCuentaUsuario", query = "SELECT c FROM CuentaUsuario c WHERE c.id = :id")
})
public class CuentaUsuario implements Serializable {

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
    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id", insertable = false, updatable = false)
    private Cuenta cuenta;
    
    
    public CuentaUsuario() {
    }

    public CuentaUsuario(Integer idCuentaUsuario) {
        this.id = idCuentaUsuario;
    }

    public CuentaUsuario(Integer idCuentaUsuario, short isActive, short idCuenta, short idUsuario) {
        this.id = idCuentaUsuario;
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

    public Integer getIdCuentaUsuario() {
        return id;
    }

    public void setIdCuentaUsuario(Integer idCuentaUsuario) {
        this.id = idCuentaUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
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
        if (!(object instanceof CuentaUsuario)) {
            return false;
        }
        CuentaUsuario other = (CuentaUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CuentaUsuario[ idCuentaUsuario=" + id + " ]";
    }
    
}
