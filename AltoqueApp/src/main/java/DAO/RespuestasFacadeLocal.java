/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Respuestas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface RespuestasFacadeLocal {

    void create(Respuestas respuestas);

    void edit(Respuestas respuestas);

    void remove(Respuestas respuestas);

    Respuestas find(Object id);

    List<Respuestas> findAll();

    List<Respuestas> findRange(int[] range);

    int count();
    
}
