/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import com.github.adminfaces.starter.model.Usuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vouilloz
 */
@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();
    
     List<Usuarios> findAllActive();

    List<Usuarios> findRange(int[] range);

    int count();

    Usuarios findUserByNombreContrasena(String nombre, String contrasena);
    
     public Usuarios findById(Integer id);

}
