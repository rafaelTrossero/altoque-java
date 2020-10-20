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
@Table(name = "estado_config")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoConfig.findAll", query = "SELECT e FROM EstadoConfig e")
    , @NamedQuery(name = "EstadoConfig.findByCreateTime", query = "SELECT e FROM EstadoConfig e WHERE e.createTime = :createTime")
    , @NamedQuery(name = "EstadoConfig.findByUpdateTime", query = "SELECT e FROM EstadoConfig e WHERE e.updateTime = :updateTime")
    , @NamedQuery(name = "EstadoConfig.findByIsActive", query = "SELECT e FROM EstadoConfig e WHERE e.isActive = :isActive")
    , @NamedQuery(name = "EstadoConfig.findByIdUsuarioUpdate", query = "SELECT e FROM EstadoConfig e WHERE e.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "EstadoConfig.findByIdEstadoConfig", query = "SELECT e FROM EstadoConfig e WHERE e.idEstadoConfig = :idEstadoConfig")
    , @NamedQuery(name = "EstadoConfig.findByIdConfigAlarma", query = "SELECT e FROM EstadoConfig e WHERE e.idConfigAlarma = :idConfigAlarma")
    , @NamedQuery(name = "EstadoConfig.findByIdConfigSonido", query = "SELECT e FROM EstadoConfig e WHERE e.idConfigSonido = :idConfigSonido")
    , @NamedQuery(name = "EstadoConfig.findByIdConfigTransmision", query = "SELECT e FROM EstadoConfig e WHERE e.idConfigTransmision = :idConfigTransmision")
    , @NamedQuery(name = "EstadoConfig.findByIdConfigWifi", query = "SELECT e FROM EstadoConfig e WHERE e.idConfigWifi = :idConfigWifi")})
public class EstadoConfig implements Serializable {

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
    @Column(name = "id_estado_config")
    private Integer idEstadoConfig;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_config_alarma")
    private int idConfigAlarma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_config_sonido")
    private int idConfigSonido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_config_transmision")
    private int idConfigTransmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_config_wifi")
    private int idConfigWifi;

    public EstadoConfig() {
    }

    public EstadoConfig(Integer idEstadoConfig) {
        this.idEstadoConfig = idEstadoConfig;
    }

    public EstadoConfig(Integer idEstadoConfig, short isActive, int idConfigAlarma, int idConfigSonido, int idConfigTransmision, int idConfigWifi) {
        this.idEstadoConfig = idEstadoConfig;
        this.isActive = isActive;
        this.idConfigAlarma = idConfigAlarma;
        this.idConfigSonido = idConfigSonido;
        this.idConfigTransmision = idConfigTransmision;
        this.idConfigWifi = idConfigWifi;
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

    public Integer getIdEstadoConfig() {
        return idEstadoConfig;
    }

    public void setIdEstadoConfig(Integer idEstadoConfig) {
        this.idEstadoConfig = idEstadoConfig;
    }

    public int getIdConfigAlarma() {
        return idConfigAlarma;
    }

    public void setIdConfigAlarma(int idConfigAlarma) {
        this.idConfigAlarma = idConfigAlarma;
    }

    public int getIdConfigSonido() {
        return idConfigSonido;
    }

    public void setIdConfigSonido(int idConfigSonido) {
        this.idConfigSonido = idConfigSonido;
    }

    public int getIdConfigTransmision() {
        return idConfigTransmision;
    }

    public void setIdConfigTransmision(int idConfigTransmision) {
        this.idConfigTransmision = idConfigTransmision;
    }

    public int getIdConfigWifi() {
        return idConfigWifi;
    }

    public void setIdConfigWifi(int idConfigWifi) {
        this.idConfigWifi = idConfigWifi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoConfig != null ? idEstadoConfig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConfig)) {
            return false;
        }
        EstadoConfig other = (EstadoConfig) object;
        if ((this.idEstadoConfig == null && other.idEstadoConfig != null) || (this.idEstadoConfig != null && !this.idEstadoConfig.equals(other.idEstadoConfig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EstadoConfig[ idEstadoConfig=" + idEstadoConfig + " ]";
    }
    
}
