/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Opciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface OpcionesFacadeLocal {

    void create(Opciones opciones);

    void edit(Opciones opciones);

    void remove(Opciones opciones);

    Opciones find(Object id);

    List<Opciones> findAll();

    List<Opciones> findRange(int[] range);

    int count();
    
}
