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
@Table(name = "pto_medicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtoMedicion.findAll", query = "SELECT p FROM PtoMedicion p")
    , @NamedQuery(name = "PtoMedicion.findByCreateTime", query = "SELECT p FROM PtoMedicion p WHERE p.createTime = :createTime")
    , @NamedQuery(name = "PtoMedicion.findByUpdateTime", query = "SELECT p FROM PtoMedicion p WHERE p.updateTime = :updateTime")
    , @NamedQuery(name = "PtoMedicion.findByIsActive", query = "SELECT p FROM PtoMedicion p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PtoMedicion.findByIdUsuarioUpdate", query = "SELECT p FROM PtoMedicion p WHERE p.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "PtoMedicion.findByIdPtoMedicion", query = "SELECT p FROM PtoMedicion p WHERE p.idPtoMedicion = :idPtoMedicion")
    , @NamedQuery(name = "PtoMedicion.findByIdLocacion", query = "SELECT p FROM PtoMedicion p WHERE p.idLocacion = :idLocacion")
    , @NamedQuery(name = "PtoMedicion.findByNombre", query = "SELECT p FROM PtoMedicion p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PtoMedicion.findByNombreCorto", query = "SELECT p FROM PtoMedicion p WHERE p.nombreCorto = :nombreCorto")
    , @NamedQuery(name = "PtoMedicion.findByEstado", query = "SELECT p FROM PtoMedicion p WHERE p.estado = :estado")
    , @NamedQuery(name = "PtoMedicion.findByDescripcion", query = "SELECT p FROM PtoMedicion p WHERE p.descripcion = :descripcion")})
public class PtoMedicion implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pto_medicion")
    private Short idPtoMedicion;
    @Column(name = "id_locacion")
    private Short idLocacion;
    @Size(max = 450)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 450)
    @Column(name = "descripcion")
    private String descripcion;

    public PtoMedicion() {
    }

    public PtoMedicion(Short idPtoMedicion) {
        this.idPtoMedicion = idPtoMedicion;
    }

    public PtoMedicion(Short idPtoMedicion, short isActive) {
        this.idPtoMedicion = idPtoMedicion;
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

    public Short getIdPtoMedicion() {
        return idPtoMedicion;
    }

    public void setIdPtoMedicion(Short idPtoMedicion) {
        this.idPtoMedicion = idPtoMedicion;
    }

    public Short getIdLocacion() {
        return idLocacion;
    }

    public void setIdLocacion(Short idLocacion) {
        this.idLocacion = idLocacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPtoMedicion != null ? idPtoMedicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtoMedicion)) {
            return false;
        }
        PtoMedicion other = (PtoMedicion) object;
        if ((this.idPtoMedicion == null && other.idPtoMedicion != null) || (this.idPtoMedicion != null && !this.idPtoMedicion.equals(other.idPtoMedicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.PtoMedicion[ idPtoMedicion=" + idPtoMedicion + " ]";
    }
    
}
