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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "pregunta_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntaEquipo.findAll", query = "SELECT p FROM PreguntaEquipo p")
    , @NamedQuery(name = "PreguntaEquipo.findByCreateTime", query = "SELECT p FROM PreguntaEquipo p WHERE p.createTime = :createTime")
    , @NamedQuery(name = "PreguntaEquipo.findByUpdateTime", query = "SELECT p FROM PreguntaEquipo p WHERE p.updateTime = :updateTime")
    , @NamedQuery(name = "PreguntaEquipo.findByIsActive", query = "SELECT p FROM PreguntaEquipo p WHERE p.isActive = :isActive")
    , @NamedQuery(name = "PreguntaEquipo.findByIdUsuarioUpdate", query = "SELECT p FROM PreguntaEquipo p WHERE p.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "PreguntaEquipo.findByIdPreguntaEquipo", query = "SELECT p FROM PreguntaEquipo p WHERE p.id = :id")
    , @NamedQuery(name = "PreguntaEquipo.findByIdCampaA", query = "SELECT p FROM PreguntaEquipo p WHERE p.idCampaA = :idCampaA")
    , @NamedQuery(name = "PreguntaEquipo.findByEstado", query = "SELECT p FROM PreguntaEquipo p WHERE p.estado = :estado")
    , @NamedQuery(name = "PreguntaEquipo.findByDashboard", query = "SELECT p FROM PreguntaEquipo p WHERE p.dashboard = :dashboard")
    , @NamedQuery(name = "PreguntaEquipo.findByGrafico", query = "SELECT p FROM PreguntaEquipo p WHERE p.grafico = :grafico")
    , @NamedQuery(name = "PreguntaEquipo.findByIndice1", query = "SELECT p FROM PreguntaEquipo p WHERE p.indice1 = :indice1")
    , @NamedQuery(name = "PreguntaEquipo.findByIndice2", query = "SELECT p FROM PreguntaEquipo p WHERE p.indice2 = :indice2")})
public class PreguntaEquipo implements Serializable {

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
    
    
    
    
     @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id", insertable = false, updatable = false)
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name = "id_equipo", referencedColumnName = "id", insertable = false, updatable = false)
    private Equipos equipo;
    
    
    
    
    @Column(name = "id_campa_a")
    private Short idCampaA;
    @Size(max = 150)
    @Column(name = "estado")
    private String estado;
    @Size(max = 150)
    @Column(name = "dashboard")
    private String dashboard;
    @Size(max = 150)
    @Column(name = "grafico")
    private String grafico;
    @Size(max = 150)
    @Column(name = "indice1")
    private String indice1;
    @Size(max = 150)
    @Column(name = "indice2")
    private String indice2;

    public PreguntaEquipo() {
    }

    public PreguntaEquipo(Integer idPreguntaEquipo) {
        this.id = idPreguntaEquipo;
    }

    public PreguntaEquipo(Integer idPreguntaEquipo, short isActive, short idEquipo, short idPregunta) {
        this.id = idPreguntaEquipo;
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

    public Integer getIdPreguntaEquipo() {
        return id;
    }

    public void setIdPreguntaEquipo(Integer idPreguntaEquipo) {
        this.id = idPreguntaEquipo;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

   
    public Short getIdCampaA() {
        return idCampaA;
    }

    public void setIdCampaA(Short idCampaA) {
        this.idCampaA = idCampaA;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDashboard() {
        return dashboard;
    }

    public void setDashboard(String dashboard) {
        this.dashboard = dashboard;
    }

    public String getGrafico() {
        return grafico;
    }

    public void setGrafico(String grafico) {
        this.grafico = grafico;
    }

    public String getIndice1() {
        return indice1;
    }

    public void setIndice1(String indice1) {
        this.indice1 = indice1;
    }

    public String getIndice2() {
        return indice2;
    }

    public void setIndice2(String indice2) {
        this.indice2 = indice2;
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
        if (!(object instanceof PreguntaEquipo)) {
            return false;
        }
        PreguntaEquipo other = (PreguntaEquipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.PreguntaEquipo[ idPreguntaEquipo=" + id + " ]";
    }
    
}
