/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.EstadoConfigWifi;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface EstadoConfigWifiFacadeLocal {

    void create(EstadoConfigWifi estadoConfigWifi);

    void edit(EstadoConfigWifi estadoConfigWifi);

    void remove(EstadoConfigWifi estadoConfigWifi);

    EstadoConfigWifi find(Object id);

    List<EstadoConfigWifi> findAll();

    List<EstadoConfigWifi> findRange(int[] range);

    int count();
    
}
