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
import java.util.Objects;
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
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findByCreateTime", query = "SELECT c FROM Cuenta c WHERE c.createTime = :createTime")
    , @NamedQuery(name = "Cuenta.findByUpdateTime", query = "SELECT c FROM Cuenta c WHERE c.updateTime = :updateTime")
    , @NamedQuery(name = "Cuenta.findByIsActive", query = "SELECT c FROM Cuenta c WHERE c.isActive = :isActive")
    , @NamedQuery(name = "Cuenta.findByIdUsuarioUpdate", query = "SELECT c FROM Cuenta c WHERE c.idUsuarioUpdate = :idUsuarioUpdate")
    , @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.id = :id")
    , @NamedQuery(name = "Cuenta.findByNombre", query = "SELECT c FROM Cuenta c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cuenta.findByNombreCorto", query = "SELECT c FROM Cuenta c WHERE c.nombreCorto = :nombreCorto")
    , @NamedQuery(name = "Cuenta.findByDescripcion", query = "SELECT c FROM Cuenta c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Cuenta.findByMail", query = "SELECT c FROM Cuenta c WHERE c.mail = :mail")
    , @NamedQuery(name = "Cuenta.findByTelefono", query = "SELECT c FROM Cuenta c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Cuenta.findByContacto", query = "SELECT c FROM Cuenta c WHERE c.contacto = :contacto")
    , @NamedQuery(name = "Cuenta.findByDatosComerciales", query = "SELECT c FROM Cuenta c WHERE c.datosComerciales = :datosComerciales")
    , @NamedQuery(name = "Cuenta.findByMedioPago", query = "SELECT c FROM Cuenta c WHERE c.medioPago = :medioPago")
    , @NamedQuery(name = "Cuenta.findByContactoTecnico", query = "SELECT c FROM Cuenta c WHERE c.contactoTecnico = :contactoTecnico")
    , @NamedQuery(name = "Cuenta.findByTransportes", query = "SELECT c FROM Cuenta c WHERE c.transportes = :transportes")
    , @NamedQuery(name = "Cuenta.findByEstado", query = "SELECT c FROM Cuenta c WHERE c.estado = :estado")})
public class Cuenta implements Serializable {

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
    
    //relacion CuentaEquipo
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cuenta")
    private List<CuentaEquipo> cuentaEquipo = new ArrayList<>();
    
    //relacion CampaCuenta

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cuenta")
    private List<CampaCuenta> campaCuenta = new ArrayList<>();
    
     //relacion CuentaUsuario

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cuenta")
    private List<CuentaUsuario> cuentaUsuario = new ArrayList<>();

    @Size(max = 300)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 250)
    @Column(name = "mail")
    private String mail;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 500)
    @Column(name = "contacto")
    private String contacto;
    @Size(max = 500)
    @Column(name = "datos_comerciales")
    private String datosComerciales;
    @Size(max = 45)
    @Column(name = "medio_pago")
    private String medioPago;
    @Size(max = 500)
    @Column(name = "contacto_tecnico")
    private String contactoTecnico;
    @Size(max = 500)
    @Column(name = "transportes")
    private String transportes;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;

    public Cuenta() {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getDatosComerciales() {
        return datosComerciales;
    }

    public void setDatosComerciales(String datosComerciales) {
        this.datosComerciales = datosComerciales;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getContactoTecnico() {
        return contactoTecnico;
    }

    public void setContactoTecnico(String contactoTecnico) {
        this.contactoTecnico = contactoTecnico;
    }

    public String getTransportes() {
        return transportes;
    }

    public void setTransportes(String transportes) {
        this.transportes = transportes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CuentaEquipo> getCuentaEquipo() {
        return cuentaEquipo;
    }

    public void setCuentaEquipo(List<CuentaEquipo> cuentaEquipo) {
        this.cuentaEquipo = cuentaEquipo;
    }

    public List<CampaCuenta> getCampaCuenta() {
        return campaCuenta;
    }

    public void setCampaCuenta(List<CampaCuenta> campaCuenta) {
        this.campaCuenta = campaCuenta;
    }

    public List<CuentaUsuario> getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(List<CuentaUsuario> cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
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
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Cuenta[ idCuenta=" + id + " ]";
    }

 

}
