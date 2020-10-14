/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;


import RN.UsuariosRNLocal;

import com.github.adminfaces.starter.model.Usuarios;
import com.github.adminfaces.starter.service.UserService;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;

import recursos.Encrypter;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.primefaces.component.commandbutton.CommandButton;

/**
 *
 * @author AFerSor
 */
@Named
@ViewScoped
public class UsuarioBean implements Serializable {

    @EJB
    private UsuariosRNLocal usuarioRNLocal;

     @Inject
    UserService userService;
    
    @ManagedProperty("#{usuarioLstBean}")
    private UsuarioLstBean usuarioLstBean;
    private Usuarios usuario;
 private Integer id;
    private List<Usuarios> selectedUsuario;
    
    List<Usuarios> filteredValue;// datatable filteredValue attribute (column filters)
    private String sConfirmarContrasena;
    private Boolean bCamposSoloLectura;

    private CommandButton cbAction;

    public UsuarioBean() {
        usuario = new Usuarios();
       
    }
    
     public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(id)) {
            usuario = usuarioRNLocal.findById(id);
           
        } else {
            usuario = new Usuarios();
        }
    }

    /*   public UsuarioLstBean getUsuarioLstBean() {
     return usuarioLstBean;
     }*/

 /*   public void setUsuarioLstBean(UsuarioLstBean usuarioLstBean) {
     this.usuarioLstBean = usuarioLstBean;
     }*/
    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Boolean getbCamposSoloLectura() {
        return bCamposSoloLectura;
    }

    public void setbCamposSoloLectura(Boolean bCamposSoloLectura) {
        this.bCamposSoloLectura = bCamposSoloLectura;
    }

    public CommandButton getCbAction() {
        return cbAction;
    }

    public void setCbAction(CommandButton cbAction) {
        this.cbAction = cbAction;
    }

    public String getsConfirmarContrasena() {
        return sConfirmarContrasena;
    }

    public void setsConfirmarContrasena(String sConfirmarContrasena) {
        this.sConfirmarContrasena = sConfirmarContrasena;
    }

    public UsuarioLstBean getUsuarioLstBean() {
        return usuarioLstBean;
    }

    public void setUsuarioLstBean(UsuarioLstBean usuarioLstBean) {
        this.usuarioLstBean = usuarioLstBean;
    }

    public UsuariosRNLocal getUsuarioRNLocal() {
        return usuarioRNLocal;
    }

    public void setUsuarioRNLocal(UsuariosRNLocal usuarioRNLocal) {
        this.usuarioRNLocal = usuarioRNLocal;
    }

    public List<Usuarios> getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(List<Usuarios> selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public void actionBtn() {

        System.out.println("::::::::::::::::::::::::::::::" + this.getUsuarioLstBean().getiActionBtnSelect());
        switch (this.getUsuarioLstBean().getiActionBtnSelect()) {
            case 0:
                create();
                break;
            case 1:
                this.edit();
                break;
            case 2:
                //borra el campo
                this.delete();
                //this.delete(Boolean.TRUE);
                break;
           
        }//fin switch

    }//fin actionBtn

    public void setBtnSelect(ActionEvent e) {
        CommandButton btnSelect = (CommandButton) e.getSource();

        System.out.println("boton select: " + btnSelect.getId());

        //activo el boton
        this.getCbAction().setDisabled(false);

        if (btnSelect.getId().equals("cbCreate")) {
            this.getUsuarioLstBean().setiActionBtnSelect(0);
            this.getCbAction().setValue("Guardar");

        } else if (btnSelect.getId().equals("cbDelete")) {
            this.getUsuarioLstBean().setiActionBtnSelect(2);

            this.setbCamposSoloLectura(true);
            this.getCbAction().setValue("Eliminar");

        } else if (btnSelect.getId().equals("cbEdit")) {

            this.getUsuarioLstBean().setiActionBtnSelect(1);
            this.getCbAction().setValue("Modificar");

        } else if (btnSelect.getId().equals("cbCreateG")) {
            System.out.println("entro a cbCreateG");
            this.getUsuarioLstBean().setiActionBtnSelect(3);
            this.getCbAction().setValue("Guardar");
            System.out.println("entro a cbCreateG,  this.setiActionBtnSelect(3); " + this.getUsuarioLstBean().getiActionBtnSelect());
        } else if (btnSelect.getId().equals("cbEditG")) {

            this.getUsuarioLstBean().setiActionBtnSelect(4);
            this.getCbAction().setValue("Modificar");

        }
    }

        
        public void save() throws Exception {
        String msg;
        if (usuario.getId() == null) {
            System.out.println("es super---" +usuario.getIsSuper());
            if (usuario.getIsSuper() == null) {
                usuario.setIsSuper(Boolean.FALSE);
            }
            usuario.setPassword(Encrypter.encriptar(usuario.getPassword()));
            usuario.setIsActive(Boolean.TRUE);
             System.out.println("es super---after if" +usuario.getIsSuper());
            userService.insert(usuario);
            msg = "usuario " + usuario.getUsuario() + " creado con exito";
        } else {
            //usuario.setPassword(Encrypter.encriptar(usuario.getPassword()));
            userService.update(usuario);
            msg = "usuario " + usuario.getUsuario() + " actualizado con exito";
        }
        addDetailMessage(msg);
    }

        
    //fin setBtnSelect

    public void create() {
        System.out.println("Entro al crear");
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            this.getUsuario().setPassword(Encrypter.encriptar(this.getUsuario().getPassword()));

//validar si ingreso contrasenas y si son iguales
            this.validarContrasena(this.getUsuario().getPassword());
            /*Creo un usuario de forma manual
             usuario.setApellido("Aguirre");
             usuario.setNombre("Franco");
             usuario.setUsuario("vouilloz");
             usuario.setPassword("123");*/
            usuarioRNLocal.create(this.getUsuario());
            sMensaje = "El Usuario fue guardado";
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

    public void edit() {

        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {
            //valida si el password no es vacion y si el password y la confirmacion so iguales
            this.validarContrasena(Encrypter.encriptar(this.getUsuario().getPassword()));
            this.getUsuario().setPassword(Encrypter.encriptar(this.getUsuario().getPassword()));
            usuarioRNLocal.edit(this.getUsuario());

            sMensaje = "El dato fue modificado";
            severity = FacesMessage.SEVERITY_INFO;

            //elimino y agrego  a la lista
            int iPos = this.getUsuarioLstBean().getLstUsuario().indexOf(this.getUsuario());

            this.getUsuarioLstBean().getLstUsuario().remove(iPos);
            this.getUsuarioLstBean().getLstUsuario().add(iPos, this.getUsuario());

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

    public void delete() {
        String sMensaje = "";
        FacesMessage fm;
        FacesMessage.Severity severity = null;
        try {

            usuarioRNLocal.remove(this.getUsuario());

            sMensaje = "El dato fue eliminado";
            severity = FacesMessage.SEVERITY_INFO;

            //remover de la lista
            this.getUsuarioLstBean().getLstUsuario().remove(this.getUsuario());

            this.getCbAction().setValue("Eliminar");
            this.getCbAction().setDisabled(true);

        } catch (Exception ex) {

            severity = FacesMessage.SEVERITY_ERROR;
            sMensaje = "Error: " + ex.getMessage();

        } finally {
            fm = new FacesMessage(severity, sMensaje, null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin delete

    
   
    public void limpiar() {
        this.setUsuario(new Usuarios());
        this.setbCamposSoloLectura(false);
    }//fin limpiar

    private void validarContrasena(String contrasena) throws Exception {

        if (contrasena.isEmpty()) {
            throw new Exception("No ingreso la contraseña");
        }//fin if

      

        if (!contrasena.equals(Encrypter.encriptar(this.getsConfirmarContrasena()))) {
            throw new Exception("La contraseña y la confirmacion no son iguales");
        }
    }//fin validarContrasena
    
     public void clear() {
        usuario = new Usuarios();
        id = null;
    }
     public boolean isNew() {
        return usuario == null || usuario.getId() == null;
    }
}
