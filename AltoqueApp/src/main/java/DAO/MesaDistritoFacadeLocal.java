/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.MesaDistrito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface MesaDistritoFacadeLocal {

    void create(MesaDistrito mesaDistrito);

    void edit(MesaDistrito mesaDistrito);

    void remove(MesaDistrito mesaDistrito);

    MesaDistrito find(Object id);
    
     MesaDistrito findByMesa(Integer mesa);
     
     List<MesaDistrito> findByDistrito(String distrito);

    List<MesaDistrito> findAll();

    List<MesaDistrito> findRange(int[] range);

    int count();
    
}
