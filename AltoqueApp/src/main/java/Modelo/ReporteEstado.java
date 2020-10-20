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
@Table(name = "reporte_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReporteEstado.findAll", query = "SELECT r FROM ReporteEstado r")
    , @NamedQuery(name = "ReporteEstado.findByCreateTime", query = "SELECT r FROM ReporteEstado r WHERE r.createTime = :createTime")
    , @NamedQuery(name = "ReporteEstado.findByUpdateTime", query = "SELECT r FROM ReporteEstado r WHERE r.updateTime = :updateTime")
    , @NamedQuery(name = "ReporteEstado.findByIsActive", query = "SELECT r FROM ReporteEstado r WHERE r.isActive = :isActive")
    , @NamedQuery(name = "ReporteEstado.findByIdUsuarioUpdate", query = "SELECT r FROM ReporteEstado r WHERE r.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "ReporteEstado.findByIdReporteEstado", query = "SELECT r FROM ReporteEstado r WHERE r.idReporteEstado = :idReporteEstado")
    , @NamedQuery(name = "ReporteEstado.findByFechaRegistro", query = "SELECT r FROM ReporteEstado r WHERE r.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "ReporteEstado.findByServidor1", query = "SELECT r FROM ReporteEstado r WHERE r.servidor1 = :servidor1")
    , @NamedQuery(name = "ReporteEstado.findByServidor2", query = "SELECT r FROM ReporteEstado r WHERE r.servidor2 = :servidor2")
    , @NamedQuery(name = "ReporteEstado.findByServidor3", query = "SELECT r FROM ReporteEstado r WHERE r.servidor3 = :servidor3")
    , @NamedQuery(name = "ReporteEstado.findByIdEstadoConf", query = "SELECT r FROM ReporteEstado r WHERE r.idEstadoConf = :idEstadoConf")
    , @NamedQuery(name = "ReporteEstado.findByIdUltimoAcceso", query = "SELECT r FROM ReporteEstado r WHERE r.idUltimoAcceso = :idUltimoAcceso")
    , @NamedQuery(name = "ReporteEstado.findByIdEquipo", query = "SELECT r FROM ReporteEstado r WHERE r.idEquipo = :idEquipo")})
public class ReporteEstado implements Serializable {

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
    @Column(name = "id_reporte_estado")
    private Integer idReporteEstado;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 450)
    @Column(name = "servidor1")
    private String servidor1;
    @Size(max = 450)
    @Column(name = "servidor2")
    private String servidor2;
    @Size(max = 450)
    @Column(name = "servidor3")
    private String servidor3;
    @Column(name = "id_estado_conf")
    private Integer idEstadoConf;
    @Column(name = "id_ultimo_acceso")
    private Integer idUltimoAcceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private short idEquipo;

    public ReporteEstado() {
    }

    public ReporteEstado(Integer idReporteEstado) {
        this.idReporteEstado = idReporteEstado;
    }

    public ReporteEstado(Integer idReporteEstado, short isActive, short idEquipo) {
        this.idReporteEstado = idReporteEstado;
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

    public Integer getIdReporteEstado() {
        return idReporteEstado;
    }

    public void setIdReporteEstado(Integer idReporteEstado) {
        this.idReporteEstado = idReporteEstado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getServidor1() {
        return servidor1;
    }

    public void setServidor1(String servidor1) {
        this.servidor1 = servidor1;
    }

    public String getServidor2() {
        return servidor2;
    }

    public void setServidor2(String servidor2) {
        this.servidor2 = servidor2;
    }

    public String getServidor3() {
        return servidor3;
    }

    public void setServidor3(String servidor3) {
        this.servidor3 = servidor3;
    }

    public Integer getIdEstadoConf() {
        return idEstadoConf;
    }

    public void setIdEstadoConf(Integer idEstadoConf) {
        this.idEstadoConf = idEstadoConf;
    }

    public Integer getIdUltimoAcceso() {
        return idUltimoAcceso;
    }

    public void setIdUltimoAcceso(Integer idUltimoAcceso) {
        this.idUltimoAcceso = idUltimoAcceso;
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
        hash += (idReporteEstado != null ? idReporteEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteEstado)) {
            return false;
        }
        ReporteEstado other = (ReporteEstado) object;
        if ((this.idReporteEstado == null && other.idReporteEstado != null) || (this.idReporteEstado != null && !this.idReporteEstado.equals(other.idReporteEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.ReporteEstado[ idReporteEstado=" + idReporteEstado + " ]";
    }
    
}
