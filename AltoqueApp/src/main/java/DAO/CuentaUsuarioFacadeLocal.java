/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.CuentaUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface CuentaUsuarioFacadeLocal {

    void create(CuentaUsuario cuentaUsuario);

    void edit(CuentaUsuario cuentaUsuario);

    void remove(CuentaUsuario cuentaUsuario);

    CuentaUsuario find(Object id);

    List<CuentaUsuario> findAll();

    List<CuentaUsuario> findRange(int[] range);

    int count();
    
}
