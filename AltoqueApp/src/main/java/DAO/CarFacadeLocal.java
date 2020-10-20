/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Car;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rat_5
 */
@Local
public interface CarFacadeLocal {

    void create(Car car);

    void edit(Car car);

    void remove(Car car);

    Car find(Object id);

    List<Car> findAll();

    List<Car> findRange(int[] range);

    int count();

    public List<Car> findByPatente(String criterioBusqueda);

    public List<Car> findByMarca(String criterioBusqueda);

    public List<Car> findByModelo(String criterioBusqueda);
    
}
