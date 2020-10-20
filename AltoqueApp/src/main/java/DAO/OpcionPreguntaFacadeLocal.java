/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.OpcionPregunta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface OpcionPreguntaFacadeLocal {

    void create(OpcionPregunta opcionPregunta);

    void edit(OpcionPregunta opcionPregunta);

    void remove(OpcionPregunta opcionPregunta);

    OpcionPregunta find(Object id);

    List<OpcionPregunta> findAll();

    List<OpcionPregunta> findRange(int[] range);

    int count();
    
}
