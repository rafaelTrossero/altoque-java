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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rat_5
 */
@Entity
@Table(name = "estado_config_wifi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoConfigWifi.findAll", query = "SELECT e FROM EstadoConfigWifi e")
    , @NamedQuery(name = "EstadoConfigWifi.findByCreateTime", query = "SELECT e FROM EstadoConfigWifi e WHERE e.createTime = :createTime")
    , @NamedQuery(name = "EstadoConfigWifi.findByUpdateTime", query = "SELECT e FROM EstadoConfigWifi e WHERE e.updateTime = :updateTime")
    , @NamedQuery(name = "EstadoConfigWifi.findByIsActive", query = "SELECT e FROM EstadoConfigWifi e WHERE e.isActive = :isActive")
    , @NamedQuery(name = "EstadoConfigWifi.findByIdUsuarioUpdate", query = "SELECT e FROM EstadoConfigWifi e WHERE e.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "EstadoConfigWifi.findByIdEstadoConfigWifi", query = "SELECT e FROM EstadoConfigWifi e WHERE e.idEstadoConfigWifi = :idEstadoConfigWifi")
    , @NamedQuery(name = "EstadoConfigWifi.findBySsid", query = "SELECT e FROM EstadoConfigWifi e WHERE e.ssid = :ssid")
    , @NamedQuery(name = "EstadoConfigWifi.findByPass", query = "SELECT e FROM EstadoConfigWifi e WHERE e.pass = :pass")})
public class EstadoConfigWifi implements Serializable {

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
    @Column(name = "id_estado_config_wifi")
    private Integer idEstadoConfigWifi;
    @Size(max = 100)
    @Column(name = "ssid")
    private String ssid;
    @Size(max = 100)
    @Column(name = "pass")
    private String pass;

    public EstadoConfigWifi() {
    }

    public EstadoConfigWifi(Integer idEstadoConfigWifi) {
        this.idEstadoConfigWifi = idEstadoConfigWifi;
    }

    public EstadoConfigWifi(Integer idEstadoConfigWifi, short isActive) {
        this.idEstadoConfigWifi = idEstadoConfigWifi;
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

    public Integer getIdEstadoConfigWifi() {
        return idEstadoConfigWifi;
    }

    public void setIdEstadoConfigWifi(Integer idEstadoConfigWifi) {
        this.idEstadoConfigWifi = idEstadoConfigWifi;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoConfigWifi != null ? idEstadoConfigWifi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConfigWifi)) {
            return false;
        }
        EstadoConfigWifi other = (EstadoConfigWifi) object;
        if ((this.idEstadoConfigWifi == null && other.idEstadoConfigWifi != null) || (this.idEstadoConfigWifi != null && !this.idEstadoConfigWifi.equals(other.idEstadoConfigWifi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EstadoConfigWifi[ idEstadoConfigWifi=" + idEstadoConfigWifi + " ]";
    }
    
}
