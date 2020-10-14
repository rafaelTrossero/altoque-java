/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import com.github.adminfaces.starter.model.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface PersonaFacadeLocal {

    void create(Persona persona);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);
     public Boolean bFindByDni(Persona p, int op) throws Exception;
     public Boolean bFindByCuil(Persona p, int op) throws Exception;
    int count();
    public void activate(Persona persona, Boolean bEstado);
     List<Persona> findAllActivo();
    
}
