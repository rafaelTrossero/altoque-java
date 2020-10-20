/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.UsuarioFacadeLocal;
import Modelo.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author rat_5
 */
@Stateless
public class UsuarioRN implements UsuarioRNLocal {

    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;

    public void create(Usuario u) throws Exception {
        usuarioFacadeLocal.create(u);
    }

    @Override
    public void edit(Usuario u, String contrasena) throws Exception {
        usuarioFacadeLocal.edit(u);
    }

    @Override
    public void remove(Long idUsuario, Boolean bEstado) throws Exception {

    }

    @Override
    public void findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> findUsuarios(String grupo) throws Exception {
        return usuarioFacadeLocal.findAllActive();
    }

    @Override
    public Usuario findUserByNombreContrasena(String nombre, String contrasena) throws Exception {
        return usuarioFacadeLocal.findUserByNombreContrasena(nombre, contrasena);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void remove(Usuario usuario) {
        usuarioFacadeLocal.remove(usuario);
    }

    @Override
    public void edit(Usuario usuario) {
        usuarioFacadeLocal.edit(usuario);
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioFacadeLocal.findById(id);
    }

}

