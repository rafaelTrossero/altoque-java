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
@Table(name = "multimedia_pto_medicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MultimediaPtoMedicion.findAll", query = "SELECT m FROM MultimediaPtoMedicion m")
    , @NamedQuery(name = "MultimediaPtoMedicion.findByCreateTime", query = "SELECT m FROM MultimediaPtoMedicion m WHERE m.createTime = :createTime")
    , @NamedQuery(name = "MultimediaPtoMedicion.findByUpdateTime", query = "SELECT m FROM MultimediaPtoMedicion m WHERE m.updateTime = :updateTime")
    , @NamedQuery(name = "MultimediaPtoMedicion.findByIsActive", query = "SELECT m FROM MultimediaPtoMedicion m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MultimediaPtoMedicion.findByIdUsuarioUpdate", query = "SELECT m FROM MultimediaPtoMedicion m WHERE m.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "MultimediaPtoMedicion.findByIdMultimediaPtoMedicion", query = "SELECT m FROM MultimediaPtoMedicion m WHERE m.idMultimediaPtoMedicion = :idMultimediaPtoMedicion")
    , @NamedQuery(name = "MultimediaPtoMedicion.findByIdPtoMedicion", query = "SELECT m FROM MultimediaPtoMedicion m WHERE m.idPtoMedicion = :idPtoMedicion")})
public class MultimediaPtoMedicion implements Serializable {

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
    @Column(name = "id_multimedia_pto_medicion")
    private Integer idMultimediaPtoMedicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pto_medicion")
    private short idPtoMedicion;

    public MultimediaPtoMedicion() {
    }

    public MultimediaPtoMedicion(Integer idMultimediaPtoMedicion) {
        this.idMultimediaPtoMedicion = idMultimediaPtoMedicion;
    }

    public MultimediaPtoMedicion(Integer idMultimediaPtoMedicion, short isActive, short idPtoMedicion) {
        this.idMultimediaPtoMedicion = idMultimediaPtoMedicion;
        this.isActive = isActive;
        this.idPtoMedicion = idPtoMedicion;
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

    public Integer getIdMultimediaPtoMedicion() {
        return idMultimediaPtoMedicion;
    }

    public void setIdMultimediaPtoMedicion(Integer idMultimediaPtoMedicion) {
        this.idMultimediaPtoMedicion = idMultimediaPtoMedicion;
    }

    public short getIdPtoMedicion() {
        return idPtoMedicion;
    }

    public void setIdPtoMedicion(short idPtoMedicion) {
        this.idPtoMedicion = idPtoMedicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMultimediaPtoMedicion != null ? idMultimediaPtoMedicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MultimediaPtoMedicion)) {
            return false;
        }
        MultimediaPtoMedicion other = (MultimediaPtoMedicion) object;
        if ((this.idMultimediaPtoMedicion == null && other.idMultimediaPtoMedicion != null) || (this.idMultimediaPtoMedicion != null && !this.idMultimediaPtoMedicion.equals(other.idMultimediaPtoMedicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.MultimediaPtoMedicion[ idMultimediaPtoMedicion=" + idMultimediaPtoMedicion + " ]";
    }
    
}
