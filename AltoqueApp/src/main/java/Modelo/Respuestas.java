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
@Table(name = "respuestas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuestas.findAll", query = "SELECT r FROM Respuestas r")
    , @NamedQuery(name = "Respuestas.findByCreateTime", query = "SELECT r FROM Respuestas r WHERE r.createTime = :createTime")
    , @NamedQuery(name = "Respuestas.findByUpdateTime", query = "SELECT r FROM Respuestas r WHERE r.updateTime = :updateTime")
    , @NamedQuery(name = "Respuestas.findByIsActive", query = "SELECT r FROM Respuestas r WHERE r.isActive = :isActive")
    , @NamedQuery(name = "Respuestas.findByIdUsuarioUpdate", query = "SELECT r FROM Respuestas r WHERE r.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Respuestas.findByIdRespuesta", query = "SELECT r FROM Respuestas r WHERE r.idRespuesta = :idRespuesta")
    , @NamedQuery(name = "Respuestas.findByIdEquipo", query = "SELECT r FROM Respuestas r WHERE r.idEquipo = :idEquipo")
    , @NamedQuery(name = "Respuestas.findByTsRespuesta", query = "SELECT r FROM Respuestas r WHERE r.tsRespuesta = :tsRespuesta")
    , @NamedQuery(name = "Respuestas.findByIdOpcionPregunta", query = "SELECT r FROM Respuestas r WHERE r.idOpcionPregunta = :idOpcionPregunta")
    , @NamedQuery(name = "Respuestas.findByIdPtoMedicion", query = "SELECT r FROM Respuestas r WHERE r.idPtoMedicion = :idPtoMedicion")})
public class Respuestas implements Serializable {

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
    @Column(name = "id_respuesta")
    private Integer idRespuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private short idEquipo;
    @Column(name = "ts_respuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsRespuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_opcion_pregunta")
    private int idOpcionPregunta;
    @Column(name = "id_pto_medicion")
    private Short idPtoMedicion;

    public Respuestas() {
    }

    public Respuestas(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Respuestas(Integer idRespuesta, short isActive, short idEquipo, int idOpcionPregunta) {
        this.idRespuesta = idRespuesta;
        this.isActive = isActive;
        this.idEquipo = idEquipo;
        this.idOpcionPregunta = idOpcionPregunta;
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

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public short getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(short idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Date getTsRespuesta() {
        return tsRespuesta;
    }

    public void setTsRespuesta(Date tsRespuesta) {
        this.tsRespuesta = tsRespuesta;
    }

    public int getIdOpcionPregunta() {
        return idOpcionPregunta;
    }

    public void setIdOpcionPregunta(int idOpcionPregunta) {
        this.idOpcionPregunta = idOpcionPregunta;
    }

    public Short getIdPtoMedicion() {
        return idPtoMedicion;
    }

    public void setIdPtoMedicion(Short idPtoMedicion) {
        this.idPtoMedicion = idPtoMedicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuestas)) {
            return false;
        }
        Respuestas other = (Respuestas) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Respuestas[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
