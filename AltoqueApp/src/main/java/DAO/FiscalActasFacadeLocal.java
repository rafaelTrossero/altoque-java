/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.FiscalActas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface FiscalActasFacadeLocal {

    void create(FiscalActas fiscalActas);

    void edit(FiscalActas fiscalActas);

    void remove(FiscalActas fiscalActas);

    FiscalActas find(Object id);

    List<FiscalActas> findAll();
    List<FiscalActas> findAllNoCargadas();
     List<FiscalActas>  findAllCargadas();
      List<FiscalActas>  findAllManual();


    List<FiscalActas> findRange(int[] range);
    

    
     FiscalActas findByIsCargadaTipo (String tipo, Integer mesa);
     
    

    int count();
    
}
