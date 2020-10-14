/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import com.github.adminfaces.starter.model.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author RafaTrossero
 */
@Local
public interface PersonaRNLocal {
    
    void create(Persona pro) throws Exception;

    void remove(Persona pro) throws Exception;

    void edit(Persona pro) throws Exception;

    List<Persona> findAll() throws Exception;

    public Persona findByDni(Integer dni) throws Exception;

    public void activate(Persona persona, Boolean bEstado) throws Exception;
    
    List<Persona> findAllActivo() throws Exception;
}
