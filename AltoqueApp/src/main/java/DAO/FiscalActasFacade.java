/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.github.adminfaces.starter.model.FiscalActas;
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
public class FiscalActasFacade extends AbstractFacade<FiscalActas> implements FiscalActasFacadeLocal {

    @PersistenceContext(unitName = "notificacionVotantesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FiscalActasFacade() {
        super(FiscalActas.class);
    }

    @Override
    public FiscalActas findByIsCargadaTipo(String tipo, Integer mesa) {

        try {
            Query q = em.createNamedQuery("FiscalActas.findByIsCargadaTipo");
            q.setParameter("tipo", tipo);
            q.setParameter("mesa", mesa);

            System.out.println("la q es ---" + q);
            return (FiscalActas) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<FiscalActas> findAllNoCargadas() {
        try {
            Query q = em.createNamedQuery("FiscalActas.findAllNoCargadas");
           em.getEntityManagerFactory().getCache().evictAll();
           return (List<FiscalActas>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    
     @Override
    public List<FiscalActas> findAllCargadas() {
        try {
            Query q = em.createNamedQuery("FiscalActas.findAllCargadas");
           em.getEntityManagerFactory().getCache().evictAll();
           return (List<FiscalActas>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

   

    @Override
    public List<FiscalActas> findAllManual() {
       try {
            Query q = em.createNamedQuery("FiscalActas.findAllManual");
           em.getEntityManagerFactory().getCache().evictAll();
           return (List<FiscalActas>) q.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

}
