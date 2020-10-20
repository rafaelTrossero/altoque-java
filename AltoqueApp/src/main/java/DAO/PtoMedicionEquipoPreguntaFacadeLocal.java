/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.PtoMedicionEquipoPregunta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface PtoMedicionEquipoPreguntaFacadeLocal {

    void create(PtoMedicionEquipoPregunta ptoMedicionEquipoPregunta);

    void edit(PtoMedicionEquipoPregunta ptoMedicionEquipoPregunta);

    void remove(PtoMedicionEquipoPregunta ptoMedicionEquipoPregunta);

    PtoMedicionEquipoPregunta find(Object id);

    List<PtoMedicionEquipoPregunta> findAll();

    List<PtoMedicionEquipoPregunta> findRange(int[] range);

    int count();
    
}
