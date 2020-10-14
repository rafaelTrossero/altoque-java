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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Matias
 */
@Entity
@Table(name = "candidatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidatos.findAll", query = "SELECT c FROM Candidatos c")
    , @NamedQuery(name = "Candidatos.findAllNacionales", query = "SELECT c FROM Candidatos c WHERE c.is_nacional = TRUE AND c.lugar is NULL ORDER BY c.orden ASC")
    , @NamedQuery(name = "Candidatos.findAllProvinciales", query = "SELECT c FROM Candidatos c WHERE c.is_nacional = FALSE ORDER BY c.orden ASC")
        , @NamedQuery(name = "Candidatos.findAllProvincialesByLugar", query = "SELECT c FROM Candidatos c WHERE c.lugar = :lugar  ORDER BY c.orden ASC")
    , @NamedQuery(name = "Candidatos.findAllByLugar", query = "SELECT c FROM Candidatos c WHERE c.lugar = :lugar ORDER BY c.orden ASC")
    , @NamedQuery(name = "Candidatos.findById", query = "SELECT c FROM Candidatos c WHERE c.id = :id")
    , @NamedQuery(name = "Candidatos.findByCandidato", query = "SELECT c FROM Candidatos c WHERE c.candidato = :candidato")
    , @NamedQuery(name = "Candidatos.findByPartido", query = "SELECT c FROM Candidatos c WHERE c.partido = :partido")
    , @NamedQuery(name = "Candidatos.findByLista", query = "SELECT c FROM Candidatos c WHERE c.lista = :lista")
    , @NamedQuery(name = "Candidatos.findByCargo", query = "SELECT c FROM Candidatos c WHERE c.cargo = :cargo")
    , @NamedQuery(name = "Candidatos.findIdByComando", query = "SELECT c.id FROM Candidatos c WHERE c.comando = :comando")
    , @NamedQuery(name = "Candidatos.findCargos", query = "SELECT DISTINCT (c.cargo) FROM Candidatos c ")
    , @NamedQuery(name = "Candidatos.findByComando", query = "SELECT c FROM Candidatos c WHERE c.comando = :comando")})
public class Candidatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "candidato")
    private String candidato;
    @Size(max = 2147483647)
    @Column(name = "partido")
    private String partido;
    @Size(max = 2147483647)
    @Column(name = "lista")
    private String lista;
    @Size(max = 2147483647)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "comando")
    private String comando;

    @Column(name = "agrupacion")
    private String agrupacion;

    @Column(name = "numero_lista")
    private String numero_lista;

    @Column(name = "lugar")
    private String lugar;

    @Column(name = "is_nacional")
    private Boolean is_nacional;

    @OneToMany(mappedBy = "candidato")
    private List<CandidatosVotos> lstCandidatosVotos;

    @OneToMany(mappedBy = "candidato")
    private List<CandidatoAlias> lstCandidatoAlias;

    @OneToMany(mappedBy = "candidato")
    private List<Acta> lstActa;

    @Column(name = "orden")
    private Integer orden;

    public Candidatos() {
    }

    public Candidatos(Integer id) {
        this.id = id;
    }

    public Candidatos(Integer id, String comando) {
        this.id = id;
        this.comando = comando;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getNumero_lista() {
        return numero_lista;
    }

    public void setNumero_lista(String numero_lista) {
        this.numero_lista = numero_lista;
    }

    public Boolean getIs_nacional() {
        return is_nacional;
    }

    public void setIs_nacional(Boolean is_nacional) {
        this.is_nacional = is_nacional;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public List<CandidatosVotos> getLstCandidatosVotos() {
        return lstCandidatosVotos;
    }

    public void setLstCandidatosVotos(List<CandidatosVotos> lstCandidatosVotos) {
        this.lstCandidatosVotos = lstCandidatosVotos;
    }

    public List<Acta> getLstActa() {
        return lstActa;
    }

    public void setLstActa(List<Acta> lstActa) {
        this.lstActa = lstActa;
    }

    public List<CandidatoAlias> getLstCandidatoAlias() {
        return lstCandidatoAlias;
    }

    public void setLstCandidatoAlias(List<CandidatoAlias> lstCandidatoAlias) {
        this.lstCandidatoAlias = lstCandidatoAlias;
    }

    public String getAgrupacion() {
        return agrupacion;
    }

    public void setAgrupacion(String agrupacion) {
        this.agrupacion = agrupacion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidatos)) {
            return false;
        }
        Candidatos other = (Candidatos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Candidatos[ id=" + id + " ]";
    }

}
