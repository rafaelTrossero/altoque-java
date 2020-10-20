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
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e")
    , @NamedQuery(name = "Equipos.findByCreateTime", query = "SELECT e FROM Equipos e WHERE e.createTime = :createTime")
    , @NamedQuery(name = "Equipos.findByUpdateTime", query = "SELECT e FROM Equipos e WHERE e.updateTime = :updateTime")
    , @NamedQuery(name = "Equipos.findByIsActive", query = "SELECT e FROM Equipos e WHERE e.isActive = :isActive")
    , @NamedQuery(name = "Equipos.findByIdUsuarioUpdate", query = "SELECT e FROM Equipos e WHERE e.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Equipos.findByIdEquipo", query = "SELECT e FROM Equipos e WHERE e.id = :id")
    , @NamedQuery(name = "Equipos.findByCaracteristicas", query = "SELECT e FROM Equipos e WHERE e.caracteristicas = :caracteristicas")
    , @NamedQuery(name = "Equipos.findByVersion", query = "SELECT e FROM Equipos e WHERE e.version = :version")
    , @NamedQuery(name = "Equipos.findByRevision", query = "SELECT e FROM Equipos e WHERE e.revision = :revision")
    , @NamedQuery(name = "Equipos.findByFirmware", query = "SELECT e FROM Equipos e WHERE e.firmware = :firmware")
    , @NamedQuery(name = "Equipos.findByMac", query = "SELECT e FROM Equipos e WHERE e.mac = :mac")
    , @NamedQuery(name = "Equipos.findByTipo", query = "SELECT e FROM Equipos e WHERE e.tipo = :tipo")})
public class Equipos implements Serializable {

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
    @Column(name = "caracteristicas")
    private String caracteristicas;
    @Size(max = 45)
    @Column(name = "version")
    private String version;
    @Size(max = 45)
    @Column(name = "revision")
    private String revision;
    @Size(max = 45)
    @Column(name = "firmware")
    private String firmware;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mac")
    private String mac;
    @Size(max = 100)
    @Column(name = "tipo")
    private String tipo;
    
     @OneToMany(mappedBy = "equipo") 
    private List<CuentaEquipo> cuentaEquipo = new ArrayList<>();

     
      @OneToMany(mappedBy = "equipo") 
    private List<CampaEquipo> campaEquipo = new ArrayList<>();
      
        //relacion PreguntaEquipo

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipo")
    private List<PreguntaEquipo> preguntaEquipo = new ArrayList<>();

    public Equipos() {
    }

    public Equipos(Integer idEquipo) {
        this.id = idEquipo;
    }

    public Equipos(Integer idEquipo, short isActive, String mac) {
        this.id = idEquipo;
        this.isActive = isActive;
        this.mac = mac;
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

 
    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<CuentaEquipo> getCuentaEquipo() {
        return cuentaEquipo;
    }

    public void setCuentaEquipo(List<CuentaEquipo> cuentaEquipo) {
        this.cuentaEquipo = cuentaEquipo;
    }

    public List<CampaEquipo> getCampaEquipo() {
        return campaEquipo;
    }

    public void setCampaEquipo(List<CampaEquipo> campaEquipo) {
        this.campaEquipo = campaEquipo;
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
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Equipos[ idEquipo=" + id + " ]";
    }
    
}
