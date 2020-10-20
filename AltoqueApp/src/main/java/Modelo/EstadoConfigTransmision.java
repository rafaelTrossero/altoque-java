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
@Table(name = "estado_config_transmision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoConfigTransmision.findAll", query = "SELECT e FROM EstadoConfigTransmision e")
    , @NamedQuery(name = "EstadoConfigTransmision.findByCreateTime", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.createTime = :createTime")
    , @NamedQuery(name = "EstadoConfigTransmision.findByUpdateTime", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.updateTime = :updateTime")
    , @NamedQuery(name = "EstadoConfigTransmision.findByIsActive", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.isActive = :isActive")
    , @NamedQuery(name = "EstadoConfigTransmision.findByIdUsuarioUpdate", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "EstadoConfigTransmision.findByIdEstadoConfigTransmision", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.idEstadoConfigTransmision = :idEstadoConfigTransmision")
    , @NamedQuery(name = "EstadoConfigTransmision.findByH1", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.h1 = :h1")
    , @NamedQuery(name = "EstadoConfigTransmision.findByH2", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.h2 = :h2")
    , @NamedQuery(name = "EstadoConfigTransmision.findByH3", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.h3 = :h3")
    , @NamedQuery(name = "EstadoConfigTransmision.findByH4", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.h4 = :h4")
    , @NamedQuery(name = "EstadoConfigTransmision.findByH5", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.h5 = :h5")
    , @NamedQuery(name = "EstadoConfigTransmision.findByOnline", query = "SELECT e FROM EstadoConfigTransmision e WHERE e.online = :online")})
public class EstadoConfigTransmision implements Serializable {

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
    @Column(name = "id_estado_config_transmision")
    private Integer idEstadoConfigTransmision;
    @Column(name = "h1")
    private Short h1;
    @Column(name = "h2")
    private Short h2;
    @Column(name = "h3")
    private Short h3;
    @Column(name = "h4")
    private Short h4;
    @Column(name = "h5")
    private Short h5;
    @Column(name = "online")
    private Short online;

    public EstadoConfigTransmision() {
    }

    public EstadoConfigTransmision(Integer idEstadoConfigTransmision) {
        this.idEstadoConfigTransmision = idEstadoConfigTransmision;
    }

    public EstadoConfigTransmision(Integer idEstadoConfigTransmision, short isActive) {
        this.idEstadoConfigTransmision = idEstadoConfigTransmision;
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

    public Integer getIdEstadoConfigTransmision() {
        return idEstadoConfigTransmision;
    }

    public void setIdEstadoConfigTransmision(Integer idEstadoConfigTransmision) {
        this.idEstadoConfigTransmision = idEstadoConfigTransmision;
    }

    public Short getH1() {
        return h1;
    }

    public void setH1(Short h1) {
        this.h1 = h1;
    }

    public Short getH2() {
        return h2;
    }

    public void setH2(Short h2) {
        this.h2 = h2;
    }

    public Short getH3() {
        return h3;
    }

    public void setH3(Short h3) {
        this.h3 = h3;
    }

    public Short getH4() {
        return h4;
    }

    public void setH4(Short h4) {
        this.h4 = h4;
    }

    public Short getH5() {
        return h5;
    }

    public void setH5(Short h5) {
        this.h5 = h5;
    }

    public Short getOnline() {
        return online;
    }

    public void setOnline(Short online) {
        this.online = online;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoConfigTransmision != null ? idEstadoConfigTransmision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConfigTransmision)) {
            return false;
        }
        EstadoConfigTransmision other = (EstadoConfigTransmision) object;
        if ((this.idEstadoConfigTransmision == null && other.idEstadoConfigTransmision != null) || (this.idEstadoConfigTransmision != null && !this.idEstadoConfigTransmision.equals(other.idEstadoConfigTransmision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EstadoConfigTransmision[ idEstadoConfigTransmision=" + idEstadoConfigTransmision + " ]";
    }
    
}
