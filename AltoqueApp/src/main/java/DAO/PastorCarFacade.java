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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rat_5
 */
@Stateless
public class PastorCarFacade extends AbstractFacade<PastorCar> implements PastorCarFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PastorCarFacade() {
        super(PastorCar.class);
    }

    @Override
    public List<Car> findCarByPastor(Pastor pastor) {
        Query q = em.createNamedQuery("PastorCar.findCarByPastor");
        q.setParameter("pastor", pastor);
        return q.getResultList();
    }
     

}
