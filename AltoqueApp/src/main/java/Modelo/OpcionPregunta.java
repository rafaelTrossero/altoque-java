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
@Table(name = "opcion_pregunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionPregunta.findAll", query = "SELECT o FROM OpcionPregunta o")
    , @NamedQuery(name = "OpcionPregunta.findByCreateTime", query = "SELECT o FROM OpcionPregunta o WHERE o.createTime = :createTime")
    , @NamedQuery(name = "OpcionPregunta.findByUpdateTime", query = "SELECT o FROM OpcionPregunta o WHERE o.updateTime = :updateTime")
    , @NamedQuery(name = "OpcionPregunta.findByIsActive", query = "SELECT o FROM OpcionPregunta o WHERE o.isActive = :isActive")
    , @NamedQuery(name = "OpcionPregunta.findByIdUsuarioUpdate", query = "SELECT o FROM OpcionPregunta o WHERE o.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "OpcionPregunta.findByIdOpcionPregunta", query = "SELECT o FROM OpcionPregunta o WHERE o.id = :id")
    , @NamedQuery(name = "OpcionPregunta.findByValorNumerico", query = "SELECT o FROM OpcionPregunta o WHERE o.valorNumerico = :valorNumerico")
    , @NamedQuery(name = "OpcionPregunta.findByValorRango", query = "SELECT o FROM OpcionPregunta o WHERE o.valorRango = :valorRango")
    , @NamedQuery(name = "OpcionPregunta.findByValorTexto", query = "SELECT o FROM OpcionPregunta o WHERE o.valorTexto = :valorTexto")
    , @NamedQuery(name = "OpcionPregunta.findByIcono", query = "SELECT o FROM OpcionPregunta o WHERE o.icono = :icono")
    , @NamedQuery(name = "OpcionPregunta.findByIdPreguntaEquipo", query = "SELECT o FROM OpcionPregunta o WHERE o.idPreguntaEquipo = :idPreguntaEquipo")
    , @NamedQuery(name = "OpcionPregunta.findByBoton", query = "SELECT o FROM OpcionPregunta o WHERE o.boton = :boton")})
public class OpcionPregunta implements Serializable {

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
    
    @Column(name = "valor_numerico")
    private Short valorNumerico;
    @Size(max = 45)
    @Column(name = "valor_rango")
    private String valorRango;
    @Size(max = 150)
    @Column(name = "valor_texto")
    private String valorTexto;
    @Size(max = 450)
    @Column(name = "icono")
    private String icono;
    
     @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id", insertable = false, updatable = false)
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name = "id_opciones", referencedColumnName = "id", insertable = false, updatable = false)
    private Opciones opciones;
    
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pregunta_equipo")
    private int idPreguntaEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "boton")
    private short boton;

    public OpcionPregunta() {
    }

    public OpcionPregunta(Integer idOpcionPregunta) {
        this.id = idOpcionPregunta;
    }

    public OpcionPregunta(Integer idOpcionPregunta, short isActive, int idOpcion, int idPregunta, int idPreguntaEquipo, short boton) {
        this.id = idOpcionPregunta;
        this.isActive = isActive;
       
        this.idPreguntaEquipo = idPreguntaEquipo;
        this.boton = boton;
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

    public Integer getIdOpcionPregunta() {
        return id;
    }

    public void setIdOpcionPregunta(Integer idOpcionPregunta) {
        this.id = idOpcionPregunta;
    }

    public Short getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(Short valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public String getValorRango() {
        return valorRango;
    }

    public void setValorRango(String valorRango) {
        this.valorRango = valorRango;
    }

    public String getValorTexto() {
        return valorTexto;
    }

    public void setValorTexto(String valorTexto) {
        this.valorTexto = valorTexto;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Opciones getOpciones() {
        return opciones;
    }

    public void setOpciones(Opciones opciones) {
        this.opciones = opciones;
    }

   

    public int getIdPreguntaEquipo() {
        return idPreguntaEquipo;
    }

    public void setIdPreguntaEquipo(int idPreguntaEquipo) {
        this.idPreguntaEquipo = idPreguntaEquipo;
    }

    public short getBoton() {
        return boton;
    }

    public void setBoton(short boton) {
        this.boton = boton;
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
        if (!(object instanceof OpcionPregunta)) {
            return false;
        }
        OpcionPregunta other = (OpcionPregunta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.OpcionPregunta[ idOpcionPregunta=" + id + " ]";
    }
    
}
