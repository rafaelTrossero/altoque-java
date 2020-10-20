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
@Table(name = "alimentacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimentacion.findAll", query = "SELECT a FROM Alimentacion a")
    , @NamedQuery(name = "Alimentacion.findByCreateTime", query = "SELECT a FROM Alimentacion a WHERE a.createTime = :createTime")
    , @NamedQuery(name = "Alimentacion.findByUpdateTime", query = "SELECT a FROM Alimentacion a WHERE a.updateTime = :updateTime")
    , @NamedQuery(name = "Alimentacion.findByIsActive", query = "SELECT a FROM Alimentacion a WHERE a.isActive = :isActive")
    , @NamedQuery(name = "Alimentacion.findByIdUsuarioUpdate", query = "SELECT a FROM Alimentacion a WHERE a.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Alimentacion.findByIdEquipo", query = "SELECT a FROM Alimentacion a WHERE a.idEquipo = :idEquipo")
    , @NamedQuery(name = "Alimentacion.findByTsBateria", query = "SELECT a FROM Alimentacion a WHERE a.tsBateria = :tsBateria")
    , @NamedQuery(name = "Alimentacion.findByIdAlimentacion", query = "SELECT a FROM Alimentacion a WHERE a.idAlimentacion = :idAlimentacion")
    , @NamedQuery(name = "Alimentacion.findByPwd", query = "SELECT a FROM Alimentacion a WHERE a.pwd = :pwd")
    , @NamedQuery(name = "Alimentacion.findByCarga", query = "SELECT a FROM Alimentacion a WHERE a.carga = :carga")})
public class Alimentacion implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private short idEquipo;
    @Column(name = "ts_bateria")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsBateria;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alimentacion")
    private Integer idAlimentacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pwd")
    private short pwd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga")
    private short carga;

    public Alimentacion() {
    }

    public Alimentacion(Integer idAlimentacion) {
        this.idAlimentacion = idAlimentacion;
    }

    public Alimentacion(Integer idAlimentacion, short isActive, short idEquipo, short pwd, short carga) {
        this.idAlimentacion = idAlimentacion;
        this.isActive = isActive;
        this.idEquipo = idEquipo;
        this.pwd = pwd;
        this.carga = carga;
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

    public short getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(short idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Date getTsBateria() {
        return tsBateria;
    }

    public void setTsBateria(Date tsBateria) {
        this.tsBateria = tsBateria;
    }

    public Integer getIdAlimentacion() {
        return idAlimentacion;
    }

    public void setIdAlimentacion(Integer idAlimentacion) {
        this.idAlimentacion = idAlimentacion;
    }

    public short getPwd() {
        return pwd;
    }

    public void setPwd(short pwd) {
        this.pwd = pwd;
    }

    public short getCarga() {
        return carga;
    }

    public void setCarga(short carga) {
        this.carga = carga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlimentacion != null ? idAlimentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimentacion)) {
            return false;
        }
        Alimentacion other = (Alimentacion) object;
        if ((this.idAlimentacion == null && other.idAlimentacion != null) || (this.idAlimentacion != null && !this.idAlimentacion.equals(other.idAlimentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Alimentacion[ idAlimentacion=" + idAlimentacion + " ]";
    }
    
}
