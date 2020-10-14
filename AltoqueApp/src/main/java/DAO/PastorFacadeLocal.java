/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Pastor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface PastorFacadeLocal {

    void create(Pastor pastor);

    void edit(Pastor pastor);

    void remove(Pastor pastor);

    Pastor find(Object id);

    List<Pastor> findAll();

    List<Pastor> findRange(int[] range);

    int count();
    
     List<Pastor> findByIsActive(boolean isActive);
    
}
