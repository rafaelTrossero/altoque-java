/*
 * To change this template, choose Tools | Templates
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rmpestano
 */
@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT f FROM Car f"),
    @NamedQuery(name = "Car.findByPatente", query = "SELECT f FROM Car f WHERE f.patente = :patente"),
    @NamedQuery(name = "Car.findByMarca", query = "SELECT f FROM Car f WHERE f.name = :name"),
    @NamedQuery(name = "Car.findByModelo", query = "SELECT f FROM Car f WHERE f.model = :model"),
    @NamedQuery(name = "Car.findById", query = "SELECT f FROM Car f WHERE f.id = :id")})
public class Car implements Serializable {

   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    private String model;
    private String name;
    private String patente;
    private String color;
    private String nombre_chofer;
    private String telefono_chofer;
    
     @OneToMany(mappedBy = "car")
    private List<PastorCar> lstPastorCar;
     
     @OneToMany(mappedBy = "car")
    private List<PadronVv> lstVotanteCar;

    public Car() {
    }

    public Car(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public void setId(Integer id) {
        this.id = id;
    }

    public Car model(String model) {
        this.model = model;
        return this;
    }

    
    public Car name(String name) {
        this.name = name;
        return this;
    }

    public List<PastorCar> getLstPastorCar() {
        return lstPastorCar;
    }

    public void setLstPastorCar(List<PastorCar> lstPastorCar) {
        this.lstPastorCar = lstPastorCar;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<PadronVv> getLstVotanteCar() {
        return lstVotanteCar;
    }

    public void setLstVotanteCar(List<PadronVv> lstVotanteCar) {
        this.lstVotanteCar = lstVotanteCar;
    }

    public String getNombre_chofer() {
        return nombre_chofer;
    }

    public void setNombre_chofer(String nombre_chofer) {
        this.nombre_chofer = nombre_chofer;
    }

    public String getTelefono_chofer() {
        return telefono_chofer;
    }

    public void setTelefono_chofer(String telefono_chofer) {
        this.telefono_chofer = telefono_chofer;
    }

 

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public boolean hasModel() {
        return model != null && !"".equals(model.trim());
    }

    public boolean hasName() {
        return name != null && !"".equals(name.trim());
    }

    
}
