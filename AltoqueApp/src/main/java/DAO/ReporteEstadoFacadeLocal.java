/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ReporteEstado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface ReporteEstadoFacadeLocal {

    void create(ReporteEstado reporteEstado);

    void edit(ReporteEstado reporteEstado);

    void remove(ReporteEstado reporteEstado);

    ReporteEstado find(Object id);

    List<ReporteEstado> findAll();

    List<ReporteEstado> findRange(int[] range);

    int count();
    
}
