/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.CuentaEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface CuentaEquipoFacadeLocal {

    void create(CuentaEquipo cuentaEquipo);

    void edit(CuentaEquipo cuentaEquipo);

    void remove(CuentaEquipo cuentaEquipo);

    CuentaEquipo find(Object id);

    List<CuentaEquipo> findAll();

    List<CuentaEquipo> findRange(int[] range);

    int count();
    
}
