/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.EstadoConfigArlarma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface EstadoConfigArlarmaFacadeLocal {

    void create(EstadoConfigArlarma estadoConfigArlarma);

    void edit(EstadoConfigArlarma estadoConfigArlarma);

    void remove(EstadoConfigArlarma estadoConfigArlarma);

    EstadoConfigArlarma find(Object id);

    List<EstadoConfigArlarma> findAll();

    List<EstadoConfigArlarma> findRange(int[] range);

    int count();
    
}
