package com.github.adminfaces.starter.infra.security;

import RN.UsuariosRNLocal;
import com.github.adminfaces.starter.model.Usuarios;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import recursos.Encrypter;

@ApplicationScoped
public class CustomInMemoryIdentityStore implements IdentityStore {

    @Inject
    private LogonMB logonMB;
    @EJB
    private UsuariosRNLocal usuariosRNLocal;
     private String user;
    private String password;    
    
    @Override
    public CredentialValidationResult validate(Credential credential) {
        try {
            
            
            UsernamePasswordCredential login = (UsernamePasswordCredential) credential;
            
            Usuarios usuAux = usuariosRNLocal.findUserByNombreContrasena(login.getCaller(), Encrypter.encriptar(login.getPasswordAsString()));
           
            if (login.getCaller().equals(usuAux.getUsuario()) && Encrypter.encriptar(login.getPasswordAsString()).equals(usuAux.getPassword()) && usuAux.getTipousuario().equals("ADMINISTRADOR")) {
                System.out.println("es SUPER USUARIO:::"+ usuAux.getIsSuper());
                if(usuAux.getIsSuper().equals(true)){
                logonMB.setSuperUser(Boolean.TRUE);}
                return new CredentialValidationResult("admin", new HashSet<>(Arrays.asList("ADMIN")));
                
            } else if (login.getCaller().equals(usuAux.getUsuario()) && Encrypter.encriptar(login.getPasswordAsString()).equals(usuAux.getPassword()) && usuAux.getTipousuario().equals("USER"))  {
                return new CredentialValidationResult("user", new HashSet<>(Arrays.asList("USER")));
            } else {
                return CredentialValidationResult.INVALID_RESULT;
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomInMemoryIdentityStore.class.getName()).log(Level.SEVERE, null, ex);
        }
         return CredentialValidationResult.INVALID_RESULT;
    }

    public UsuariosRNLocal getUsuariosRNLocal() {
        return usuariosRNLocal;
    }

    public void setUsuariosRNLocal(UsuariosRNLocal usuariosRNLocal) {
        this.usuariosRNLocal = usuariosRNLocal;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
