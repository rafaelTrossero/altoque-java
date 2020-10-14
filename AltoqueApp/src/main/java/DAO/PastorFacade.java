/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Pastor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class PastorFacade extends AbstractFacade<Pastor> implements PastorFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PastorFacade() {
        super(Pastor.class);
    }
    
     @Override
    public List<Pastor> findByIsActive(boolean isActive) {
    try {
           
            Query q = em.createNamedQuery("Pastor.findByIsActive");
            q.setParameter("isActive", isActive);
           em.getEntityManagerFactory().getCache().evictAll();
              return (List<Pastor>) q.getResultList();
         
        } catch (Exception e) {
            return null;
        }
    }
    
}
