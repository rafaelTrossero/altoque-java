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
@Table(name = "estado_config_arlarma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoConfigArlarma.findAll", query = "SELECT e FROM EstadoConfigArlarma e")
    , @NamedQuery(name = "EstadoConfigArlarma.findByCreateTime", query = "SELECT e FROM EstadoConfigArlarma e WHERE e.createTime = :createTime")
    , @NamedQuery(name = "EstadoConfigArlarma.findByUpdateTime", query = "SELECT e FROM EstadoConfigArlarma e WHERE e.updateTime = :updateTime")
    , @NamedQuery(name = "EstadoConfigArlarma.findByIsActive", query = "SELECT e FROM EstadoConfigArlarma e WHERE e.isActive = :isActive")
    , @NamedQuery(name = "EstadoConfigArlarma.findByIdUsuarioUpdate", query = "SELECT e FROM EstadoConfigArlarma e WHERE e.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "EstadoConfigArlarma.findByIdEstadoConfigAlarma", query = "SELECT e FROM EstadoConfigArlarma e WHERE e.idEstadoConfigAlarma = :idEstadoConfigAlarma")
    , @NamedQuery(name = "EstadoConfigArlarma.findByBoton1", query = "SELECT e FROM EstadoConfigArlarma e WHERE e.boton1 = :boton1")
    , @NamedQuery(name = "EstadoConfigArlarma.findByBoton2", query = "SELECT e FROM EstadoConfigArlarma e WHERE e.boton2 = :boton2")
    , @NamedQuery(name = "EstadoConfigArlarma.findByBoton3", query = "SELECT e FROM EstadoConfigArlarma e WHERE e.boton3 = :boton3")
    , @NamedQuery(name = "EstadoConfigArlarma.findByBoton4", query = "SELECT e FROM EstadoConfigArlarma e WHERE e.boton4 = :boton4")})
public class EstadoConfigArlarma implements Serializable {

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
    @Column(name = "id_estado_config_alarma")
    private Integer idEstadoConfigAlarma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boton1")
    private short boton1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boton2")
    private short boton2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boton3")
    private short boton3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boton4")
    private short boton4;

    public EstadoConfigArlarma() {
    }

    public EstadoConfigArlarma(Integer idEstadoConfigAlarma) {
        this.idEstadoConfigAlarma = idEstadoConfigAlarma;
    }

    public EstadoConfigArlarma(Integer idEstadoConfigAlarma, short isActive, short boton1, short boton2, short boton3, short boton4) {
        this.idEstadoConfigAlarma = idEstadoConfigAlarma;
        this.isActive = isActive;
        this.boton1 = boton1;
        this.boton2 = boton2;
        this.boton3 = boton3;
        this.boton4 = boton4;
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

    public Integer getIdEstadoConfigAlarma() {
        return idEstadoConfigAlarma;
    }

    public void setIdEstadoConfigAlarma(Integer idEstadoConfigAlarma) {
        this.idEstadoConfigAlarma = idEstadoConfigAlarma;
    }

    public short getBoton1() {
        return boton1;
    }

    public void setBoton1(short boton1) {
        this.boton1 = boton1;
    }

    public short getBoton2() {
        return boton2;
    }

    public void setBoton2(short boton2) {
        this.boton2 = boton2;
    }

    public short getBoton3() {
        return boton3;
    }

    public void setBoton3(short boton3) {
        this.boton3 = boton3;
    }

    public short getBoton4() {
        return boton4;
    }

    public void setBoton4(short boton4) {
        this.boton4 = boton4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoConfigAlarma != null ? idEstadoConfigAlarma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConfigArlarma)) {
            return false;
        }
        EstadoConfigArlarma other = (EstadoConfigArlarma) object;
        if ((this.idEstadoConfigAlarma == null && other.idEstadoConfigAlarma != null) || (this.idEstadoConfigAlarma != null && !this.idEstadoConfigAlarma.equals(other.idEstadoConfigAlarma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.EstadoConfigArlarma[ idEstadoConfigAlarma=" + idEstadoConfigAlarma + " ]";
    }
    
}
