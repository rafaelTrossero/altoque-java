/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.MultimediaPtoMedicion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface MultimediaPtoMedicionFacadeLocal {

    void create(MultimediaPtoMedicion multimediaPtoMedicion);

    void edit(MultimediaPtoMedicion multimediaPtoMedicion);

    void remove(MultimediaPtoMedicion multimediaPtoMedicion);

    MultimediaPtoMedicion find(Object id);

    List<MultimediaPtoMedicion> findAll();

    List<MultimediaPtoMedicion> findRange(int[] range);

    int count();
    
}
