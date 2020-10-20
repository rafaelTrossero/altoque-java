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
@Table(name = "opciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o")
    , @NamedQuery(name = "Opciones.findByCreateTime", query = "SELECT o FROM Opciones o WHERE o.createTime = :createTime")
    , @NamedQuery(name = "Opciones.findByUpdateTime", query = "SELECT o FROM Opciones o WHERE o.updateTime = :updateTime")
    , @NamedQuery(name = "Opciones.findByIsActive", query = "SELECT o FROM Opciones o WHERE o.isActive = :isActive")
    , @NamedQuery(name = "Opciones.findByIdUsuarioUpdate", query = "SELECT o FROM Opciones o WHERE o.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Opciones.findByIdOpcion", query = "SELECT o FROM Opciones o WHERE o.id = :id")
    , @NamedQuery(name = "Opciones.findByDescripcion", query = "SELECT o FROM Opciones o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Opciones.findByNombre", query = "SELECT o FROM Opciones o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Opciones.findByNombreCorto", query = "SELECT o FROM Opciones o WHERE o.nombreCorto = :nombreCorto")
    , @NamedQuery(name = "Opciones.findByTipoOpcion", query = "SELECT o FROM Opciones o WHERE o.tipoOpcion = :tipoOpcion")
    , @NamedQuery(name = "Opciones.findByDefaultIcon", query = "SELECT o FROM Opciones o WHERE o.defaultIcon = :defaultIcon")})
public class Opciones implements Serializable {

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
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Size(max = 150)
    @Column(name = "tipo_opcion")
    private String tipoOpcion;
    @Size(max = 450)
    @Column(name = "default_icon")
    private String defaultIcon;

    //relacion OpcionPregunta
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "opciones")
    private List<OpcionPregunta> opcionPregunta = new ArrayList<>();

    public Opciones() {
    }

    public Opciones(Integer idOpcion) {
        this.id = idOpcion;
    }

    public Opciones(Integer idOpcion, short isActive) {
        this.id = idOpcion;
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

    public Integer getIdOpcion() {
        return id;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.id = idOpcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getTipoOpcion() {
        return tipoOpcion;
    }

    public void setTipoOpcion(String tipoOpcion) {
        this.tipoOpcion = tipoOpcion;
    }

    public String getDefaultIcon() {
        return defaultIcon;
    }

    public void setDefaultIcon(String defaultIcon) {
        this.defaultIcon = defaultIcon;
    }

    public List<OpcionPregunta> getOpcionPregunta() {
        return opcionPregunta;
    }

    public void setOpcionPregunta(List<OpcionPregunta> opcionPregunta) {
        this.opcionPregunta = opcionPregunta;
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
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Opciones[ idOpcion=" + id + " ]";
    }

}
