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
@Table(name = "multimedia_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MultimediaEquipo.findAll", query = "SELECT m FROM MultimediaEquipo m")
    , @NamedQuery(name = "MultimediaEquipo.findByCreateTime", query = "SELECT m FROM MultimediaEquipo m WHERE m.createTime = :createTime")
    , @NamedQuery(name = "MultimediaEquipo.findByUpdateTime", query = "SELECT m FROM MultimediaEquipo m WHERE m.updateTime = :updateTime")
    , @NamedQuery(name = "MultimediaEquipo.findByIsActive", query = "SELECT m FROM MultimediaEquipo m WHERE m.isActive = :isActive")
    , @NamedQuery(name = "MultimediaEquipo.findByIdUsuarioUpdate", query = "SELECT m FROM MultimediaEquipo m WHERE m.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "MultimediaEquipo.findByIdMultimediaEquipo", query = "SELECT m FROM MultimediaEquipo m WHERE m.idMultimediaEquipo = :idMultimediaEquipo")
    , @NamedQuery(name = "MultimediaEquipo.findByIdEquipo", query = "SELECT m FROM MultimediaEquipo m WHERE m.idEquipo = :idEquipo")})
public class MultimediaEquipo implements Serializable {

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
    @Column(name = "id_multimedia_equipo")
    private Integer idMultimediaEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private short idEquipo;

    public MultimediaEquipo() {
    }

    public MultimediaEquipo(Integer idMultimediaEquipo) {
        this.idMultimediaEquipo = idMultimediaEquipo;
    }

    public MultimediaEquipo(Integer idMultimediaEquipo, short isActive, short idEquipo) {
        this.idMultimediaEquipo = idMultimediaEquipo;
        this.isActive = isActive;
        this.idEquipo = idEquipo;
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

    public Integer getIdMultimediaEquipo() {
        return idMultimediaEquipo;
    }

    public void setIdMultimediaEquipo(Integer idMultimediaEquipo) {
        this.idMultimediaEquipo = idMultimediaEquipo;
    }

    public short getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(short idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMultimediaEquipo != null ? idMultimediaEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MultimediaEquipo)) {
            return false;
        }
        MultimediaEquipo other = (MultimediaEquipo) object;
        if ((this.idMultimediaEquipo == null && other.idMultimediaEquipo != null) || (this.idMultimediaEquipo != null && !this.idMultimediaEquipo.equals(other.idMultimediaEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.MultimediaEquipo[ idMultimediaEquipo=" + idMultimediaEquipo + " ]";
    }
    
}
