/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.Fiscal;
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
public class FiscalFacade extends AbstractFacade<Fiscal> implements FiscalFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FiscalFacade() {
        super(Fiscal.class);
    }

    @Override
    public List<Fiscal> findByIsActive() {
          try {
            Query q = em.createNamedQuery("Fiscal.findByIsActive");

            q.setParameter("isActive", true);
            em.getEntityManagerFactory().getCache().evictAll();
            return (List<Fiscal>) q.getResultList();

        } catch (Exception e) {
            return null;
        }
    }
    
}
