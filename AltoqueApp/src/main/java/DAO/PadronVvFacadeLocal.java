/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.starter.model.PadronVv;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author USUARIO
 */
@Local
public interface PadronVvFacadeLocal {

    void create(PadronVv padronVv);

    void edit(PadronVv padronVv);

    void editVinculado(PadronVv padronVv);

    void remove(PadronVv padronVv);

    PadronVv find(Object id);

    PadronVv findByDni(Integer dni);

    List<PadronVv> findByDniList(Integer dni);

    List<PadronVv> findByApenom(String apenom);

    List<PadronVv> findByOrden(Integer orden);

    List<PadronVv> findAll();

    List<PadronVv> findByAuto(Car car);

    List<PadronVv> findRange(int[] range);

    int count();

}
