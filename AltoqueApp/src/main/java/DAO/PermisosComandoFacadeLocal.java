/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.PermisosComando;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface PermisosComandoFacadeLocal {

    void create(PermisosComando permisosComando);

    void edit(PermisosComando permisosComando);

    void remove(PermisosComando permisosComando);

    PermisosComando find(Object id);

    List<PermisosComando> findAll();

    List<PermisosComando> findRange(int[] range);

    int count();
    
}
