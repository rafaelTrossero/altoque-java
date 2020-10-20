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
@Table(name = "pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p")
    , @NamedQuery(name = "Pregunta.findByCreateTime", query = "SELECT p FROM Pregunta p WHERE p.createTime = :createTime")
    , @NamedQuery(name = "Pregunta.findByUpdateTime", query = "SELECT p FROM Pregunta p WHERE p.updateTime = :updateTime")
    , @NamedQuery(name = "Pregunta.findByIsActive", query = "SELECT p FROM Pregunta p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "Pregunta.findByIdUsuarioUpdate", query = "SELECT p FROM Pregunta p WHERE p.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Pregunta.findByIdPregunta", query = "SELECT p FROM Pregunta p WHERE p.id = :id")
    , @NamedQuery(name = "Pregunta.findByTipoPregunta", query = "SELECT p FROM Pregunta p WHERE p.tipoPregunta = :tipoPregunta")
    , @NamedQuery(name = "Pregunta.findByCategoria", query = "SELECT p FROM Pregunta p WHERE p.categoria = :categoria")
    , @NamedQuery(name = "Pregunta.findByPregunta", query = "SELECT p FROM Pregunta p WHERE p.pregunta = :pregunta")
    , @NamedQuery(name = "Pregunta.findByDescripcion", query = "SELECT p FROM Pregunta p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Pregunta.findByCantidadOpciones", query = "SELECT p FROM Pregunta p WHERE p.cantidadOpciones = :cantidadOpciones")
    , @NamedQuery(name = "Pregunta.findByDefaultGrafico", query = "SELECT p FROM Pregunta p WHERE p.defaultGrafico = :defaultGrafico")
    , @NamedQuery(name = "Pregunta.findByDefaultDashboard", query = "SELECT p FROM Pregunta p WHERE p.defaultDashboard = :defaultDashboard")})
public class Pregunta implements Serializable {

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

    @Size(max = 150)
    @Column(name = "tipo_pregunta")
    private String tipoPregunta;
    @Size(max = 150)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "pregunta")
    private String pregunta;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_opciones")
    private short cantidadOpciones;
    @Size(max = 150)
    @Column(name = "default_grafico")
    private String defaultGrafico;
    @Size(max = 150)
    @Column(name = "default_dashboard")
    private String defaultDashboard;
    
     //relacion OpcionPregunta

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pregunta")
    private List<OpcionPregunta> opcionPregunta = new ArrayList<>();
    
     //relacion PreguntaEquipo

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pregunta")
    private List<PreguntaEquipo> preguntaEquipo = new ArrayList<>();

    public Pregunta() {
    }

    public Pregunta(Short idPregunta) {
        this.id = id;
    }

    public Pregunta(Short idPregunta, short isActive, String pregunta, short cantidadOpciones) {
        this.id = id;
        this.isActive = isActive;
        this.pregunta = pregunta;
        this.cantidadOpciones = cantidadOpciones;
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

    public Integer getIdPregunta() {
        return id;
    }

    public void setIdPregunta(Integer id) {
        this.id = id;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getCantidadOpciones() {
        return cantidadOpciones;
    }

    public void setCantidadOpciones(short cantidadOpciones) {
        this.cantidadOpciones = cantidadOpciones;
    }

    public String getDefaultGrafico() {
        return defaultGrafico;
    }

    public void setDefaultGrafico(String defaultGrafico) {
        this.defaultGrafico = defaultGrafico;
    }

    public String getDefaultDashboard() {
        return defaultDashboard;
    }

    public void setDefaultDashboard(String defaultDashboard) {
        this.defaultDashboard = defaultDashboard;
    }

    public List<OpcionPregunta> getOpcionPregunta() {
        return opcionPregunta;
    }

    public void setOpcionPregunta(List<OpcionPregunta> opcionPregunta) {
        this.opcionPregunta = opcionPregunta;
    }

    public List<PreguntaEquipo> getPreguntaEquipo() {
        return preguntaEquipo;
    }

    public void setPreguntaEquipo(List<PreguntaEquipo> preguntaEquipo) {
        this.preguntaEquipo = preguntaEquipo;
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
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Pregunta[ idPregunta=" + id + " ]";
    }
    
}
