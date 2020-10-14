/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import DAO.MesaDistritoFacadeLocal;
import com.github.adminfaces.starter.model.MesaDistrito;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author rat_5
 */
@Named
@ViewScoped
public class ConfiguracionesMB implements Serializable {

    @EJB
    private MesaDistritoFacadeLocal mesaDistritoFacadeLocal;

    private MesaDistrito mesaDistrito;
    
    private String tipoIngreso;
    
    private Boolean pTipoIngreso;

    private Integer numMesaEspecifico;
    private Integer numMesaDesde;
    private Integer numMesaHasta;

    public ConfiguracionesMB() {
        this.mesaDistrito = new MesaDistrito();
        this.tipoIngreso = new String();
        this.pTipoIngreso = new Boolean(false);
    }

    public MesaDistritoFacadeLocal getMesaDistritoFacadeLocal() {
        return mesaDistritoFacadeLocal;
    }

    public void setMesaDistritoFacadeLocal(MesaDistritoFacadeLocal mesaDistritoFacadeLocal) {
        this.mesaDistritoFacadeLocal = mesaDistritoFacadeLocal;
    }

    public MesaDistrito getMesaDistrito() {
        return mesaDistrito;
    }

    public void setMesaDistrito(MesaDistrito mesaDistrito) {
        this.mesaDistrito = mesaDistrito;
    }

    public Integer getNumMesaEspecifico() {
        return numMesaEspecifico;
    }

    public void setNumMesaEspecifico(Integer numMesaEspecifico) {
        this.numMesaEspecifico = numMesaEspecifico;
    }

    public Integer getNumMesaDesde() {
        return numMesaDesde;
    }

    public void setNumMesaDesde(Integer numMesaDesde) {
        this.numMesaDesde = numMesaDesde;
    }

    public Integer getNumMesaHasta() {
        return numMesaHasta;
    }

    public void setNumMesaHasta(Integer numMesaHasta) {
        this.numMesaHasta = numMesaHasta;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public void cargarMesasDistrito() {

        if(tipoIngreso.equals("rango")){
        for (int i = numMesaDesde; i <= numMesaHasta; i++) {
            this.mesaDistrito.setMesa(i);
            this.mesaDistritoFacadeLocal.create(mesaDistrito);
       }
        }else{
             this.mesaDistrito.setMesa(numMesaEspecifico);
            this.mesaDistritoFacadeLocal.create(mesaDistrito);
        }
    }
    
    public void handleChange(ValueChangeEvent event){  
    System.out.println("New value: " + event.getNewValue());
}
}
