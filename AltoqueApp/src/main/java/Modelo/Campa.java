/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "campa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campa.findAll", query = "SELECT c FROM Campa c")
    , @NamedQuery(name = "Campa.findByCreateTime", query = "SELECT c FROM Campa c WHERE c.createTime = :createTime")
    , @NamedQuery(name = "Campa.findByUpdateTime", query = "SELECT c FROM Campa c WHERE c.updateTime = :updateTime")
    , @NamedQuery(name = "Campa.findByIsActive", query = "SELECT c FROM Campa c WHERE c.isActive = :isActive")
    , @NamedQuery(name = "Campa.findByIdUsuarioUpdate", query = "SELECT c FROM Campa c WHERE c.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Campa.findByIdCampa", query = "SELECT c FROM Campa c WHERE c.id = :id")
    , @NamedQuery(name = "Campa.findByNombre", query = "SELECT c FROM Campa c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Campa.findByNombreCorto", query = "SELECT c FROM Campa c WHERE c.nombreCorto = :nombreCorto")
    , @NamedQuery(name = "Campa.findByDescripcion", query = "SELECT c FROM Campa c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Campa.findByEstado", query = "SELECT c FROM Campa c WHERE c.estado = :estado")
    , @NamedQuery(name = "Campa.findByFechaLanzamiento", query = "SELECT c FROM Campa c WHERE c.fechaLanzamiento = :fechaLanzamiento")
    , @NamedQuery(name = "Campa.findByFechaFinalizacion", query = "SELECT c FROM Campa c WHERE c.fechaFinalizacion = :fechaFinalizacion")})
public class Campa implements Serializable {

   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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

    @Size(max = 450)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_lanzamiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLanzamiento;
    @Column(name = "fecha_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    
    //relacion CampaCuenta

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "campa")
    private List<CampaCuenta> campaCuenta = new ArrayList<>();
    
    //relacion CampaEquipo

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "campa")
    private List<CampaEquipo> campaEquipo = new ArrayList<>();

    public Campa() {
    }

    public Campa(Integer idCampa) {
        this.id = idCampa;
    }

    public Campa(Integer idCampa, short isActive, String estado) {
        this.id = idCampa;
        this.isActive = isActive;
        this.estado = estado;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CampaCuenta> getCampaCuenta() {
        return campaCuenta;
    }

    public void setCampaCuenta(List<CampaCuenta> campaCuenta) {
        this.campaCuenta = campaCuenta;
    }

    public List<CampaEquipo> getCampaEquipo() {
        return campaEquipo;
    }

    public void setCampaEquipo(List<CampaEquipo> campaEquipo) {
        this.campaEquipo = campaEquipo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campa)) {
            return false;
        }
        Campa other = (Campa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Campa[ idCampa=" + id + " ]";
    }
    
}
