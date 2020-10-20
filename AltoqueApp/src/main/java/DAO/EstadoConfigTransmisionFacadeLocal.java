/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.EstadoConfigTransmision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface EstadoConfigTransmisionFacadeLocal {

    void create(EstadoConfigTransmision estadoConfigTransmision);

    void edit(EstadoConfigTransmision estadoConfigTransmision);

    void remove(EstadoConfigTransmision estadoConfigTransmision);

    EstadoConfigTransmision find(Object id);

    List<EstadoConfigTransmision> findAll();

    List<EstadoConfigTransmision> findRange(int[] range);

    int count();
    
}
