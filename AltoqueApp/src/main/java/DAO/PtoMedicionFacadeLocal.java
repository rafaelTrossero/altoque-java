/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PtoMedicion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface PtoMedicionFacadeLocal {

    void create(PtoMedicion ptoMedicion);

    void edit(PtoMedicion ptoMedicion);

    void remove(PtoMedicion ptoMedicion);

    PtoMedicion find(Object id);

    List<PtoMedicion> findAll();

    List<PtoMedicion> findRange(int[] range);

    int count();
    
}
