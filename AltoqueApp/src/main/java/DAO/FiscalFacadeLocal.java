/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Fiscal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface FiscalFacadeLocal {

    void create(Fiscal fiscal);

    void edit(Fiscal fiscal);

    void remove(Fiscal fiscal);

    Fiscal find(Object id);

    List<Fiscal> findAll();
    
    List<Fiscal> findByIsActive();

    List<Fiscal> findRange(int[] range);

    int count();
    
}
