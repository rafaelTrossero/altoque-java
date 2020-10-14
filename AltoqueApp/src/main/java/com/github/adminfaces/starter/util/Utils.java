package com.github.adminfaces.starter.util;

import RN.UsuariosRNLocal;

import com.github.adminfaces.starter.model.Usuarios;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.ejb.EJB;

/**
 * Created by rmpestano on 07/02/17.
 */
@ApplicationScoped
public class Utils implements Serializable {

   
    private List<Usuarios> users;
    
    @EJB
    private UsuariosRNLocal usuarioRNLocal;//hacemos la referencia para poder utilizar el metodo findall


    @PostConstruct
    public void init() {
 
      
        users = new ArrayList<>();
        try {
            this.setUsers(this.usuarioRNLocal.findUsuarios(null));
        } catch (Exception ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

  
    public void setUsers(List<Usuarios> users) {
        this.users = users;
    }

  

    public static void addDetailMessage(String message) {
        addDetailMessage(message, null);
    }

    public static void addDetailMessage(String message, FacesMessage.Severity severity) {

        FacesMessage facesMessage = Messages.create("").detail(message).get();
        if (severity != null && severity != FacesMessage.SEVERITY_INFO) {
            facesMessage.setSeverity(severity);
        }
        Messages.add(null, facesMessage);
    }

   
    @Produces
    public List<Usuarios> getUsers() {
        return users;
    }

}
