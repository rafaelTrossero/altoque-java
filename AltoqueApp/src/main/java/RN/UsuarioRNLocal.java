/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import Modelo.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface UsuarioRNLocal {
    
    public void create(Usuario u) throws Exception;

    public void edit(Usuario u, String contrasena) throws Exception;

    public void remove(Long idUsuario, Boolean bEstado) throws Exception;

    public void findAll();

    public List<Usuario> findUsuarios(String grupo) throws Exception;

    public Usuario findUserByNombreContrasena(String nombre, String contrasena) throws Exception;

    public void remove(Usuario usuario);

    public void edit(Usuario usuario);

    public Usuario findById(Integer id);
}
