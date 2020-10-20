/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuarios);

    void edit(Usuario usuarios);

    void remove(Usuario usuarios);

    Usuario find(Object id);

    List<Usuario> findAll();
    
     List<Usuario> findAllActive();

    List<Usuario> findRange(int[] range);

    int count();

    Usuario findUserByNombreContrasena(String nombre, String contrasena);
    
     public Usuario findById(Integer id);

}
