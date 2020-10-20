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
@Table(name = "pto_medicion_equipo_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtoMedicionEquipoPregunta.findAll", query = "SELECT p FROM PtoMedicionEquipoPregunta p")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByCreateTime", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.createTime = :createTime")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByUpdateTime", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.updateTime = :updateTime")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByIsActive", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByIdUsuarioUpdate", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByIdPtoMedicionEquipoPregunta", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.idPtoMedicionEquipoPregunta = :idPtoMedicionEquipoPregunta")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByIdEquipo", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.idEquipo = :idEquipo")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByIdPtoMedicion", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.idPtoMedicion = :idPtoMedicion")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByIdPregunta", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.idPregunta = :idPregunta")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByFechaDesde", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.fechaDesde = :fechaDesde")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByFechaHasta", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.fechaHasta = :fechaHasta")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByEstado", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.estado = :estado")
    , @NamedQuery(name = "PtoMedicionEquipoPregunta.findByTipoExhibidor", query = "SELECT p FROM PtoMedicionEquipoPregunta p WHERE p.tipoExhibidor = :tipoExhibidor")})
public class PtoMedicionEquipoPregunta implements Serializable {

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
    @Column(name = "id_pto_medicion_equipo_pregunta")
    private Integer idPtoMedicionEquipoPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private short idEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pto_medicion")
    private short idPtoMedicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pregunta")
    private short idPregunta;
    @Column(name = "fecha_desde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDesde;
    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHasta;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "tipo_exhibidor")
    private String tipoExhibidor;

    public PtoMedicionEquipoPregunta() {
    }

    public PtoMedicionEquipoPregunta(Integer idPtoMedicionEquipoPregunta) {
        this.idPtoMedicionEquipoPregunta = idPtoMedicionEquipoPregunta;
    }

    public PtoMedicionEquipoPregunta(Integer idPtoMedicionEquipoPregunta, short isActive, short idEquipo, short idPtoMedicion, short idPregunta) {
        this.idPtoMedicionEquipoPregunta = idPtoMedicionEquipoPregunta;
        this.isActive = isActive;
        this.idEquipo = idEquipo;
        this.idPtoMedicion = idPtoMedicion;
        this.idPregunta = idPregunta;
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

    public Integer getIdPtoMedicionEquipoPregunta() {
        return idPtoMedicionEquipoPregunta;
    }

    public void setIdPtoMedicionEquipoPregunta(Integer idPtoMedicionEquipoPregunta) {
        this.idPtoMedicionEquipoPregunta = idPtoMedicionEquipoPregunta;
    }

    public short getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(short idEquipo) {
        this.idEquipo = idEquipo;
    }

    public short getIdPtoMedicion() {
        return idPtoMedicion;
    }

    public void setIdPtoMedicion(short idPtoMedicion) {
        this.idPtoMedicion = idPtoMedicion;
    }

    public short getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(short idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoExhibidor() {
        return tipoExhibidor;
    }

    public void setTipoExhibidor(String tipoExhibidor) {
        this.tipoExhibidor = tipoExhibidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPtoMedicionEquipoPregunta != null ? idPtoMedicionEquipoPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtoMedicionEquipoPregunta)) {
            return false;
        }
        PtoMedicionEquipoPregunta other = (PtoMedicionEquipoPregunta) object;
        if ((this.idPtoMedicionEquipoPregunta == null && other.idPtoMedicionEquipoPregunta != null) || (this.idPtoMedicionEquipoPregunta != null && !this.idPtoMedicionEquipoPregunta.equals(other.idPtoMedicionEquipoPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.PtoMedicionEquipoPregunta[ idPtoMedicionEquipoPregunta=" + idPtoMedicionEquipoPregunta + " ]";
    }
    
}
