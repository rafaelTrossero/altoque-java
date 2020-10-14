/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Car;
import com.github.adminfaces.starter.model.PadronVv;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rat_5
 */
@Stateless
public class CarFacade extends AbstractFacade<Car> implements CarFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarFacade() {
        super(Car.class);
    }

    @Override
    public List<Car> findByPatente(String criterioBusqueda) {
        try {
           
            Query q = em.createNamedQuery("Car.findByPatente");
            q.setParameter("patente", criterioBusqueda);
           
            
            return (List<Car>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Car> findByMarca(String criterioBusqueda) {
        try {
           
            Query q = em.createNamedQuery("Car.findByMarca");
            q.setParameter("name", criterioBusqueda);
           
            
            return (List<Car>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Car> findByModelo(String criterioBusqueda) {
         try {
           
            Query q = em.createNamedQuery("Car.findByModelo");
            q.setParameter("model", criterioBusqueda);
           
            
            return (List<Car>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
}
