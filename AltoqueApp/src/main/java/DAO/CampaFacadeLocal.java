/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Campa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface CampaFacadeLocal {

    void create(Campa campa);

    void edit(Campa campa);

    void remove(Campa campa);

    Campa find(Object id);

    List<Campa> findAll();

    List<Campa> findRange(int[] range);

    int count();
    
}
