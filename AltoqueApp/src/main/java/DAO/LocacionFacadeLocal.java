/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Locacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface LocacionFacadeLocal {

    void create(Locacion locacion);

    void edit(Locacion locacion);

    void remove(Locacion locacion);

    Locacion find(Object id);

    List<Locacion> findAll();

    List<Locacion> findRange(int[] range);

    int count();
    
}
