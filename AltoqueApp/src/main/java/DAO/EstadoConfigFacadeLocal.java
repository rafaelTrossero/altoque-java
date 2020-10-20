/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.EstadoConfig;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface EstadoConfigFacadeLocal {

    void create(EstadoConfig estadoConfig);

    void edit(EstadoConfig estadoConfig);

    void remove(EstadoConfig estadoConfig);

    EstadoConfig find(Object id);

    List<EstadoConfig> findAll();

    List<EstadoConfig> findRange(int[] range);

    int count();
    
}
