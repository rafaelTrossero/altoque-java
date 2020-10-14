/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;


import com.github.adminfaces.starter.model.PermisosComando;
import com.github.adminfaces.starter.service.FiscalService;
import com.github.adminfaces.starter.service.PermisoComandoService;
import static com.github.adminfaces.starter.util.Utils.addDetailMessage;
import static com.github.adminfaces.template.util.Assert.has;
import java.io.IOException;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;

/**
 *
 * @author USUARIO
 */
@Named
@ViewScoped
public class PermisoComandoFormMB implements Serializable  {
    
    private Integer id;
    private PermisosComando permisosComando;

    @Inject
    PermisoComandoService permisosComandoService;

    public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(id)) {
            permisosComando = permisosComandoService.findById(id);
        } else {
            permisosComando = new PermisosComando();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PermisosComando getPermisosComando() {
        return permisosComando;
    }

    public void setPermisosComando(PermisosComando permisosComando) {
        this.permisosComando = permisosComando;
    }

    public PermisoComandoService getPermisosComandoService() {
        return permisosComandoService;
    }

    public void setPermisosComandoService(PermisoComandoService permisosComandoService) {
        this.permisosComandoService = permisosComandoService;
    }



    public void remove() throws IOException {
        if (has(permisosComando) && has(permisosComando.getId())) {
            permisosComandoService.remove(permisosComando);
            addDetailMessage("permisosComando de " + permisosComando.getApeNom()
                    + " ha sido desactivado");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("pages/permiso-comando-list.xhtml");
        }
    }

    public void save() {
        String msg;
        if (permisosComando.getId() == null) {
            permisosComandoService.insert(permisosComando);
            msg = "permisosComando de " + permisosComando.getApeNom() + " created successfully";
        } else {
            permisosComandoService.update(permisosComando);
            msg = "permisosComando de " + permisosComando.getApeNom() + " updated successfully";
        }
        addDetailMessage(msg);
    }

    public void clear() {
        permisosComando = new PermisosComando();
        id = null;
    }

    public boolean isNew() {
        return permisosComando == null || permisosComando.getId() == null;
    }
    
}
