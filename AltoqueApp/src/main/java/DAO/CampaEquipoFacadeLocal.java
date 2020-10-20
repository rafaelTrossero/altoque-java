/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.CampaEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface CampaEquipoFacadeLocal {

    void create(CampaEquipo campaEquipo);

    void edit(CampaEquipo campaEquipo);

    void remove(CampaEquipo campaEquipo);

    CampaEquipo find(Object id);

    List<CampaEquipo> findAll();

    List<CampaEquipo> findRange(int[] range);

    int count();
    
}
