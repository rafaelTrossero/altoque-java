/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.MultimediaEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface MultimediaEquipoFacadeLocal {

    void create(MultimediaEquipo multimediaEquipo);

    void edit(MultimediaEquipo multimediaEquipo);

    void remove(MultimediaEquipo multimediaEquipo);

    MultimediaEquipo find(Object id);

    List<MultimediaEquipo> findAll();

    List<MultimediaEquipo> findRange(int[] range);

    int count();
    
}
