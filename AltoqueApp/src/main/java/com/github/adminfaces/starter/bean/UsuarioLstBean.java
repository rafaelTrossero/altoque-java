/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import RN.UsuariosRNLocal;
import com.github.adminfaces.starter.infra.model.Filter;
import com.github.adminfaces.starter.model.Usuarios;
import com.github.adminfaces.starter.model.tipoUsuario;
import com.github.adminfaces.starter.service.UserService;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author vouilloz
 */
@Named
@ViewScoped
public class UsuarioLstBean implements Serializable {

    @Inject
    UserService userService;

    @EJB
    private UsuariosRNLocal usuarioRNLocal;//hacemos la referencia para poder utilizar el metodo findall

    LazyDataModel<Usuarios> users;
    Integer id;
    Filter<Usuarios> filter = new Filter<>(new Usuarios());
    private List<Usuarios> selectedUsuario;
    List<Usuarios> filteredValue;// datatable filteredValue attribute (column filters)

    private List<Usuarios> lstUsuario; //Cargamos la lista de Usuarios retornada po el metodo findAll del usuarioRNLocal
    private List<SelectItem> lstSIUsuario;//Aca se guarda el item seleccionado de la lista

    private tipoUsuario lstTipoUsuario;
    private List<SelectItem> lstSITipoUsuario;

    private int iActionBtnSelect;

    @PostConstruct
    public void initDataModel() {
        userService.cargarUsuario();
        this.setLstUsuario(userService.getAllUsers());
    
       
        this.cargar_SI_tipoUsuario();
    }

    public void clear() {
        filter = new Filter<Usuarios>(new Usuarios());
    }

    public void delete() {
        int numCars = 0;
        for (Usuarios selectedUser : selectedUsuario) {
            numCars++;
            userService.remove(selectedUser);
        }
        selectedUsuario.clear();
        addDetailMessage(numCars + " usuario borrado!");
    }

    public UsuariosRNLocal getUsuarioRNLocal() {
        return usuarioRNLocal;
    }

    public void setUsuarioRNLocal(UsuariosRNLocal usuarioRNLocal) {
        this.usuarioRNLocal = usuarioRNLocal;
    }

    public List<Usuarios> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(List<Usuarios> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public List<SelectItem> getLstSIUsuario() {
        return lstSIUsuario;
    }

    public void setLstSIUsuario(List<SelectItem> lstSIUsuario) {
        this.lstSIUsuario = lstSIUsuario;
    }

    public tipoUsuario getLstTipoUsuario() {
        return lstTipoUsuario;
    }

    public void setLstTipoUsuario(tipoUsuario lstTipoUsuario) {
        this.lstTipoUsuario = lstTipoUsuario;
    }

    public List<SelectItem> getLstSITipoUsuario() {
        return lstSITipoUsuario;
    }

    public void setLstSITipoUsuario(List<SelectItem> lstSITipoUsuario) {
        this.lstSITipoUsuario = lstSITipoUsuario;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public LazyDataModel<Usuarios> getUsers() {
        return users;
    }

    public void setUsers(LazyDataModel<Usuarios> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Filter<Usuarios> getFilter() {
        return filter;
    }

    public void setFilter(Filter<Usuarios> filter) {
        this.filter = filter;
    }

    public List<Usuarios> getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(List<Usuarios> selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public List<Usuarios> getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(List<Usuarios> filteredValue) {
        this.filteredValue = filteredValue;
    }

    public int getiActionBtnSelect() {
        return iActionBtnSelect;
    }

    public void setiActionBtnSelect(int iActionBtnSelect) {
        this.iActionBtnSelect = iActionBtnSelect;
    }

    public void cargarUsuario() {
        try {
            this.setLstUsuario(this.usuarioRNLocal.findUsuarios(null));
        } catch (Exception ex) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error: " + ex,
                    null);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, fm);
        }
    }//fin cargarUsuario

    public void cargar_SI_tipoUsuario() {
        this.setLstSITipoUsuario(new ArrayList<SelectItem>());

        for (tipoUsuario d : tipoUsuario.values()) {
            SelectItem si = new SelectItem(d, d.getName());
            this.getLstSITipoUsuario().add(si);

        }
    }//fin for

}
