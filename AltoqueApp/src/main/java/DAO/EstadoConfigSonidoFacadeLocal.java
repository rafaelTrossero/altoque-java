/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.EstadoConfigSonido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface EstadoConfigSonidoFacadeLocal {

    void create(EstadoConfigSonido estadoConfigSonido);

    void edit(EstadoConfigSonido estadoConfigSonido);

    void remove(EstadoConfigSonido estadoConfigSonido);

    EstadoConfigSonido find(Object id);

    List<EstadoConfigSonido> findAll();

    List<EstadoConfigSonido> findRange(int[] range);

    int count();
    
}
