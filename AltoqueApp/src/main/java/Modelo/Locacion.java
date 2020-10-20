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
@Table(name = "locacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacion.findAll", query = "SELECT l FROM Locacion l")
    , @NamedQuery(name = "Locacion.findByCreateTime", query = "SELECT l FROM Locacion l WHERE l.createTime = :createTime")
    , @NamedQuery(name = "Locacion.findByUpdateTime", query = "SELECT l FROM Locacion l WHERE l.updateTime = :updateTime")
    , @NamedQuery(name = "Locacion.findByIsActive", query = "SELECT l FROM Locacion l WHERE l.isActive = :isActive")
    , @NamedQuery(name = "Locacion.findByIdUsuarioUpdate", query = "SELECT l FROM Locacion l WHERE l.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Locacion.findByIdLocacion", query = "SELECT l FROM Locacion l WHERE l.idLocacion = :idLocacion")
    , @NamedQuery(name = "Locacion.findByNombre", query = "SELECT l FROM Locacion l WHERE l.nombre = :nombre")
    , @NamedQuery(name = "Locacion.findByNombreCorto", query = "SELECT l FROM Locacion l WHERE l.nombreCorto = :nombreCorto")
    , @NamedQuery(name = "Locacion.findByTipoLocacion", query = "SELECT l FROM Locacion l WHERE l.tipoLocacion = :tipoLocacion")
    , @NamedQuery(name = "Locacion.findByLat", query = "SELECT l FROM Locacion l WHERE l.lat = :lat")
    , @NamedQuery(name = "Locacion.findByLong1", query = "SELECT l FROM Locacion l WHERE l.long1 = :long1")
    , @NamedQuery(name = "Locacion.findByPais", query = "SELECT l FROM Locacion l WHERE l.pais = :pais")
    , @NamedQuery(name = "Locacion.findByProvincia", query = "SELECT l FROM Locacion l WHERE l.provincia = :provincia")
    , @NamedQuery(name = "Locacion.findByDomicilio", query = "SELECT l FROM Locacion l WHERE l.domicilio = :domicilio")
    , @NamedQuery(name = "Locacion.findByDescripcion", query = "SELECT l FROM Locacion l WHERE l.descripcion = :descripcion")
    , @NamedQuery(name = "Locacion.findByIdCuenta", query = "SELECT l FROM Locacion l WHERE l.idCuenta = :idCuenta")})
public class Locacion implements Serializable {

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
    @Column(name = "id_locacion")
    private Short idLocacion;
    @Size(max = 350)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Column(name = "tipo_locacion")
    private Short tipoLocacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "lat")
    private Double lat;
    @Column(name = "long")
    private Double long1;
    @Size(max = 45)
    @Column(name = "pais")
    private String pais;
    @Size(max = 45)
    @Column(name = "provincia")
    private String provincia;
    @Size(max = 450)
    @Column(name = "domicilio")
    private String domicilio;
    @Size(max = 450)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuenta")
    private short idCuenta;

    public Locacion() {
    }

    public Locacion(Short idLocacion) {
        this.idLocacion = idLocacion;
    }

    public Locacion(Short idLocacion, short isActive, short idCuenta) {
        this.idLocacion = idLocacion;
        this.isActive = isActive;
        this.idCuenta = idCuenta;
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

    public Short getTipoLocacion() {
        return tipoLocacion;
    }

    public void setTipoLocacion(Short tipoLocacion) {
        this.tipoLocacion = tipoLocacion;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLong1() {
        return long1;
    }

    public void setLong1(Double long1) {
        this.long1 = long1;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(short idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocacion != null ? idLocacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locacion)) {
            return false;
        }
        Locacion other = (Locacion) object;
        if ((this.idLocacion == null && other.idLocacion != null) || (this.idLocacion != null && !this.idLocacion.equals(other.idLocacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Locacion[ idLocacion=" + idLocacion + " ]";
    }
    
}
