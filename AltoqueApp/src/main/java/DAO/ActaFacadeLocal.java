/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Acta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface ActaFacadeLocal {

    void create(Acta acta);

    void edit(Acta acta);

    void remove(Acta acta);

    Acta find(Object id);

    List<Acta> findAll();

    List<Acta> findRange(int[] range);

    int count();
    
}
