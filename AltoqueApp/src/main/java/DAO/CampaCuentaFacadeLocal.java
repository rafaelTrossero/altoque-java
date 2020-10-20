/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.CampaCuenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface CampaCuentaFacadeLocal {

    void create(CampaCuenta campaCuenta);

    void edit(CampaCuenta campaCuenta);

    void remove(CampaCuenta campaCuenta);

    CampaCuenta find(Object id);

    List<CampaCuenta> findAll();

    List<CampaCuenta> findRange(int[] range);

    int count();
    
}
