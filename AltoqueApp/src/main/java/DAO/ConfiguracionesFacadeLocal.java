/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Configuraciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface ConfiguracionesFacadeLocal {

    void create(Configuraciones configuraciones);

    void edit(Configuraciones configuraciones);

    void remove(Configuraciones configuraciones);

    Configuraciones find(Object id);

    List<Configuraciones> findAll();

    List<Configuraciones> findRange(int[] range);

    int count();
    
}
