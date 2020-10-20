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
@Table(name = "cuenta_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaEquipo.findAll", query = "SELECT c FROM CuentaEquipo c")
    , @NamedQuery(name = "CuentaEquipo.findByCreateTime", query = "SELECT c FROM CuentaEquipo c WHERE c.createTime = :createTime")
    , @NamedQuery(name = "CuentaEquipo.findByUpdateTime", query = "SELECT c FROM CuentaEquipo c WHERE c.updateTime = :updateTime")
    , @NamedQuery(name = "CuentaEquipo.findByIsActive", query = "SELECT c FROM CuentaEquipo c WHERE c.isActive = :isActive")
    , @NamedQuery(name = "CuentaEquipo.findByIdUsuarioUpdate", query = "SELECT c FROM CuentaEquipo c WHERE c.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "CuentaEquipo.findByIdCuentaEquipo", query = "SELECT c FROM CuentaEquipo c WHERE c.id = :id")
    , @NamedQuery(name = "CuentaEquipo.findByObservaciones", query = "SELECT c FROM CuentaEquipo c WHERE c.observaciones = :observaciones")
    , @NamedQuery(name = "CuentaEquipo.findByFechaBaja", query = "SELECT c FROM CuentaEquipo c WHERE c.fechaBaja = :fechaBaja")})
public class CuentaEquipo implements Serializable {

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
    @JoinColumn(name = "id_equipo", referencedColumnName = "id", insertable = false, updatable = false)
    private Equipos equipo;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id", insertable = false, updatable = false)
    private Cuenta cuenta;
    
    
    
    
    
    
    @Size(max = 500)
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

    public CuentaEquipo() {
    }

    public CuentaEquipo(Integer idCuentaEquipo) {
        this.id = idCuentaEquipo;
    }

    public CuentaEquipo(Integer idCuentaEquipo, short isActive, short idEquipo, short idCuenta) {
        this.id = idCuentaEquipo;
        this.isActive = isActive;
        this.equipo = equipo;
        this.cuenta = cuenta;
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

    public Integer getIdCuentaEquipo() {
        return id;
    }

    public void setIdCuentaEquipo(Integer idCuentaEquipo) {
        this.id = idCuentaEquipo;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

   

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
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
        if (!(object instanceof CuentaEquipo)) {
            return false;
        }
        CuentaEquipo other = (CuentaEquipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CuentaEquipo[ idCuentaEquipo=" + id + " ]";
    }
    
}
