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
@Table(name = "estado_config_sonido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoConfigSonido.findAll", query = "SELECT e FROM EstadoConfigSonido e")
    , @NamedQuery(name = "EstadoConfigSonido.findByCreateTime", query = "SELECT e FROM EstadoConfigSonido e WHERE e.createTime = :createTime")
    , @NamedQuery(name = "EstadoConfigSonido.findByUpdateTime", query = "SELECT e FROM EstadoConfigSonido e WHERE e.updateTime = :updateTime")
    , @NamedQuery(name = "EstadoConfigSonido.findByIsActive", query = "SELECT e FROM EstadoConfigSonido e WHERE e.isActive = :isActive")
    , @NamedQuery(name = "EstadoConfigSonido.findByIdUsuarioUpdate", query = "SELECT e FROM EstadoConfigSonido e WHERE e.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "EstadoConfigSonido.findByIdEstadoConfigSonido", query = "SELECT e FROM EstadoConfigSonido e WHERE e.idEstadoConfigSonido = :idEstadoConfigSonido")
    , @NamedQuery(name = "EstadoConfigSonido.findByBoton", query = "SELECT e FROM EstadoConfigSonido e WHERE e.boton = :boton")
    , @NamedQuery(name = "EstadoConfigSonido.findByEnvio", query = "SELECT e FROM EstadoConfigSonido e WHERE e.envio = :envio")})
public class EstadoConfigSonido implements Serializable {

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
    @Column(name = "id_estado_config_sonido")
    private Integer idEstadoConfigSonido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boton")
    private short boton;
    @Basic(optional = false)
    @NotNull
    @Column(name = "envio")
    private short envio;

    public EstadoConfigSonido() {
    }

    public EstadoConfigSonido(Integer idEstadoConfigSonido) {
        this.idEstadoConfigSonido = idEstadoConfigSonido;
    }

    public EstadoConfigSonido(Integer idEstadoConfigSonido, short isActive, short boton, short envio) {
        this.idEstadoConfigSonido = idEstadoConfigSonido;
        this.isActive = isActive;
        this.boton = boton;
        this.envio = envio;
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

    public Integer getIdEstadoConfigSonido() {
        return idEstadoConfigSonido;
    }

    public void setIdEstadoConfigSonido(Integer idEstadoConfigSonido) {
        this.idEstadoConfigSonido = idEstadoConfigSonido;
    }

    public short getBoton() {
        return boton;
    }

    public void setBoton(short boton) {
        this.boton = boton;
    }

    public short getEnvio() {
        return envio;
    }

    public void setEnvio(short envio) {
        this.envio = envio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoConfigSonido != null ? idEstadoConfigSonido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConfigSonido)) {
            return false;
        }
        EstadoConfigSonido other = (EstadoConfigSonido) object;
        if ((this.idEstadoConfigSonido == null && other.idEstadoConfigSonido != null) || (this.idEstadoConfigSonido != null && !this.idEstadoConfigSonido.equals(other.idEstadoConfigSonido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EstadoConfigSonido[ idEstadoConfigSonido=" + idEstadoConfigSonido + " ]";
    }
    
}
