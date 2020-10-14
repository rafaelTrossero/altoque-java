/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.starter.model.Pastor;
import com.github.adminfaces.starter.model.PastorCar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface PastorCarFacadeLocal {

    void create(PastorCar pastorCar);

    void edit(PastorCar pastorCar);

    void remove(PastorCar pastorCar);

    PastorCar find(Object id);

    List<PastorCar> findAll();

    List<PastorCar> findRange(int[] range);

    int count();

    public List<Car> findCarByPastor(Pastor pastorSelect);
    
}
