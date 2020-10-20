/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Sesiones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface SesionesFacadeLocal {

    void create(Sesiones sesiones);

    void edit(Sesiones sesiones);

    void remove(Sesiones sesiones);

    Sesiones find(Object id);

    List<Sesiones> findAll();

    List<Sesiones> findRange(int[] range);

    int count();
    
}
