/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adminfaces.starter.bean;

import com.github.adminfaces.starter.model.Fiscal;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.service.FiscalService;
import com.github.adminfaces.starter.service.PastorService;
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
public class FiscalFormMB implements Serializable  {
     private Integer id;
    private Fiscal fiscal;

    @Inject
    FiscalService fiscalService;

    public void init() {
        if(Faces.isAjaxRequest()){
           return;
        }
        if (has(id)) {
            fiscal = fiscalService.findById(id);
        } else {
            fiscal = new Fiscal();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fiscal getFiscal() {
        return fiscal;
    }

    public void setFiscal(Fiscal fiscal) {
        this.fiscal = fiscal;
    }

    public FiscalService getFiscalService() {
        return fiscalService;
    }

    public void setFiscalService(FiscalService fiscalService) {
        this.fiscalService = fiscalService;
    }

    public void remove() throws IOException {
        if (has(fiscal) && has(fiscal.getId())) {
            fiscalService.remove(fiscal);
            addDetailMessage("fiscal " + fiscal.getApeNom()
                    + " ha sido desactivado");
            Faces.getFlash().setKeepMessages(true);
            Faces.redirect("pages/fiscal-list.xhtml");
        }
    }

    public void save() {
        String msg;
        if (fiscal.getId() == null) {
            fiscalService.insert(fiscal);
            msg = "fiscal " + fiscal.getApeNom() + " created successfully";
        } else {
            fiscalService.update(fiscal);
            msg = "fiscal " + fiscal.getApeNom() + " updated successfully";
        }
        addDetailMessage(msg);
    }

    public void clear() {
        fiscal = new Fiscal();
        id = null;
    }

    public boolean isNew() {
        return fiscal == null || fiscal.getId() == null;
    }
    
}
