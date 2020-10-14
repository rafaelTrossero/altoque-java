/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rat_5
 */
@Entity
@Table(name = "padron")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PadronVv.findAll", query = "SELECT p FROM PadronVv p")
    , @NamedQuery(name = "PadronVv.findById", query = "SELECT p FROM PadronVv p WHERE p.id = :id")
    , @NamedQuery(name = "PadronVv.findBySexo", query = "SELECT p FROM PadronVv p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "PadronVv.findBySecc", query = "SELECT p FROM PadronVv p WHERE p.secc = :secc")
    , @NamedQuery(name = "PadronVv.findByCircu", query = "SELECT p FROM PadronVv p WHERE p.circu = :circu")
    , @NamedQuery(name = "PadronVv.findByCirc1", query = "SELECT p FROM PadronVv p WHERE p.circ1 = :circ1")
    , @NamedQuery(name = "PadronVv.findByEdad", query = "SELECT p FROM PadronVv p WHERE p.edad = :edad")
    , @NamedQuery(name = "PadronVv.findByClase", query = "SELECT p FROM PadronVv p WHERE p.clase = :clase")
    , @NamedQuery(name = "PadronVv.findByTipdoc", query = "SELECT p FROM PadronVv p WHERE p.tipdoc = :tipdoc")
    , @NamedQuery(name = "PadronVv.findByDni", query = "SELECT p FROM PadronVv p WHERE p.dni = :dni")
    , @NamedQuery(name = "PadronVv.findByPad2015", query = "SELECT p FROM PadronVv p WHERE p.pad2015 = :pad2015")
    , @NamedQuery(name = "PadronVv.findByApenom", query = "SELECT p FROM PadronVv p  WHERE lower(p.apenom) LIKE lower(:apenom)")//LIKE CONCAT('%',:apenom,'%')
    , @NamedQuery(name = "PadronVv.findByNombres", query = "SELECT p FROM PadronVv p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "PadronVv.findByDomic", query = "SELECT p FROM PadronVv p WHERE p.domic = :domic")
    , @NamedQuery(name = "PadronVv.findByAfi", query = "SELECT p FROM PadronVv p WHERE p.afi = :afi")
    , @NamedQuery(name = "PadronVv.findByPartido", query = "SELECT p FROM PadronVv p WHERE p.partido = :partido")
    , @NamedQuery(name = "PadronVv.findByProfes", query = "SELECT p FROM PadronVv p WHERE p.profes = :profes")
    , @NamedQuery(name = "PadronVv.findByAna", query = "SELECT p FROM PadronVv p WHERE p.ana = :ana")
    , @NamedQuery(name = "PadronVv.findByMesa", query = "SELECT p FROM PadronVv p WHERE p.mesa = :mesa")
    , @NamedQuery(name = "PadronVv.findByAdf", query = "SELECT p FROM PadronVv p WHERE p.adf = :adf")
    , @NamedQuery(name = "PadronVv.findByOrden", query = "SELECT p FROM PadronVv p WHERE p.orden = :orden")
    , @NamedQuery(name = "PadronVv.findByCodPp", query = "SELECT p FROM PadronVv p WHERE p.codPp = :codPp")
    , @NamedQuery(name = "PadronVv.findByDesCir", query = "SELECT p FROM PadronVv p WHERE p.desCir = :desCir")
    , @NamedQuery(name = "PadronVv.findByMun", query = "SELECT p FROM PadronVv p WHERE p.mun = :mun")
    , @NamedQuery(name = "PadronVv.findByDesmu", query = "SELECT p FROM PadronVv p WHERE p.desmu = :desmu")
    , @NamedQuery(name = "PadronVv.findByTelefono", query = "SELECT p FROM PadronVv p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "PadronVv.findByDesSec", query = "SELECT p FROM PadronVv p WHERE p.desSec = :desSec")
    , @NamedQuery(name = "PadronVv.findByClaseNum", query = "SELECT p FROM PadronVv p WHERE p.claseNum = :claseNum")
    , @NamedQuery(name = "PadronVv.findByAuto", query = "SELECT p FROM PadronVv p WHERE p.car = :car")
    , @NamedQuery(name = "PadronVv.editVinculado", query = "UPDATE PadronVv p SET p.vinculado=false WHERE p.id = :id")})
public class PadronVv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 2)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "secc")
    private Integer secc;
    @Column(name = "circu")
    private Integer circu;
    @Column(name = "circ1")
    private Integer circ1;
    @Size(max = 2147483647)
    @Column(name = "edad")
    private String edad;
    @Column(name = "clase")
    private Integer clase;
    @Size(max = 2147483647)
    @Column(name = "tipdoc")
    private String tipdoc;
    @Column(name = "dni")
    private Integer dni;
    @Size(max = 2147483647)
    @Column(name = "pad_2015")
    private String pad2015;
    @Size(max = 2147483647)
    @Column(name = "apenom")
    private String apenom;
    @Size(max = 2147483647)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 2147483647)
    @Column(name = "domic")
    private String domic;
    @Column(name = "afi")
    private Integer afi;
    @Size(max = 2147483647)
    @Column(name = "partido")
    private String partido;
    @Size(max = 2147483647)
    @Column(name = "profes")
    private String profes;
    @Size(max = 2147483647)
    @Column(name = "ana")
    private String ana;
    @Column(name = "mesa")
    private Integer mesa;
    @Size(max = 2147483647)
    @Column(name = "adf")
    private String adf;
    @Column(name = "orden")
    private Integer orden;
    @Size(max = 2147483647)
    @Column(name = "cod_pp")
    private String codPp;
    @Size(max = 2147483647)
    @Column(name = "des_cir")
    private String desCir;
    @Column(name = "mun")
    private Integer mun;
    @Size(max = 2147483647)
    @Column(name = "desmu")
    private String desmu;
    @Size(max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 2147483647)
    @Column(name = "des_sec")
    private String desSec;
    @Column(name = "clase_num")
    private Integer claseNum;

    @Column(name = "asistio")
    private Boolean asistio;

    @Column(name = "vinculado")
    private Boolean vinculado;

    @OneToMany(mappedBy = "votante")
    private List<PastorVotante> lstPastorVotante;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car")
    private Car car;

    public PadronVv() {
    }

    public PadronVv(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getSecc() {
        return secc;
    }

    public void setSecc(Integer secc) {
        this.secc = secc;
    }

    public Integer getCircu() {
        return circu;
    }

    public void setCircu(Integer circu) {
        this.circu = circu;
    }

    public Integer getCirc1() {
        return circ1;
    }

    public void setCirc1(Integer circ1) {
        this.circ1 = circ1;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Integer getClase() {
        return clase;
    }

    public void setClase(Integer clase) {
        this.clase = clase;
    }

    public String getTipdoc() {
        return tipdoc;
    }

    public void setTipdoc(String tipdoc) {
        this.tipdoc = tipdoc;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getPad2015() {
        return pad2015;
    }

    public void setPad2015(String pad2015) {
        this.pad2015 = pad2015;
    }

    public String getApenom() {
        return apenom;
    }

    public void setApenom(String apenom) {
        this.apenom = apenom;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDomic() {
        return domic;
    }

    public void setDomic(String domic) {
        this.domic = domic;
    }

    public Integer getAfi() {
        return afi;
    }

    public void setAfi(Integer afi) {
        this.afi = afi;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getProfes() {
        return profes;
    }

    public void setProfes(String profes) {
        this.profes = profes;
    }

    public String getAna() {
        return ana;
    }

    public void setAna(String ana) {
        this.ana = ana;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public String getAdf() {
        return adf;
    }

    public void setAdf(String adf) {
        this.adf = adf;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getCodPp() {
        return codPp;
    }

    public void setCodPp(String codPp) {
        this.codPp = codPp;
    }

    public String getDesCir() {
        return desCir;
    }

    public void setDesCir(String desCir) {
        this.desCir = desCir;
    }

    public Integer getMun() {
        return mun;
    }

    public void setMun(Integer mun) {
        this.mun = mun;
    }

    public String getDesmu() {
        return desmu;
    }

    public void setDesmu(String desmu) {
        this.desmu = desmu;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDesSec() {
        return desSec;
    }

    public void setDesSec(String desSec) {
        this.desSec = desSec;
    }

    public Integer getClaseNum() {
        return claseNum;
    }

    public void setClaseNum(Integer claseNum) {
        this.claseNum = claseNum;
    }

    public List<PastorVotante> getLstPastorVotante() {
        return lstPastorVotante;
    }

    public void setLstPastorVotante(List<PastorVotante> lstPastorVotante) {
        this.lstPastorVotante = lstPastorVotante;
    }

    public Boolean getAsistio() {
        return asistio;
    }

    public void setAsistio(Boolean asistio) {
        this.asistio = asistio;
    }

    public Boolean getVinculado() {
        return vinculado;
    }

    public void setVinculado(Boolean vinculado) {
        this.vinculado = vinculado;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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
        if (!(object instanceof PadronVv)) {
            return false;
        }
        PadronVv other = (PadronVv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.github.adminfaces.starter.model.PadronVv[ id=" + id + " ]";
    }

}
