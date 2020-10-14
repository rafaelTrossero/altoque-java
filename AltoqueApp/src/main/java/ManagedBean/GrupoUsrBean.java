/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import DAO.GrupoFacadeLocal;
import Modelo.Grupo;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.component.commandbutton.CommandButton;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@RequestScoped
public class GrupoUsrBean {

   @EJB
    private GrupoFacadeLocal grupoFacadeLocal;
    private Grupo grupo;
    
    private CommandButton cbAction;
    
    
     @ManagedProperty("#{listaGrupoUsrBean}")
    private ListaGrupoUsrBean listaGrupoUsrBean;
     
    public GrupoUsrBean() {
         grupo = new Grupo();
    }
    
     public GrupoFacadeLocal getGrupoFacadeLocal() {
        return grupoFacadeLocal;
    }

    public void setGrupoFacadeLocal(GrupoFacadeLocal grupoFacadeLocal) {
        this.grupoFacadeLocal = grupoFacadeLocal;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public ListaGrupoUsrBean getListaGrupoUsrBean() {
        return listaGrupoUsrBean;
    }

    public void setListaGrupoUsrBean(ListaGrupoUsrBean listaGrupoUsrBean) {
        this.listaGrupoUsrBean = listaGrupoUsrBean;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }
    
    
    public void actionBtn() {

        System.out.println("::::::::::::::::::::::::::::::" + this.getListaGrupoUsrBean().getiActionBtnSelect());
        switch (this.getListaGrupoUsrBean().getiActionBtnSelect()) {

            case 0:
                createGrupo();
                break;
            case 1:
                editGrupo();
                break;
        }//fin switch

    }//fin actionBtn

    public void setBtnSelect(ActionEvent e) {
        CommandButton btnSelect = (CommandButton) e.getSource();

        System.out.println("boton select: " + btnSelect.getId());

        //activo el boton
        this.getCbAction().setDisabled(false);

       
        if (btnSelect.getId().equals("cbCreateG")) {
            System.out.println("entro a cbCreateG");
            this.getListaGrupoUsrBean().setiActionBtnSelect(0);
            this.getCbAction().setValue("Guardar");
            System.out.println("entro a cbCreateG,  this.setiActionBtnSelect(3); " + this.getListaGrupoUsrBean().getiActionBtnSelect());
        } else if (btnSelect.getId().equals("cbEditG")) {

            this.getListaGrupoUsrBean().setiActionBtnSelect(1);
            this.getCbAction().setValue("Modificar");

        }

    }//fin setBtnSelect
    
    
    public void createGrupo() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            grupoFacadeLocal.create(this.getGrupo());
            sMensaje = "El Grupo fue guardado";
            severity = FacesMessage.SEVERITY_INFO;
            //agregar a la lista
            // this.getUsuarioLstBean().getLstUsuario().add(this.getUsuario());
            //limíar campos
            this.limpiar();

        } catch (Exception ex) {

            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin create

    
     public void editGrupo() {

        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            grupoFacadeLocal.edit(this.getGrupo());

            sMensaje = "El dato fue modificado";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego  a la lista
            int iPos = this.getListaGrupoUsrBean().getLstGrupo().indexOf(this.getGrupo());

            this.getListaGrupoUsrBean().getLstGrupo().remove(iPos);
            this.getListaGrupoUsrBean().getLstGrupo().add(iPos, this.getGrupo());

            this.getCbAction().setValue("Editar");
            this.getCbAction().setDisabled(true);

        } catch (Exception ex) {

            if (ex.getMessage().trim().toLowerCase().equals("transaction aborted")) {
                sMensaje = "Error: No se puede eliminar";
            } else {
                sMensaje = "Error: " + ex.getMessage();
            }

            severity = FacesMessage.SEVERITY_ERROR;

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }

    }//fin edit
     
           
     private void limpiar() {
        this.grupo = new Grupo();
    }

}
