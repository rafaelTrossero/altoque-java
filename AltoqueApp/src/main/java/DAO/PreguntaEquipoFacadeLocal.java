/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PreguntaEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface PreguntaEquipoFacadeLocal {

    void create(PreguntaEquipo preguntaEquipo);

    void edit(PreguntaEquipo preguntaEquipo);

    void remove(PreguntaEquipo preguntaEquipo);

    PreguntaEquipo find(Object id);

    List<PreguntaEquipo> findAll();

    List<PreguntaEquipo> findRange(int[] range);

    int count();
    
}
