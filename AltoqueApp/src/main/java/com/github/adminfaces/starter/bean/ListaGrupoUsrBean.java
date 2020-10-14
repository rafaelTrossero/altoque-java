/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import DAO.GrupoFacadeLocal;

import com.github.adminfaces.starter.model.Grupo;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@SessionScoped
public class ListaGrupoUsrBean implements Serializable {

  private int iActionBtnSelect;
  
   private List<Grupo> lstGrupo;
    private List<SelectItem> lstSIGrupo;
   
      @EJB
    private GrupoFacadeLocal GrupoFacadeLocal;//hacemos la referencia para poder utilizar el metodo findall
      
    public ListaGrupoUsrBean() {
          lstGrupo = new ArrayList<Grupo>();
    }
       @PostConstruct
    private void init() {
        
        this.cargarGrupo();
        this.cargar_SI_grupos();

    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public List<Grupo> getLstGrupo() {
        return lstGrupo;
    }

    public void setLstGrupo(List<Grupo> lstGrupo) {
        this.lstGrupo = lstGrupo;
    }

    public GrupoFacadeLocal getGrupoFacadeLocal() {
        return GrupoFacadeLocal;
    }

    public void setGrupoFacadeLocal(GrupoFacadeLocal GrupoFacadeLocal) {
        this.GrupoFacadeLocal = GrupoFacadeLocal;
    }

    public List<SelectItem> getLstSIGrupo() {
        return lstSIGrupo;
    }

    public void setLstSIGrupo(List<SelectItem> lstSIGrupo) {
        this.lstSIGrupo = lstSIGrupo;
    }
    
     public void cargarGrupo() {
        try {
            this.setLstGrupo(this.GrupoFacadeLocal.findAll());
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error: " + ex,
                    null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarUsuario
     
       public void cargar_SI_grupos() {
        this.setLstSIGrupo(new ArrayList<SelectItem>());

        for (Grupo d : this.getLstGrupo()) {
            SelectItem si = new SelectItem(d, d.getNombre());
            this.getLstSIGrupo().add(si);
        }
       
    }//fin for
    
}
